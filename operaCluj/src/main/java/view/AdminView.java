package view;

import model.model.operations.AdminOperations;
import model.Cashier;
import model.Show;
import model.model.operations.ShowOP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class AdminView extends JFrame {
    private JComboBox comboBox;
    private JButton btnCreateAcc;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnAdd;
    private JScrollPane scrollPaneCASIERI;
    private DefaultTableModel tableModel, tableModel1;
    private JPanel contentPane;
    private JTable table;
    private JTable tableCashier;
    private JTextField textFieldID;
    private JTextField textFieldTITLE;
    private JTextField textFieldDISTRIBUTION;
    private JTextField textFieldDATE;
    private JTextField textFieldNRT;
    private JTextField textFieldNAME;
    private JTextField textFieldUSER;
    private JTextField textFieldPASSWORD;
    private JScrollPane scrollPane;

    String colums1[] = {"ID", "Date", "Distribution", "Genre", "No of tickets", "Title"};
    String colums2[] = {"ID", "Name", "Username", "Password"};

    public AdminView() {

        setTitle("Admin operations");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 872, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);


        scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 15, 500, 375);
        table = new JTable();
        scrollPane.setViewportView(table);

        tableModel = new DefaultTableModel(new Object[][]{}, colums1);
        table.addPropertyChangeListener(e -> showPropertyChange(e));

        contentPane.add(scrollPane);

        scrollPaneCASIERI = new JScrollPane();
        scrollPaneCASIERI.setBounds(15, 450, 500, 200);
        tableCashier = new JTable();
        scrollPaneCASIERI.setViewportView(tableCashier);

        tableModel1 = new DefaultTableModel(new Object[][]{}, colums2);
        tableCashier.addPropertyChangeListener(e -> cashierPropertyChange(e));
        contentPane.add(scrollPaneCASIERI);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(545, 13, 108, 23);
        contentPane.add(lblNewLabel);


        textFieldID = new JTextField();
        textFieldID.setBounds(665, 13, 116, 22);
        contentPane.add(textFieldID);
        textFieldID.setColumns(10);

        JLabel lblGender = new JLabel("Genre");
        lblGender.setBounds(545, 55, 109, 23);
        contentPane.add(lblGender);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(545, 108, 109, 23);
        contentPane.add(lblTitle);

        JLabel lblDistribution = new JLabel("Distribution");
        lblDistribution.setBounds(545, 154, 109, 23);
        contentPane.add(lblDistribution);

        JLabel lblDistributionDate = new JLabel("Distribution date");
        lblDistributionDate.setBounds(545, 209, 109, 23);
        contentPane.add(lblDistributionDate);

        JLabel lblNoOfTickets = new JLabel("No of tickets");
        lblNoOfTickets.setBounds(545, 261, 108, 23);
        contentPane.add(lblNoOfTickets);

        textFieldTITLE = new JTextField();
        textFieldTITLE.setBounds(665, 108, 116, 22);
        contentPane.add(textFieldTITLE);
        textFieldTITLE.setColumns(10);

        textFieldDISTRIBUTION = new JTextField();
        textFieldDISTRIBUTION.setBounds(665, 154, 116, 22);
        contentPane.add(textFieldDISTRIBUTION);
        textFieldDISTRIBUTION.setColumns(10);

        textFieldDATE = new JTextField();
        textFieldDATE.setBounds(665, 209, 116, 22);
        contentPane.add(textFieldDATE);
        textFieldDATE.setColumns(10);

        textFieldNRT = new JTextField();
        textFieldNRT.setText("");
        textFieldNRT.setBounds(665, 261, 116, 22);
        contentPane.add(textFieldNRT);
        textFieldNRT.setColumns(10);

        scrollPaneCASIERI = new JScrollPane();
        scrollPaneCASIERI.setBounds(446, 410, -440, 250);
        contentPane.add(scrollPaneCASIERI);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(505, 318, 97, 25);
        contentPane.add(btnAdd);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(623, 318, 97, 25);
        contentPane.add(btnUpdate);

        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(740, 318, 97, 25);
        contentPane.add(btnDelete);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(545, 398, 83, 23);
        contentPane.add(lblName);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(545, 459, 83, 23);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(545, 519, 83, 23);
        contentPane.add(lblPassword);

        textFieldNAME = new JTextField();
        textFieldNAME.setBounds(665, 398, 116, 22);
        contentPane.add(textFieldNAME);
        textFieldNAME.setColumns(10);

        textFieldUSER = new JTextField();
        textFieldUSER.setBounds(665, 459, 116, 22);
        contentPane.add(textFieldUSER);
        textFieldUSER.setColumns(10);

        textFieldPASSWORD = new JTextField();
        textFieldPASSWORD.setBounds(665, 519, 116, 22);
        contentPane.add(textFieldPASSWORD);
        textFieldPASSWORD.setColumns(10);

        btnCreateAcc = new JButton("CREATE ACC");
        btnCreateAcc.setBounds(574, 583, 146, 25);
        contentPane.add(btnCreateAcc);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Opera", "Opereta", "Balet"}));
        comboBox.setBounds(665, 55, 116, 22);
        contentPane.add(comboBox);
    }

    private void cashierPropertyChange(PropertyChangeEvent e) {
        setTableCashier();
    }


    private void showPropertyChange(PropertyChangeEvent e) {
        setShowTable();

    }

    public void setShowTable() {
        ShowOP showOP = new ShowOP();


        table.setModel(tableModel);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        List<Show> lista = showOP.readShow();
        for (Show s : lista) {
            Object[] objects = {s.getId(), s.getDate(), s.getDistribution(), s.getGenre(), s.getNrTickets(), s.getTitle()};
            tableModel.addRow(objects);
        }


    }

    public void setTableCashier() {
        AdminOperations operations = new AdminOperations();
        tableCashier.setModel(tableModel1);
        for (int i = tableModel1.getRowCount() - 1; i >= 0; i--) {
            tableModel1.removeRow(i);
        }
        List<Cashier> lista = operations.readCashier();
        for (Cashier s : lista) {
            Object[] objects = {s.getId(), s.getName(), s.getUsername(), s.getPassword()};
            tableModel1.addRow(objects);
        }

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JTextField getTextFieldID() {
        return textFieldID;
    }

    public JTextField getTextFieldTITLE() {
        return textFieldTITLE;
    }

    public JTextField getTextFieldDISTRIBUTION() {
        return textFieldDISTRIBUTION;
    }

    public JTextField getTextFieldDATE() {
        return textFieldDATE;
    }

    public JTextField getTextFieldNRT() {
        return textFieldNRT;
    }

    public JTextField getTextFieldNAME() {
        return textFieldNAME;
    }

    public JTextField getTextFieldUSER() {
        return textFieldUSER;
    }

    public JTextField getTextFieldPASSWORD() {
        return textFieldPASSWORD;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JButton getBtnCreateAcc() {
        return btnCreateAcc;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
}
