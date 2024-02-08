package View;

import Controllers.MainPanelController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanelGUI extends AUserInterface {
    private MainPanelController mainPanelController;

    public MainPanelGUI() {
        mainPanelController = new MainPanelController();
        initFrame();
        createPanel("","");
    }
    @Override
    protected void createPanel(String baseCurrency, String currency) {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(43, 45, 48));
        contentPanel.setLayout(new BorderLayout());
        ArrayList<String> avaliableCurriencies = mainPanelController.fetchCurrencies();

// HEAD PANEL
        JComboBox<String> boxONE = new JComboBox<>();
        JComboBox<String> boxTWO = new JComboBox<>();

        fillOutBox(boxONE,avaliableCurriencies);
        fillOutBox(boxTWO,avaliableCurriencies);

        JPanel head = createHeadPanel(boxONE, boxTWO);

        JButton showOne = new JButton("Check");
        head.add(showOne);


// BODY PANEL
        JPanel bodyPanel = createBodyPanel();

        JComboBox<String> boxForAll = new JComboBox<>();
        fillOutBox(boxForAll,avaliableCurriencies);

        bodyPanel.add(boxForAll);

        JButton showAll = new JButton("All");
        bodyPanel.add(showAll);

        showAll.addActionListener(e -> mainPanelController.showAll(this, (String) boxForAll.getSelectedItem(), ""));
        showOne.addActionListener(e -> mainPanelController.showOne(this, (String) boxONE.getSelectedItem(), (String) boxTWO.getSelectedItem()));

        contentPanel.add(head, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        setContentPane(contentPanel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createHeadPanel(JComboBox<String> box1, JComboBox<String> box2) {
        JPanel head = new JPanel();
        head.setBackground(new Color(43, 45, 48));
        head.setLayout(new GridLayout(1, 5));

        JLabel label = new JLabel("Currency: ", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        head.add(label);

        head.add(box1);

        JLabel label2 = new JLabel("-> ", JLabel.CENTER);
        label2.setForeground(Color.WHITE);
        head.add(label2);
        head.add(box2);
        return head;
    }

    private JPanel createBodyPanel() {
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(43, 45, 48));
        bodyPanel.setLayout(new FlowLayout());

        JLabel cur = new JLabel("Currency: ", JLabel.CENTER);
        cur.setForeground(Color.WHITE);
        bodyPanel.add(cur);

        return bodyPanel;
    }

    private void fillOutBox(JComboBox<String> box, ArrayList<String> avaliableCurriencies) {
        SwingUtilities.invokeLater(() -> {
            for (String s : avaliableCurriencies)
                box.addItem(s);
        });
    }
}
