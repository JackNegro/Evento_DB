package Interface;

import BD_Connect.BD_Locator;
import Logica.User;
import Utils.Encription;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserManager {
    private JFrame parentFrame;
    private CrudTableButtons elPanel;
    private JPanel dataPnl;
    private JTable laTable;

    private JLabel user_roleLbl;
    private JLabel user_usernameLbl;
    private JLabel user_passwLbl;
    private JLabel user_passwCLbl;

    private JTextField user_usernameTxtF;
    private JPasswordField user_passwPassF;
    private JPasswordField user_passwCPassF;
    private JComboBox<String> user_roleComB;

    private GridBagLayout elGridBgLayO;
    private GridBagConstraints laGridBgConstr;

    public UserManager(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.elPanel = new CrudTableButtons("Gestionar usuarios", () -> {
            try {
                return BD_Locator.getUserBD().userAll();
            } catch (SQLException | ClassNotFoundException var1) {
                Exception exception = var1;
                exception.printStackTrace();
                return null;
            }
        });
        this.laTable = this.elPanel.getTableButtonsGenPnl().getTable();
        MainFrame.setStatus("Gestión de usuarios");
        this.setButtonsReady();
    }

    private void setButtonsReady() {
        this.elPanel.getInsertButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                UserManager.this.setInsertPanelReady();
                final GenericDialog genDiag = new GenericDialog(UserManager.this.parentFrame, UserManager.this.dataPnl, "Insertar usuario", "Insertar");
                genDiag.getGenBton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        String user_alias = UserManager.this.user_usernameTxtF.getText();
                        String user_pass = new String(UserManager.this.user_passwPassF.getPassword());
                        String encryptedPass = Encription.getSha256(user_pass);
                        int user_role = UserManager.this.user_roleComB.getSelectedIndex();

                        try {
                            User user = new User(user_alias,encryptedPass,user_role);
                            BD_Locator.getUserBD().createUser( user.getUsername(), user.getPassword(), user.getRole());
                            UserManager.this.elPanel.getTableButtonsGenPnl().refreshTable(this);
                            genDiag.getDialog().dispose();
                        } catch (SQLException | ClassNotFoundException var11) {
                            Exception exception = var11;
                            exception.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al insertar", "Error", 0);
                        } catch (Exception var12) {
                            Exception e = var12;
                            e.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al insertar", "Error", 0);
                        }
                    }
                });
                genDiag.setResizable(false);
                genDiag.setVisible(true);
            }
        });
        this.elPanel.getModifyButton().setVisible(false);
        this.elPanel.getDelButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int[] rows = UserManager.this.laTable.getSelectedRows();
                int[] var3 = rows;
                int var4 = rows.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    int i = var3[var5];
                    int user_ci = (int) UserManager.this.laTable.getValueAt(i, 0);

                    try {
                        BD_Locator.getUserBD().deleteUser(user_ci);
                        UserManager.this.elPanel.getTableButtonsGenPnl().refreshTable(this);
                    } catch (SQLException | ClassNotFoundException var9) {
                        JOptionPane.showInternalMessageDialog(MainFrame.getFrame(), "Ocurrió un error al eliminar", "Error", 0);
                    }
                }
            }
        });
        this.laTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (UserManager.this.laTable.getSelectedRows().length == 1) {
                    UserManager.this.elPanel.getDelButton().setEnabled(true);
                } else {
                    UserManager.this.elPanel.getDelButton().setEnabled(false);
                }
            }
        });
    }

    private void setInsertPanelReady() {
        this.setModifyPanelReady();
        this.user_usernameLbl = new JLabel("Nombre del usuario: ");
        this.user_usernameTxtF = new JTextField(15);
        this.addComponent(this.user_usernameLbl, 0, 0);
        this.addComponent(this.user_usernameTxtF, 0, 1);
    }

    private void setModifyPanelReady() {
        this.elGridBgLayO = new GridBagLayout();
        this.laGridBgConstr = new GridBagConstraints();
        this.dataPnl = new JPanel(this.elGridBgLayO);
        this.user_usernameLbl = new JLabel("Nombre de usuario: ");
        this.user_roleLbl = new JLabel("Rol de usuario: ");
        this.user_passwLbl = new JLabel("Contraseña: ");
        this.user_passwCLbl = new JLabel("Confirmar contraseña: ");
        this.user_usernameTxtF = new JTextField(15);
        this.user_passwPassF = new JPasswordField();
        this.user_passwCPassF = new JPasswordField();
        this.user_roleComB = new JComboBox<>();
        this.user_roleComB.addItem("0");
        this.user_roleComB.addItem("1");
        this.dataPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Usuario"));
        this.laGridBgConstr.weightx = 888.0;
        this.laGridBgConstr.fill = 2;

        this.addComponent(this.user_usernameLbl, 0, 0);
        this.addComponent(this.user_usernameTxtF, 0, 1);

        this.addComponent(this.user_roleLbl, 1, 0);
        this.addComponent(this.user_roleComB, 1, 1);

        this.addComponent(this.user_passwLbl, 2, 0);
        this.addComponent(this.user_passwPassF, 2, 1);

        this.addComponent(this.user_passwCLbl, 3, 0);
        this.addComponent(this.user_passwCPassF, 3, 1);
    }

    private void addComponent(Component component, int row, int column) {
        this.laGridBgConstr.gridx = column;
        this.laGridBgConstr.gridy = row;
        this.laGridBgConstr.gridwidth = 1;
        this.laGridBgConstr.gridheight = 1;
        this.elGridBgLayO.setConstraints(component, this.laGridBgConstr);
        this.dataPnl.add(component);
    }
}
