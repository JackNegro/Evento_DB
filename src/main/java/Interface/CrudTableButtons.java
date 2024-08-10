package Interface;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.function.Supplier;

public class CrudTableButtons {
    private JPanel elPanel;
    private JButton delBton;
    private JButton insertBton;
    private JButton modifyBton;
    private JButton[] buttons;
    private TableButtonsGenPnl tableButtonsGenPnl;

    public CrudTableButtons(String name, Supplier<ResultSet> querySupl) {
        this.setComponentsReady();
        this.setPanelReady();
        this.tableButtonsGenPnl = new TableButtonsGenPnl(name, querySupl, this.elPanel, this.buttons);
    }

    private void setComponentsReady() {
        this.buttons = new JButton[3];
        this.insertBton = new JButton("Insertar");
        this.modifyBton = new JButton("Modificar");
        this.delBton = new JButton("Eliminar");
        this.modifyBton.setEnabled(false);
        this.delBton.setEnabled(false);
        this.buttons[0] = this.insertBton;
        this.buttons[1] = this.modifyBton;
        this.buttons[2] = this.delBton;
    }

    private void setPanelReady() {
    }

    public JButton getDelButton() {
        return this.delBton;
    }

    public JButton getInsertButton() {
        return this.insertBton;
    }

    public JButton getModifyButton() {
        return this.modifyBton;
    }

    public TableButtonsGenPnl getTableButtonsGenPnl() {
        return this.tableButtonsGenPnl;
    }
}
