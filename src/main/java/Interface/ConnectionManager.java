package Interface;

import BD_Connect.BD_Locator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConnectionManager {
    private JPanel dataPnl;
    private JLabel dbNameLbl;
    private JLabel dbUserNLbl;
    private JLabel dbPasswLbl;
    private JLabel dbServAddrLbl;
    private JTextField dbNameTxtF;
    private JTextField dbUserNTxtF;
    private JTextField dbServAddrTxtF;
    private JPasswordField dbPasswPasswF;
    private GridBagLayout elGridBgLayO;
    private GridBagConstraints laGridBgConstr;

    public ConnectionManager(JFrame parentFrame) {
        this.setFrameReady(parentFrame);
    }

    private void setComponentsReady() {
        this.elGridBgLayO = new GridBagLayout();
        this.laGridBgConstr = new GridBagConstraints();
        this.dataPnl = new JPanel(this.elGridBgLayO);
        this.dbServAddrLbl = new JLabel("Dirección del servidor: ");
        this.dbNameLbl = new JLabel("Nombre de la base de datos: ");
        this.dbUserNLbl = new JLabel("Nombre de usuario: ");
        this.dbPasswLbl = new JLabel("Contraseña: ");
        this.dbServAddrTxtF = new JTextField("localhost");
        this.dbNameTxtF = new JTextField(10);
        this.dbUserNTxtF = new JTextField("postgres", 10);
        this.dbPasswPasswF = new JPasswordField();
        this.dataPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Conexión a la base de datos"));
        this.laGridBgConstr.weightx = 888.0;
        this.laGridBgConstr.fill = 2;
        this.addComponent(this.dbServAddrLbl, 0, 0, 1, 1);
        this.addComponent(this.dbServAddrTxtF, 0, 1, 1, 1);
        this.addComponent(this.dbNameLbl, 1, 0, 1, 1);
        this.addComponent(this.dbNameTxtF, 1, 1, 1, 1);
        this.addComponent(this.dbUserNLbl, 2, 0, 1, 1);
        this.addComponent(this.dbUserNTxtF, 2, 1, 1, 1);
        this.addComponent(this.dbPasswLbl, 3, 0, 1, 1);
        this.addComponent(this.dbPasswPasswF, 3, 1, 1, 1);
    }

    private void setFrameReady(JFrame parentFrame) {
        this.setComponentsReady();
        final GenericDialog elDialog = new GenericDialog(parentFrame, this.dataPnl, "Configurar conexión", "Configurar");
        elDialog.getGenBton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String serverAddress = ConnectionManager.this.dbServAddrTxtF.getText();
                    String dbName = ConnectionManager.this.dbNameTxtF.getText();
                    String userName = ConnectionManager.this.dbUserNTxtF.getText();
                    String password = new String(ConnectionManager.this.dbPasswPasswF.getPassword());
                    BD_Locator.configureConnection(serverAddress, dbName, userName, password);
                    elDialog.getDialog().dispose();
                } catch (SQLException | ClassNotFoundException var6) {
                    Exception exception = var6;
                    exception.printStackTrace();
                    JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al configurar", "Error", 0);
                }

            }
        });
        elDialog.setResizable(false);
        elDialog.setVisible(true);
    }

    private void addComponent(Component component, int row, int column, int width, int height) {
        this.laGridBgConstr.gridx = column;
        this.laGridBgConstr.gridy = row;
        this.laGridBgConstr.gridwidth = width;
        this.laGridBgConstr.gridheight = height;
        this.elGridBgLayO.setConstraints(component, this.laGridBgConstr);
        this.dataPnl.add(component);
    }
}
