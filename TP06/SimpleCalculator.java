import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleCalculator extends JFrame {

    private JTextField input1 = new JTextField(10);
    private JTextField input2 = new JTextField(10);

    private JLabel resultAdd = new JLabel("= ");
    private JLabel resultSub = new JLabel("= ");
    private JLabel resultMul = new JLabel("= ");
    private JLabel resultDiv = new JLabel("= ");

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel title = new JLabel("Calculator");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(10));

        JLabel labelA = new JLabel("A=");
        labelA.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(labelA);

        input1.setAlignmentX(Component.LEFT_ALIGNMENT);
        input1.setMaximumSize(new Dimension(300, 30));
        mainPanel.add(input1);
        mainPanel.add(Box.createVerticalStrut(10));

        JLabel labelB = new JLabel("B=");
        labelB.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(labelB);

        input2.setAlignmentX(Component.LEFT_ALIGNMENT);
        input2.setMaximumSize(new Dimension(300, 30));
        mainPanel.add(input2);
        mainPanel.add(Box.createVerticalStrut(10));

        JButton btnAdd = new JButton("A + B");
        JButton btnSub = new JButton("A - B");
        JButton btnMul = new JButton("A * B");
        JButton btnDiv = new JButton("A / B");

        addButtonWithResult(mainPanel, btnAdd, resultAdd);
        addButtonWithResult(mainPanel, btnSub, resultSub);
        addButtonWithResult(mainPanel, btnMul, resultMul);
        addButtonWithResult(mainPanel, btnDiv, resultDiv);

        ActionListener calcAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(input1.getText());
                    double b = Double.parseDouble(input2.getText());
                    String command = e.getActionCommand();

                    if (command.equals("A + B")) {
                        resultAdd.setText("= " + (a + b));
                    } 
                    else if (command.equals("A - B")) {
                        resultSub.setText("= " + (a - b));
                    } 
                    else if (command.equals("A * B")) {
                        resultMul.setText("= " + (a * b));
                    } 
                    else if (command.equals("A / B")) {
                        if (b != 0) {
                            resultDiv.setText("= " + (a / b));
                        } else {
                            resultDiv.setText("= Error");
                        }
                    }
                } catch (NumberFormatException ex) {
                    for (JLabel lbl : new JLabel[]{resultAdd, resultSub, resultMul, resultDiv}) {
                        lbl.setText("= Invalid Input");
                    }
                }
            }
        };

        btnAdd.addActionListener(calcAction);
        btnSub.addActionListener(calcAction);
        btnMul.addActionListener(calcAction);
        btnDiv.addActionListener(calcAction);

        add(mainPanel);
        setVisible(true);
    }

    private void addButtonWithResult(JPanel panel, JButton btn, JLabel result) {
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(btn);
        result.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(result);
        panel.add(Box.createVerticalStrut(10));
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}