package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionLocator {
    private static ActionListener closeAction = null;

    public ActionLocator() {
    }

    public static ActionListener getCloseAction() {
        if (closeAction == null) {
            closeAction = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int exit = JOptionPane.showConfirmDialog((Component)null, "¿Está seguro que desea salir?", "Confirmar", 0, 3);
                    if (exit == 0) {
                        System.exit(0);
                    }

                }
            };
        }

        return closeAction;
    }
}
