import javax.swing.*;
import java.awt.event.*;

public class ex03 extends JFrame implements ActionListener {

    JLabel lblText, lblVowel, lblConsonant, lblSpace;
    JTextField txtText;
    JButton btnCount;

    ex03() {

        setLayout(null);

        lblText = new JLabel("Enter Text:");
        lblText.setBounds(30, 30, 100, 30);
        add(lblText);

        txtText = new JTextField();
        txtText.setBounds(120, 30, 200, 30);
        add(txtText);

        btnCount = new JButton("Count");
        btnCount.setBounds(120, 80, 100, 30);
        btnCount.addActionListener(this);
        add(btnCount);

        lblVowel = new JLabel("Count of vowel is: ");
        lblVowel.setBounds(30, 140, 200, 30);
        add(lblVowel);

        lblConsonant = new JLabel("Count of consonant is: ");
        lblConsonant.setBounds(30, 180, 200, 30);
        add(lblConsonant);

        lblSpace = new JLabel("Count of space is: ");
        lblSpace.setBounds(30, 220, 200, 30);
        add(lblSpace);

        setTitle("Character Counter");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String text = txtText.getText();

        int vowel = 0;
        int consonant = 0;
        int space = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = Character.toLowerCase(text.charAt(i));

            if ("aeiou".indexOf(ch) != -1)
                vowel++;

            else if (ch == ' ')
                space++;

            else if (ch >= 'a' && ch <= 'z')
                consonant++;
        }

        lblVowel.setText("Count of vowel is: " + vowel);
        lblConsonant.setText("Count of consonant is: " + consonant);
        lblSpace.setText("Count of space is: " + space);
    }
    public static void main(String[] args) {
        new ex03();
    }
}