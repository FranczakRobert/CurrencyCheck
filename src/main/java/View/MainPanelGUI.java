package View;

import Controllers.MainPanelController;

import javax.swing.*;
import java.awt.*;

public class MainPanelGUI extends AUserInterface {

    private JTextField baseCurrencyTF;
    private JTextField currencyTF;
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
// HEAD PANEL



        JPanel head = new JPanel();
        head.setBackground(new Color(43, 45, 48));
        head.setLayout(new GridLayout(1, 5));

        JLabel label = new JLabel("Currency: ", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        head.add(label);

        JComboBox<String> boxONE = new JComboBox<>();
        SwingUtilities.invokeLater(() -> {
            for (String s : mainPanelController.fetchCurrencies())
                boxONE.addItem(s);
        });
        head.add(boxONE);

        JLabel label2 = new JLabel("-> ", JLabel.CENTER);
        label2.setForeground(Color.WHITE);
        head.add(label2);

        JComboBox<String> boxTWO = new JComboBox<>();
        SwingUtilities.invokeLater(() -> {
            for (String s : mainPanelController.fetchCurrencies())
                boxTWO.addItem(s);
        });
        head.add(boxTWO);

        JButton showOne = new JButton("Check");
        head.add(showOne);
// BODY PANEL
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(43, 45, 48));
        bodyPanel.setLayout(new FlowLayout());

        JLabel cur = new JLabel("Currency: ", JLabel.CENTER);
        cur.setForeground(Color.WHITE);
        bodyPanel.add(cur);

        JComboBox<String> boxForAll = new JComboBox<>();
        SwingUtilities.invokeLater(() -> {
            for (String s : mainPanelController.fetchCurrencies())
                boxForAll.addItem(s);
        });
        bodyPanel.add(boxForAll);

        JButton showAll = new JButton("All");
        bodyPanel.add(showAll);

        showAll.addActionListener(e -> mainPanelController.showAll(this, (String) boxForAll.getSelectedItem(), ""));
        showOne.addActionListener(e -> mainPanelController.showOne(this, (String) boxONE.getSelectedItem(), (String) boxTWO.getSelectedItem()));

        contentPanel.add(head, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
//        contentPanel.add(new Label("  Available currencies:",Label.CENTER), BorderLayout.BEFORE_LINE_BEGINS);
//        contentPanel.add(box,BorderLayout.AFTER_LAST_LINE);
        setContentPane(contentPanel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



}
