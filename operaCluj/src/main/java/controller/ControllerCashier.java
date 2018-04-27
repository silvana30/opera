package controller;

import view.CashierView;
import model.model.operations.CashierOperations;
import model.model.exporter.Exporter;
import model.model.exporter.FactoryExp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.*;

public class ControllerCashier {
    public ControllerCashier() {
        CashierView cashierView = new CashierView();
        cashierView.setVisible(true);
        cashierView.getBtnSale().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashierOperations cashierOperations = new CashierOperations();
                try {
                    cashierOperations.addTickets(parseInt(cashierView.getTextFieldIDshow().getText()), parseInt(cashierView.getTextFieldNr().getText()), parseInt(cashierView.getTextFieldRow().getText()));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                cashierView.setTicketTable();
            }
        });
        cashierView.getBtnExport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FactoryExp factoryExp = new FactoryExp();
                Exporter exporter = factoryExp.getExporter(cashierView.getComboBox().getSelectedItem().toString());
                exporter.exportTicket(Integer.parseInt(cashierView.getTextFieldIDshow().getText()));
            }
        });

    }
}
