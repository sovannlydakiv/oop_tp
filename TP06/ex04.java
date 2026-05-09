import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

public class ex04 extends JFrame implements ActionListener {

    JLabel lblA, lblB, lblC, lblResult;
    JTextField txtA, txtB, txtC;
    JButton btnCalculate;

    ex04() {

        setLayout(null);

        lblA = new JLabel("Enter a:");
        lblA.setBounds(30, 30, 100, 30);
        add(lblA);

        txtA = new JTextField();
        txtA.setBounds(120, 30, 150, 30);
        add(txtA);

        lblB = new JLabel("Enter b:");
        lblB.setBounds(30, 80, 100, 30);
        add(lblB);

        txtB = new JTextField();
        txtB.setBounds(120, 80, 150, 30);
        add(txtB);

        lblC = new JLabel("Enter c:");
        lblC.setBounds(30, 130, 100, 30);
        add(lblC);

        txtC = new JTextField();
        txtC.setBounds(120, 130, 150, 30);
        add(txtC);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(120, 180, 120, 30);
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        lblResult = new JLabel("Result:");
        lblResult.setBounds(30, 240, 350, 30);
        add(lblResult);

        setTitle("Quadratic Equation");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            if (a == 0) {
                if (b == 0) {
                    lblResult.setText("Invalid equation");
                } else {
                    double r = -c / b;
                    lblResult.setText("Linear root: " + r);
                }
                return;
            }

            double d = b * b - 4 * a * c;

            if (d > 0) {

                double r1 = (-b + Math.sqrt(d)) / (2 * a);
                double r2 = (-b - Math.sqrt(d)) / (2 * a);

                lblResult.setText("Roots: " + r1 + " and " + r2);
            }

            else if (d == 0) {

                double r = -b / (2 * a);

                lblResult.setText("Root: " + r);
            }

            else {

                lblResult.setText("No real roots");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Error: Please enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new ex04();
    }
}