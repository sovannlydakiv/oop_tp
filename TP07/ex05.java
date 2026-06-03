import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ex05 extends JFrame {

    private DefaultTableModel model;
    private JTextField tfFirstName, tfLastName, tfAge, tfMajor;

    public ex05() {
        setTitle("Student Management");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("First name");
        model.addColumn("Last name");
        model.addColumn("Age");
        model.addColumn("Major");

        model.addRow(new Object[]{"Sovannlyda", "Kiv", "20", "SE"});
        model.addRow(new Object[]{"Inthera", "Chiv", "19", "Comp Sci"});

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new FlowLayout());
        tfFirstName = new JTextField(8);
        tfLastName = new JTextField(8);
        tfAge = new JTextField(4);
        tfMajor = new JTextField(8);

        inputPanel.add(new JLabel("First name"));
        inputPanel.add(tfFirstName);
        inputPanel.add(new JLabel("Last name"));
        inputPanel.add(tfLastName);
        inputPanel.add(new JLabel("Age"));
        inputPanel.add(tfAge);
        inputPanel.add(new JLabel("Major"));
        inputPanel.add(tfMajor);

        JButton addBtn = new JButton("Add new");
        addBtn.addActionListener(e -> {
            String fn = tfFirstName.getText().trim();
            String ln = tfLastName.getText().trim();
            String age = tfAge.getText().trim();
            String major = tfMajor.getText().trim();
            if (!fn.isEmpty() && !ln.isEmpty() && !age.isEmpty() && !major.isEmpty()) {
                model.addRow(new Object[]{fn, ln, age, major});
                tfFirstName.setText("");
                tfLastName.setText("");
                tfAge.setText("");
                tfMajor.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            }
        });
        inputPanel.add(addBtn);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Student Management"));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ex05();
    }
}