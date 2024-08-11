package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {
    private static JFrame elFrame;
    private static JPanel workAreaPnl;
    private static JPanel statusBarPnl;
    private static JMenu adminMenu;
    private static JMenu manageMenu;
    private static JMenu sessionMenu;
    private static JLabel statusLbl;
    private static JMenuBar laMenuBar;
    public static final int ADMIN_MODE = 0;
    public static final int USER_MODE = 1;

    public static void getMainFrame(int mode) {
        setUserComponentsReady();
        if (mode == 0) {
            setAdminComponentsReady();
        }

        setFrameReady();
        setStatus("Bienvenido");
    }

    public static void setUserComponentsReady() {
        new JMenuItem("Salir");
        JMenuItem prestMItem = new JMenuItem("Préstamos");
        new JMenuItem("Libros por autor");
        new JMenuItem("Libros por materia");
        JMenuItem closeSesMItem = new JMenuItem("Cerrar sessión");

        workAreaPnl = new JPanel();
        statusLbl = new JLabel();
        statusBarPnl = new JPanel(new FlowLayout(0));
        laMenuBar = new JMenuBar();
        manageMenu = new JMenu("Gestionar");
        sessionMenu = new JMenu("Sesión");

        statusBarPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        closeSesMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                LoginFrame.getLoginFrame();
                MainFrame.dispose();
            }
        });

        prestMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        //new BookViewer(MainFrame.elFrame);
                    }
                });
            }
        });

        manageMenu.add(prestMItem);
        sessionMenu.add(closeSesMItem);
        laMenuBar.add(manageMenu);
        statusBarPnl.add(statusLbl);
        laMenuBar.add(sessionMenu);

    }

    public static void setAdminComponentsReady() {
        JMenuItem empresaMItem = new JMenuItem("Empresas");
        JMenuItem usuarioMItem = new JMenuItem("Usuario");
        JMenuItem contratoMItem = new JMenuItem("Contratos");
        JMenuItem clienteMItem = new JMenuItem("Clientes");
        JMenuItem servicioMItem = new JMenuItem("Servicios");
        JMenuItem eventoMItem = new JMenuItem("Eventos");
        JMenuItem proveedorMItem = new JMenuItem("Proveedor");
        JMenuItem empleadoMItem = new JMenuItem("Empleado");

        adminMenu = new JMenu("Administrar");
        empresaMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       // new EmpresaManager(MainFrame.elFrame);
                    }
                });
            }
        });
        contratoMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       // new ContratoManager(MainFrame.elFrame);
                    }
                });
            }
        });
        clienteMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                      //  new ClienteManager(MainFrame.elFrame);
                    }
                });
            }
        });
        servicioMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new ServicioManager(MainFrame.elFrame);
            }
        });
        eventoMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new EventoManager(MainFrame.elFrame);
            }
        });

        usuarioMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UserManager(MainFrame.elFrame);
            }
        });

        //menu de manageBD
        manageMenu.remove(0);
        manageMenu.add(empresaMItem);
        manageMenu.add(empleadoMItem);
        manageMenu.add(eventoMItem);
        manageMenu.add(proveedorMItem);
        manageMenu.add(servicioMItem);
        manageMenu.add(clienteMItem);
        manageMenu.add(contratoMItem);
        //menu UserBD
        adminMenu.add(usuarioMItem);

        laMenuBar.add(adminMenu);
    }

    public static void setFrameReady() {
        elFrame = new JFrame("Gestion de Empresa");
        elFrame.add(workAreaPnl, "Center");
        elFrame.add(statusBarPnl, "South");
        elFrame.setJMenuBar(laMenuBar);
        elFrame.setPreferredSize(new Dimension(640, 480));
        elFrame.setMinimumSize(new Dimension(laMenuBar.getMinimumSize().width + 8, laMenuBar.getMinimumSize().height));
        elFrame.pack();
        elFrame.setLocationRelativeTo((Component)null);
        elFrame.setDefaultCloseOperation(0);
        elFrame.setVisible(true);
        elFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                int exit = JOptionPane.showConfirmDialog(MainFrame.elFrame, "¿Está seguro que desea salir?", "Confirmar", 0, 3);
                if (exit == 0) {
                    System.exit(0);
                }

            }
        });
    }

    public static JFrame getFrame() {
        return elFrame;
    }

    public static void setPanel(JPanel workArea) {
        elFrame.remove(workAreaPnl);
        workAreaPnl = workArea;
        elFrame.getContentPane().add(workAreaPnl, "Center");
        elFrame.revalidate();
    }

    public static void setTitle(String title) {
        elFrame.setTitle(title);
    }

    public static void setStatus(String status) {
        statusLbl.setText(status);
    }

    public static void dispose() {
        elFrame.dispose();
    }

}
