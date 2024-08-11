package Interface;

import BD_Connect.BD_Connect;
import BD_Connect.BD_Locator;
import Logica.User;
import Utils.Encription;
import Utils.Validation;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginFrame {
    private static JFrame elFrame;
    private static JPanel elPnl;
    private static JPanel buttonPnl;
    private static JMenu connectionMenu;
    private static JLabel userLbl;
    private static JLabel passwLbl;
    private static JButton acceptBton;
    private static JButton cancelBton;
    private static JMenuBar laMenuBar;
    private static JMenuItem changeConnectMItem;
    private static JTextField userTxtF;
    private static JPasswordField passwF;
    private static boolean validUser;
    private static boolean validPassw;
    private static User user;

    public LoginFrame() {
    }

    public static void main(String[] args) {
        getLoginFrame();
    }

    public static void getLoginFrame() {
        setComponentsReady();
        setPanelsReady();
        setFrameReady();
    }

    public static void setComponentsReady() {
        laMenuBar = new JMenuBar();
        connectionMenu = new JMenu("Conexión");
        changeConnectMItem = new JMenuItem("Configurar");
        userLbl = new JLabel("Usuario: ");
        passwLbl = new JLabel("Contraseña: ");
        acceptBton = new JButton("Aceptar");
        cancelBton = new JButton("Cancelar");
        userTxtF = new JTextField();
        passwF = new JPasswordField();
        validUser = false;
        validPassw = false;

        acceptBton.setEnabled(validUser && validPassw);
        userTxtF.setAutoscrolls(false);
        userTxtF.setToolTipText("El alias tiene que ser alfanumérico y tener entre 4 y 15 caracteres");
        passwF.setAutoscrolls(false);
        passwF.setToolTipText("La contraseña tiene que tener al menos 4 caracteres");
        userTxtF.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent caretEvent) {
                String userAlias = LoginFrame.userTxtF.getText();
                if (userAlias.length() >= 4 && Validation.userAliasValidation(userAlias)) {
                    LoginFrame.validUser = true;
                    LoginFrame.userLbl.setForeground(Color.BLACK);
                    LoginFrame.acceptBton.setEnabled(LoginFrame.validUser && LoginFrame.validPassw);
                } else {
                    LoginFrame.validUser = false;
                    LoginFrame.userLbl.setForeground(Color.RED);
                    LoginFrame.acceptBton.setEnabled(LoginFrame.validUser && LoginFrame.validPassw);
                }

            }
        });
        passwF.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent caretEvent) {
                if ((new String(LoginFrame.passwF.getPassword())).length() >= 5) {
                    LoginFrame.validPassw = true;
                    LoginFrame.passwLbl.setForeground(Color.BLACK);
                    LoginFrame.acceptBton.setEnabled(LoginFrame.validUser && LoginFrame.validPassw);
                } else {
                    LoginFrame.validPassw = false;
                    LoginFrame.passwLbl.setForeground(Color.RED);
                    LoginFrame.acceptBton.setEnabled(LoginFrame.validUser && LoginFrame.validPassw);
                }

            }
        });
        changeConnectMItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ConnectionManager(LoginFrame.elFrame);
                    }
                });
            }
        });
        acceptBton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame.getMainFrame(0);
                LoginFrame.dispose();

                /*
                LoginFrame.user = null;
                try {
                    LoginFrame.user = BD_Locator.getUserBD().getUserByUsername(LoginFrame.userTxtF.getText());
                    if (LoginFrame.user == null) {
                        JOptionPane.showInternalMessageDialog((Component) null, "El usuario no existe. \nPor favor, rectifíquelo.", "Error", 0);
                    } else {

                        String passw = new String(LoginFrame.passwF.getPassword());
                        String encriptedPassW = Encription.getSha256(passw);
                        if (encriptedPassW.equals(LoginFrame.user.getPassword())) {
                            boolean f = true;
                            if (f) {
                                MainFrame.getMainFrame(LoginFrame.user.getCode());
                                LoginFrame.dispose();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog((Component)null, "La contraseña es incorrecta.\n Por favor, rectifíquela.", "Error", 0);
                            LoginFrame.passwF.setText("");
                        }
                    }
                } catch (SQLException | ClassNotFoundException var8) {
                    Exception exception = var8;
                    exception.printStackTrace();
                    JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al comunicarse con la base de datos", "Error", 0);
                } catch (Exception var9) {
                    Exception e = var9;
                    throw new RuntimeException(e);
                }
                */
            }
        });

        cancelBton.addActionListener(ActionLocator.getCloseAction());
        connectionMenu.add(changeConnectMItem);
        laMenuBar.add(connectionMenu);
    }

    public static void setPanelsReady() {
        elPnl = new JPanel(new GridLayout(2, 2));
        buttonPnl = new JPanel(new GridLayout(1, 2));
        elPnl.add(userLbl, 0);
        elPnl.add(userTxtF, 1);
        elPnl.add(passwLbl, 2);
        elPnl.add(passwF, 3);
        buttonPnl.add(acceptBton, 0);
        buttonPnl.add(cancelBton, 1);
    }

    public static void setFrameReady() {
        elFrame = new JFrame("Iniciar sesión");
        elFrame.setJMenuBar(laMenuBar);
        elFrame.getContentPane().add(elPnl, "Center");
        elFrame.getContentPane().add(buttonPnl, "South");
        elFrame.setDefaultCloseOperation(0);
        elFrame.setPreferredSize(new Dimension(200, 125));
        elFrame.pack();
        elFrame.setResizable(false);
        elFrame.setLocationRelativeTo((Component)null);
        elFrame.setVisible(true);
        elFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                int exit = JOptionPane.showConfirmDialog(LoginFrame.elFrame, "¿Está seguro que desea salir?", "Confirmar", 0, 3);
                if (exit == 0) {
                    System.exit(0);
                }

            }
        });
    }

    public static User getActualUser() {
        return user;
    }

    public static void dispose() {
        elFrame.dispose();
    }

   }

