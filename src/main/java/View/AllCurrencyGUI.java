package View;

import Services.CurrencyService;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AllCurrencyGUI extends AUserInterface {

    public AllCurrencyGUI(String baseCurrency, String currency) {
        initFrame();
        createPanel(baseCurrency,currency);
    }

    protected void createPanel(String baseCurrency, String currency) {
        if (currency.isEmpty())
            currency = "USD";

        JLabel header = new JLabel("For One: " + currency + "\n you can BUY: ", SwingConstants.CENTER);
        header.setForeground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(0, 1));
        headerPanel.setBackground(new Color(43, 45, 48));
        headerPanel.add(header);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 3));
        contentPanel.setBackground(new Color(43, 45, 48));

        super.checkIfCurrencyIsCorrect(baseCurrency, currency);

        for (Map.Entry<String, String> set : CurrencyService.getInstance().getData(baseCurrency, currency).entrySet()) {
            JLabel label = new JLabel(set.getKey() + " : " + set.getValue());
            label.setForeground(Color.WHITE);
            label.setHorizontalAlignment(SwingConstants.LEFT);
            contentPanel.add(label);
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

}
