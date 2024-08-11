package Interface;

import BD_Connect.BD_Locator;
import Logica.Empresa;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EmpresaManager {
    private JFrame parentFrame;
    private CrudTableButtons elPanel;
    private JPanel dataPnl;
    private JTable laTable;

    //JLabels
    private JLabel empresa_codeLbl;
    private JLabel empresa_nombreLbl;
    private JLabel empresa_addressLbl;
    private JLabel empresa_phoneLbl;
    private JLabel empresa_directorLbl;
    private JLabel empresa_gerenteLbl;
    private JLabel empresa_secretarioLbl;

    //TextFields
    private JTextField empresa_nameTxtF;
    private JTextField empresa_addressTxtF;
    private JTextField empresa_codeTxtF;
    private JTextField empresa_phoneTxtF;
    private JTextField empresa_DirectorGTxtF;
    private JTextField empresa_GerenteTxtF;
    private JTextField empresa_SecretarioSTxtF;

    private GridBagLayout elGridBgLayO;
    private GridBagConstraints laGridBgConstr;
    private String empesa_codeTbl;


    public EmpresaManager(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.elPanel = new CrudTableButtons("Gestionar Empresas", () -> {
            try {
                return BD_Locator.getEmpresaBD().SelectEmpresa();
            } catch (SQLException | ClassNotFoundException var1) {
                Exception exception = var1;
                exception.printStackTrace();
                return null;
            }
        });
        this.laTable = this.elPanel.getTableButtonsGenPnl().getTable();
        MainFrame.setStatus("Gestión de Empresas");
        this.setButtonsReady();
    }

    private void setButtonsReady() {
        //Insertar Buttons
        this.elPanel.getInsertButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                EmpresaManager.this.setInsertPanelReady(EmpresaManager.this.parentFrame);

                final GenericDialog genDiag = new GenericDialog(EmpresaManager.this.parentFrame, EmpresaManager.this.dataPnl, "Insertar empresa", "Insertar");
                genDiag.getGenBton().addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent actionEvent) {

                        String empresa_code = EmpresaManager.this.empresa_codeTxtF.getText();
                        String empresa_name = EmpresaManager.this.empresa_nameTxtF.getText();
                        String empresa_address = EmpresaManager.this.empresa_addressTxtF.getText();
                        String empresa_phone = EmpresaManager.this.empresa_phoneTxtF.getText();
                        String empresa_director = EmpresaManager.this.empresa_DirectorGTxtF.getText();
                        String empresa_gerente = EmpresaManager.this.empresa_GerenteTxtF.getText();
                        String empresa_secretario = EmpresaManager.this.empresa_SecretarioSTxtF.getText();

                        try {
                            //Crear nueva empresa
                            Empresa empresa = new Empresa(empresa_code, empresa_address, empresa_name,empresa_phone,
                                    empresa_director,empresa_gerente,empresa_secretario);

                            //Funcion SQL de insertar datos
                            BD_Locator.getEmpresaBD().CreateEmpresa(empresa.getCode(), empresa.getNombre(), empresa.getDireccion(),empresa.getTelefono(),
                                    empresa.getDirectorG(),empresa.getGerenteR(),empresa.getSecretarioS());

                            EmpresaManager.this.elPanel.getTableButtonsGenPnl().refreshTable(this);
                            genDiag.getDialog().dispose();

                        } catch (SQLException | ClassNotFoundException var6) {
                            Exception exception = var6;
                            exception.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al insertar", "Error", 0);
                        } catch (Exception var7) {
                            Exception e = var7;
                            e.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "No puede contener números", "Error", 0);
                        }

                    }
                });
                genDiag.setResizable(false);
                genDiag.setVisible(true);
            }
        });
        //Modificar Buttons
        this.elPanel.getModifyButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                EmpresaManager.this.setModifyPanelReady(EmpresaManager.this.parentFrame);
                final GenericDialog genDiag = new GenericDialog(EmpresaManager.this.parentFrame, EmpresaManager.this.dataPnl, "Modificar empresa", "Modificar");
                genDiag.getGenBton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {

                        String empresa_code = EmpresaManager.this.empresa_codeTxtF.getText();
                        String empresa_name = EmpresaManager.this.empresa_nameTxtF.getText();
                        String empresa_address = EmpresaManager.this.empresa_addressTxtF.getText();
                        String empresa_phone = EmpresaManager.this.empresa_phoneTxtF.getText();
                        String empresa_director = EmpresaManager.this.empresa_DirectorGTxtF.getText();
                        String empresa_gerente = EmpresaManager.this.empresa_GerenteTxtF.getText();
                        String empresa_secretario = EmpresaManager.this.empresa_SecretarioSTxtF.getText();
                        try {
                            Empresa empresa = new Empresa(empresa_code, empresa_address, empresa_name,empresa_phone,
                                    empresa_director,empresa_gerente,empresa_secretario);

                            BD_Locator.getEmpresaBD().UpdateEmpresa(empresa.getCode(), empresa.getNombre(), empresa.getDireccion(),empresa.getTelefono(),
                                    empresa.getDirectorG(),empresa.getGerenteR(),empresa.getSecretarioS());

                            EmpresaManager.this.elPanel.getTableButtonsGenPnl().refreshTable(this);
                            genDiag.getDialog().dispose();

                        } catch (SQLException | ClassNotFoundException var7) {
                            Exception exception = var7;
                            exception.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "Ocurrió un error al modificar", "Error", 0);
                        } catch (Exception var8) {
                            Exception e = var8;
                            e.printStackTrace();
                            JOptionPane.showInternalMessageDialog((Component)null, "No puede contener números", "Error", 0);
                        }

                    }
                });
                genDiag.setResizable(false);
                genDiag.setVisible(true);
            }
        });
        //Eliminar Buttons
        this.elPanel.getDelButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int[] rows = EmpresaManager.this.laTable.getSelectedRows();
                int[] var3 = rows;
                int var4 = rows.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    int i = var3[var5];

                    String empresa_code = EmpresaManager.this.laTable.getValueAt(i, 0).toString();

                    try {
                        BD_Locator.getEmpresaBD().DeleteEmpresa(empresa_code);
                    } catch (SQLException | ClassNotFoundException var9) {
                        JOptionPane.showInternalMessageDialog(MainFrame.getFrame(), "Ocurrió un error al eliminar", "Error", 0);
                    }
                }

                EmpresaManager.this.elPanel.getTableButtonsGenPnl().refreshTable(this);
            }
        });
        this.laTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                EmpresaManager.this.elPanel.getDelButton().setEnabled(true);
                if (EmpresaManager.this.laTable.getSelectedRows().length == 1) {
                    EmpresaManager.this.elPanel.getModifyButton().setEnabled(true);
                } else {
                    EmpresaManager.this.elPanel.getModifyButton().setEnabled(false);
                }

            }
        });
    }

    private void setInsertPanelReady(JFrame parentFrame) {
        this.elGridBgLayO = new GridBagLayout();
        this.laGridBgConstr = new GridBagConstraints();
        this.dataPnl = new JPanel(this.elGridBgLayO);

        this.empresa_codeLbl = new JLabel("Codigo de la empresa: ");
        this.empresa_codeTxtF = new JTextField(20);

        this.empresa_nombreLbl = new JLabel("Nombre de la empresa: ");
        this.empresa_nameTxtF = new JTextField(20);

        this.empresa_addressLbl = new JLabel("Direccion de la empresa: ");
        this.empresa_addressTxtF = new JTextField(20);

        this.empresa_phoneLbl = new JLabel("Telefono de la empresa: ");
        this.empresa_phoneTxtF = new JTextField(20);

        this.empresa_directorLbl = new JLabel("Director General de la empresa: ");
        this.empresa_DirectorGTxtF = new JTextField(20);

        this.empresa_gerenteLbl = new JLabel("Gerente de Recursos de la empresa: ");
        this.empresa_GerenteTxtF = new JTextField(20);

        this.empresa_secretarioLbl = new JLabel("Secretario del Sindicato de la empresa: ");
        this.empresa_SecretarioSTxtF = new JTextField(20);

        this.dataPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "autor"));
        this.laGridBgConstr.weightx = 888.0;
        this.laGridBgConstr.fill = 2;

        this.addComponent(this.empresa_codeLbl, 0, 0, 1, 1);
        this.addComponent(this.empresa_codeTxtF, 0, 1, 1, 1);

        this.addComponent(this.empresa_nombreLbl, 1, 0, 1, 1);
        this.addComponent(this.empresa_nameTxtF, 1, 1, 1, 1);

        this.addComponent(this.empresa_addressLbl,2 ,0 , 1, 1);
        this.addComponent(this.empresa_addressTxtF, 2,1 , 1, 1);

        this.addComponent(this.empresa_phoneLbl, 3, 0, 1, 1);
        this.addComponent(this.empresa_phoneTxtF, 3, 1, 1, 1);

        this.addComponent(this.empresa_directorLbl, 4, 0, 1, 1);
        this.addComponent(this.empresa_DirectorGTxtF, 4, 1, 1, 1);

        this.addComponent(this.empresa_gerenteLbl, 5, 0, 1, 1);
        this.addComponent(this.empresa_GerenteTxtF, 5, 1, 1, 1);

        this.addComponent(this.empresa_secretarioLbl, 6, 0, 1, 1);
        this.addComponent(this.empresa_SecretarioSTxtF, 6, 1, 1, 1);

    }

    private void setModifyPanelReady(JFrame parentFrame) {
        this.setInsertPanelReady(parentFrame);
        int row = this.laTable.getSelectedRow();
        this.empesa_codeTbl = this.laTable.getValueAt(row, 0).toString();
        this.empresa_nameTxtF.setText((String)this.laTable.getValueAt(row, 1));
        this.empresa_addressTxtF.setText((String)this.laTable.getValueAt(row, 2));
        this.empresa_phoneTxtF.setText((String)this.laTable.getValueAt(row, 3));
        this.empresa_DirectorGTxtF.setText((String)this.laTable.getValueAt(row, 4));
        this.empresa_GerenteTxtF.setText((String)this.laTable.getValueAt(row, 5));
        this.empresa_SecretarioSTxtF.setText((String)this.laTable.getValueAt(row, 6));
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
