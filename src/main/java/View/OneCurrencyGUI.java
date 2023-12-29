package View;

import Services.CurrencyService;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class OneCurrencyGUI extends AUserInterface{
    public OneCurrencyGUI(String baseCurrency, String currency) {
        initFrame();
        createPanel(baseCurrency,currency);
    }

    @Override
    protected void createPanel(String baseCurrency, String currency) {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(43, 45, 48));
        contentPanel.setLayout(new FlowLayout());

        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new FlowLayout());
        feedbackPanel.setBackground(new Color(43, 45, 48));

        Map<String, String> currencyData = CurrencyService.getInstance().getData(baseCurrency, currency);

        super.checkIfCurrencyIsCorrect(baseCurrency, currency);

        JLabel label = new JLabel("1 " + baseCurrency + " = " + currencyData.get(currency) + " " + currency);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.LEFT);

        contentPanel.add(label);

        JButton goBack = new JButton("Back");
        goBack.addActionListener(e -> CurrencyService.getInstance().goBack(this));
        feedbackPanel.add(goBack);

        JPanel contentPanelContainer = new JPanel(new BorderLayout());
        contentPanelContainer.setBackground(new Color(43, 45, 48));
        contentPanelContainer.add(contentPanel, BorderLayout.CENTER);

        setContentPane(contentPanelContainer);

        add(feedbackPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
