package Interface;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.regex.PatternSyntaxException;

public class TableButtonsGenPnl extends JPanel {
    private JPanel tablePnl;
    private JPanel refreshPnl;
    private JPanel buttonPnl;
    private JPanel southPnl;
    private JTable laTable;
    private JLabel filterLbl;
    private JButton filterBton;
    private JButton refreshBton;
    private JTextField filterTxtF;
    private JScrollPane elScrollPn;
    private ActionListener refreshAction;
    private TableRowSorter<TableModel> elSorter;
    private ResultSetTableModel elTableModel;
    private Box filterBox = Box.createHorizontalBox();

    public TableButtonsGenPnl(String name, Supplier<ResultSet> querySupl, JPanel topPnl, JButton[] buttons) {
        try {
            this.setActionReady(querySupl);
            this.setComponentsReady(querySupl, topPnl, buttons);
            this.setPanelReady(name);
        } catch (SQLException var6) {
            SQLException sqlException = var6;
            sqlException.printStackTrace();
        }

    }

    public void refreshTable(Object source) {
        this.refreshAction.actionPerformed(new ActionEvent(source, 1001, (String)null));
    }

    private void setActionReady(final Supplier<ResultSet> querySupl) {
        this.refreshAction = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    TableButtonsGenPnl.this.elTableModel.setResultSet((ResultSet)querySupl.get());
                } catch (SQLException var3) {
                    SQLException sqlException = var3;
                    sqlException.printStackTrace();
                }

            }
        };
    }

    private void setComponentsReady(Supplier<ResultSet> querySupl, JPanel topPnl, JButton[] buttons) throws SQLException {
        this.elTableModel = new ResultSetTableModel((ResultSet)querySupl.get());
        this.laTable = new JTable((TableModel) this.elTableModel);
        this.elSorter = new TableRowSorter((TableModel) this.elTableModel);
        this.elScrollPn = new JScrollPane(this.laTable);
        this.tablePnl = new JPanel(new BorderLayout());
        this.refreshPnl = new JPanel(new FlowLayout(0));
        this.buttonPnl = new JPanel(new FlowLayout(2));
        this.southPnl = new JPanel(new BorderLayout());
        this.filterLbl = new JLabel("Filtrar: ");
        this.filterBton = new JButton("Filtrar");
        this.refreshBton = new JButton("Refrescar");
        this.filterTxtF = new JTextField();
        this.laTable.setRowSorter(this.elSorter);
        this.filterBox.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Filtro"));
        this.filterTxtF.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                if (TableButtonsGenPnl.this.filterTxtF.getText().length() == 0) {
                    TableButtonsGenPnl.this.elSorter.setRowFilter((RowFilter)null);
                }

            }
        });
        this.filterBton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String text = TableButtonsGenPnl.this.filterTxtF.getText();
                text.toLowerCase();
                if (text.length() == 0) {
                    TableButtonsGenPnl.this.elSorter.setRowFilter((RowFilter)null);
                } else {
                    try {
                        TableButtonsGenPnl.this.elSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, new int[0]));
                    } catch (PatternSyntaxException var4) {
                        JOptionPane.showMessageDialog((Component)null, "Filtro incorrecto", "Filtro incorrecto. \nPor favor introduzca un filtro válido", 0);
                    }
                }

            }
        });
        this.refreshBton.addActionListener(this.refreshAction);
        this.filterBox.add(this.filterLbl);
        this.filterBox.add(this.filterTxtF);
        this.filterBox.add(this.filterBton);
        this.refreshPnl.add(this.refreshBton);
        if (topPnl != null) {
            this.tablePnl.add(topPnl, "North");
        }

        this.tablePnl.add(this.elScrollPn, "Center");

        for(int i = 0; i < buttons.length; ++i) {
            this.buttonPnl.add(buttons[i]);
        }

        this.southPnl.add(this.refreshPnl, "West");
        this.southPnl.add(this.buttonPnl, "East");
    }

    private void setPanelReady(String name) {
        MainFrame.setTitle(name);
        this.setLayout(new BorderLayout());
        this.add(this.filterBox, "North");
        this.add(this.tablePnl, "Center");
        this.add(this.southPnl, "South");
        MainFrame.setPanel(this);
        this.laTable.setAutoResizeMode(0);
    }

    public JPanel getButtonPnl() {
        return this.buttonPnl;
    }

    public JButton getRefreshBton() {
        return this.refreshBton;
    }

    public JTable getTable() {
        return this.laTable;
    }

    public ResultSetTableModel getElTableModel() {
        return this.elTableModel;
    }
}
