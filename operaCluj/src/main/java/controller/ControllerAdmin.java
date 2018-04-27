package controller;

import view.AdminView;
import model.model.operations.AdminOperations;
import model.Encryption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControllerAdmin {
    public ControllerAdmin() {
        AdminView adminView = new AdminView();
        adminView.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //adminW.model1Update();

                adminView.setShowTable();

            }
        });
        adminView.setVisible(true);
        adminView.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOperations operations = new AdminOperations();

                operations.createShow(adminView.getTextFieldDATE().getText(), adminView.getTextFieldDISTRIBUTION().getText(), adminView.getComboBox().getSelectedItem().toString(), Integer.parseInt(adminView.getTextFieldNRT().getText()), adminView.getTextFieldTITLE().getText());
                adminView.setShowTable();
            }
        });
        adminView.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOperations operations = new AdminOperations();
                operations.updateShow(Integer.parseInt(adminView.getTextFieldID().getText()), adminView.getTextFieldDATE().getText(), adminView.getTextFieldDISTRIBUTION().getText(), adminView.getComboBox().getSelectedItem().toString(), Integer.parseInt(adminView.getTextFieldNRT().getText()), adminView.getTextFieldTITLE().getText());

                adminView.setShowTable();
            }
        });

        adminView.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOperations operations = new AdminOperations();
                operations.deleteShow(Integer.parseInt(adminView.getTextFieldID().getText()));
                adminView.setShowTable();
            }
        });

        adminView.getBtnCreateAcc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOperations operations = new AdminOperations();
                operations.createCashier(adminView.getTextFieldNAME().getText(), adminView.getTextFieldUSER().getText(), Encryption.encrypt(adminView.getTextFieldPASSWORD().getText()));
                adminView.setTableCashier();
            }
        });
    }


}
