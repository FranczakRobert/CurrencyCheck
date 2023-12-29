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

        JPanel head = new JPanel();
        head.setBackground(new Color(43, 45, 48));
        head.setLayout(new GridLayout(1, 5));

        JLabel label = new JLabel("Currency: ", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        head.add(label);

        baseCurrencyTF = new JTextField(3);
        baseCurrencyTF.setText("USD");
        head.add(baseCurrencyTF);

        JLabel label2 = new JLabel("-> ", JLabel.CENTER);
        label2.setForeground(Color.WHITE);
        head.add(label2);

        currencyTF = new JTextField(3);
        currencyTF.setText("PLN");
        head.add(currencyTF);

        JButton showOne = new JButton("Check");
        head.add(showOne);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(43, 45, 48));
        bodyPanel.setLayout(new FlowLayout());

        JLabel cur = new JLabel("Currency: ", JLabel.CENTER);
        cur.setForeground(Color.WHITE);
        bodyPanel.add(cur);

        JTextField baseCurrencyBodyTF = new JTextField(3);
        baseCurrencyBodyTF.setText("USD");
        bodyPanel.add(baseCurrencyBodyTF);

        JButton showAll = new JButton("All");
        bodyPanel.add(showAll);

        showAll.addActionListener(e -> mainPanelController.showAll(this, baseCurrencyBodyTF.getText(), ""));
        showOne.addActionListener(e -> mainPanelController.showOne(this, baseCurrencyTF.getText(), currencyTF.getText()));

        contentPanel.add(head, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        setContentPane(contentPanel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



}
