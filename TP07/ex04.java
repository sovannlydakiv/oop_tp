import javax.swing.*;
import java.awt.*;

public class ex04 extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel container = new JPanel(cardLayout);

    public ex04() {
        setTitle("Setting");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        container.add(buildMainPanel(), "main");
        container.add(buildGeneralPanel(), "general");
        container.add(buildAboutPanel(), "about");

        add(container);
        cardLayout.show(container, "main");
        setVisible(true);
    }

    private JPanel buildMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Setting"));

        String[] items = {"1. General", "2. Wi-Fi", "3. Bluetooth", "4. Mobile Data", "5. Hotsopt", "6. Notification"};
        for (String item : items) {
            JButton btn = new JButton(item);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            if (item.equals("1. General")) {
                btn.addActionListener(e -> cardLayout.show(container, "general"));
            }
            panel.add(btn);
            panel.add(Box.createVerticalStrut(5));
        }

        JButton quit = new JButton("Quit");
        quit.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        quit.addActionListener(e -> System.exit(0));
        panel.add(quit);

        return panel;
    }

    private JPanel buildGeneralPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Setting > General"));

        String[] items = {"1. About", "2. Software update", "3. Storage"};
        for (String item : items) {
            JButton btn = new JButton(item);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            if (item.equals("1. About")) {
                btn.addActionListener(e -> cardLayout.show(container, "about"));
            }
            panel.add(btn);
            panel.add(Box.createVerticalStrut(5));
        }

        JButton back = new JButton("Back");
        back.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        back.addActionListener(e -> cardLayout.show(container, "main"));
        panel.add(back);

        return panel;
    }

    private JPanel buildAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Setting > General > About"));

        String[][] info = {{"Name", "iPhone"}, {"Model", "IXs"}, {"Version", "18.5"}};
        for (String[] row : info) {
            JPanel row1 = new JPanel(new BorderLayout());
            row1.add(new JLabel(row[0]), BorderLayout.WEST);
            row1.add(new JLabel(row[1]), BorderLayout.EAST);
            row1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            panel.add(row1);
        }

        panel.add(Box.createVerticalStrut(10));

        JButton back = new JButton("Back");
        back.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        back.addActionListener(e -> cardLayout.show(container, "general"));
        panel.add(back);

        return panel;
    }

    public static void main(String[] args) {
        new ex04();
    }
}