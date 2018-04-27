package controller;

import view.Log;
import model.model.operations.AdminOperations;
import model.model.operations.CashierOperations;
import model.IllegalDataException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerInit {
    public ControllerInit() {
        Log log = new Log();

        log.setVisible(true);

        log.getLog().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminOperations operations = new AdminOperations();
                CashierOperations operations1 = new CashierOperations();

                if (operations.logAdmin(log.getUsernameF().getText(), log.getPasswordF().getText()) == true) {
                    ControllerAdmin controllerAdmin = new ControllerAdmin();

                } else if (operations1.logCashier(log.getUsernameF().getText(), log.getPasswordF().getText()) == true) {
                    ControllerCashier controllerCashier = new ControllerCashier();
                } else {
                    try {
                        throw new IllegalDataException("date invalide");
                    } catch (IllegalDataException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });


    }


}
