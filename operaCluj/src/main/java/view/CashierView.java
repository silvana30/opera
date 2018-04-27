package view;

import model.Show;
import model.model.operations.ShowOP;
import model.Ticket;
import model.model.operations.TicketOP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.util.List;


public class CashierView extends JFrame {
    private JButton btnExport;
    private JComboBox comboBox;
    private JScrollPane scrollPaneTicket;
    private JScrollPane scrollPaneShow;
    private JButton btnSale;
    private JPanel contentPane;
    private JTable tableShow;
    private JTable tableTicket;
    private JTextField textFieldIDshow;
    private JTextField textFieldNr;
    private JTextField textFieldRow;
    private DefaultTableModel tableModel, tableModel1;


    String colums1[] = {"ID", "Date", "Distribution", "Genre", "No of tickets", "Title"};
    String colums2[] = {"ID", "Number", "Row", "Show"};

    public CashierView() {
        setTitle("Cashier operations");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 800, 746);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        scrollPaneShow = new JScrollPane();
        scrollPaneShow.setBounds(12, 12, 400, 300);
        tableShow = new JTable();
        scrollPaneShow.setViewportView(tableShow);

        tableModel = new DefaultTableModel(new Object[][]{}, colums1);
        tableShow.addPropertyChangeListener(e -> showPropertyChange(e));
        contentPane.add(scrollPaneShow);


        scrollPaneTicket = new JScrollPane();
        scrollPaneTicket.setBounds(30, 400, 400, 200);
        tableTicket = new JTable();
        scrollPaneTicket.setViewportView(tableTicket);

        tableModel1 = new DefaultTableModel(new Object[][]{}, colums2);
        tableShow.addPropertyChangeListener(e -> ticketPropertyChange(e));
        contentPane.add(scrollPaneTicket);


        JLabel lblShowId = new JLabel("Show ID");
        lblShowId.setBounds(448, 41, 83, 16);
        contentPane.add(lblShowId);

        JLabel lblNumberTicket = new JLabel("Number ticket");
        lblNumberTicket.setBounds(448, 108, 94, 16);
        contentPane.add(lblNumberTicket);

        JLabel lblRowTicket = new JLabel("Row ticket");
        lblRowTicket.setBounds(448, 187, 83, 16);
        contentPane.add(lblRowTicket);

        textFieldIDshow = new JTextField();
        textFieldIDshow.setBounds(558, 38, 116, 22);
        contentPane.add(textFieldIDshow);
        textFieldIDshow.setColumns(10);

        textFieldNr = new JTextField();
        textFieldNr.setBounds(554, 105, 116, 22);
        contentPane.add(textFieldNr);
        textFieldNr.setColumns(10);

        textFieldRow = new JTextField();
        textFieldRow.setBounds(558, 184, 116, 22);
        contentPane.add(textFieldRow);
        textFieldRow.setColumns(10);

        btnSale = new JButton("Sale");
        btnSale.setBounds(509, 254, 97, 25);
        contentPane.add(btnSale);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"JSON", "CSV"}));
        comboBox.setBounds(511, 322, 60, 22);
        contentPane.add(comboBox);

        btnExport = new JButton("EXPORT");
        btnExport.setBounds(509, 386, 97, 25);
        contentPane.add(btnExport);
    }

    private void ticketPropertyChange(PropertyChangeEvent e) {
        setTicketTable();
    }

    private void showPropertyChange(PropertyChangeEvent e) {
        setShowTable();
    }

    public void setShowTable() {
        ShowOP showOP = new ShowOP();


        tableShow.setModel(tableModel);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        List<Show> lista = showOP.readShow();
        for (Show s : lista) {
            Object[] objects = {s.getId(), s.getDate(), s.getDistribution(), s.getGenre(), s.getNrTickets(), s.getTitle()};
            tableModel.addRow(objects);
        }


    }

    public void setTicketTable() {
        TicketOP ticketOP = new TicketOP();

        tableTicket.setModel(tableModel1);
        for (int i = tableModel1.getRowCount() - 1; i >= 0; i--) {
            tableModel1.removeRow(i);
        }
        List<Ticket> lista = ticketOP.readTickets();
        for (Ticket t : lista) {
            Object[] objects = {t.getId(), t.getNumber(), t.getRow(), t.getShow().getTitle()};
            tableModel1.addRow(objects);
        }
    }

    public JButton getBtnExport() {
        return btnExport;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JButton getBtnSale() {
        return btnSale;
    }

    public JTextField getTextFieldIDshow() {
        return textFieldIDshow;
    }

    public JTextField getTextFieldNr() {
        return textFieldNr;
    }

    public JTextField getTextFieldRow() {
        return textFieldRow;
    }
}
