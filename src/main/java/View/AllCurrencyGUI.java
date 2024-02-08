package View;

import Services.CurrencyService;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AllCurrencyGUI extends AUserInterface {

    public AllCurrencyGUI(String baseCurrency, String currency) {
        initFrame();
        createPanel(baseCurrency, currency);
    }

    protected void createPanel(String baseCurrency, String currency) {
        JLabel header = new JLabel("For One: " + baseCurrency + "\n you can BUY: ", SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(0, 1));
        headerPanel.setBackground(new Color(43, 45, 48));
        headerPanel.add(header);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 3, 10, 10)); // Dodane marginesy między ramkami
        contentPanel.setBackground(new Color(43, 45, 48));

        super.checkIfCurrencyIsCorrect(baseCurrency);

        for (Map.Entry<String, String> set : CurrencyService.getInstance().getData(baseCurrency).entrySet()) {
            JPanel currencyPanel = createCurrencyPanel(set.getKey(), set.getValue());
            contentPanel.add(currencyPanel);
        }

        JButton backButton = new JButton("BACK");
        backButton.addActionListener(e -> CurrencyService.getInstance().goBack(this));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(43, 45, 48));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);

        JPanel contentPanelContainer = new JPanel(new BorderLayout());
        contentPanelContainer.setBackground(new Color(43, 45, 48));
        contentPanelContainer.add(contentPanel, BorderLayout.CENTER);

        setContentPane(contentPanelContainer);

        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCurrencyPanel(String currency, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(60, 63, 65));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JLabel nameLabel = new JLabel(currency);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel, BorderLayout.NORTH);

        JLabel valueLabel = new JLabel("Value: " + value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(valueLabel, BorderLayout.CENTER);

        return panel;
    }
}
