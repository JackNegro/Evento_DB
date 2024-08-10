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
        laMenuBar.add(sessionMenu);
        statusBarPnl.add(statusLbl);
    }

    public static void setAdminComponentsReady() {
        JMenuItem subjectMItem = new JMenuItem("Materia");
        JMenuItem userMItem = new JMenuItem("Usuarios");
        JMenuItem booksMItem = new JMenuItem("Libros");
        JMenuItem copyMItem = new JMenuItem("Copias");
        JMenuItem authorMItem = new JMenuItem("Autores");
        JMenuItem loanMItem = new JMenuItem("Préstamos");
        adminMenu = new JMenu("Administrar");
        subjectMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       // new SubjectManager(MainFrame.elFrame);
                    }
                });
            }
        });
        booksMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       // new BookManager(MainFrame.elFrame);
                    }
                });
            }
        });
        copyMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                      //  new CopyManager(MainFrame.elFrame);
                    }
                });
            }
        });
        authorMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new AuthorManager(MainFrame.elFrame);
            }
        });
        userMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UserManager(MainFrame.elFrame);
            }
        });
        loanMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new LoanManager(MainFrame.elFrame);
            }
        });
        manageMenu.remove(0);
        manageMenu.add(loanMItem);
        manageMenu.add(userMItem);
        manageMenu.add(authorMItem);
        manageMenu.add(copyMItem);
        manageMenu.add(booksMItem);
        manageMenu.add(subjectMItem);
        adminMenu.add(userMItem);
        laMenuBar.add(adminMenu);
    }

    public static void setFrameReady() {
        elFrame = new JFrame("Biblioteca");
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
