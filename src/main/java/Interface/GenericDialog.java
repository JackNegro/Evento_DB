package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenericDialog {
    private JDialog elDialog;
    private JPanel buttonPnl;
    private JButton genBton;
    private JButton cancelBton;

    public GenericDialog(JFrame parentFrame, JPanel dataPnl, String dialogTitle, String buttonText) {
        this.setComponentsReady(buttonText);
        this.setDialogReady(parentFrame, dataPnl, dialogTitle);
    }

    private void setComponentsReady(String buttonText) {
        this.buttonPnl = new JPanel(new FlowLayout(2));
        this.genBton = new JButton(buttonText);
        this.cancelBton = new JButton("Cancelar");
        this.cancelBton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                GenericDialog.this.elDialog.dispose();
            }
        });
        this.buttonPnl.add(this.genBton);
        this.buttonPnl.add(this.cancelBton);
    }

    private void setDialogReady(JFrame parentFrame, JPanel dataPnl, String name) {
        this.elDialog = new JDialog(parentFrame, name, true);
        this.elDialog.getContentPane().add(this.buttonPnl, "South");
        this.elDialog.getContentPane().add(dataPnl, "Center");
        this.elDialog.pack();
        this.elDialog.setMinimumSize(this.elDialog.getSize());
        this.elDialog.setLocationRelativeTo(parentFrame);
    }

    public JDialog getDialog() {
        return this.elDialog;
    }

    public JButton getGenBton() {
        return this.genBton;
    }

    public void setResizable(boolean resizable) {
        this.elDialog.setResizable(resizable);
    }

    public void setVisible(boolean visible) {
        this.elDialog.setVisible(visible);
    }

}
