package Controllers;

import View.AllCurrencyGUI;
import View.OneCurrencyGUI;

import javax.swing.*;

public class MainPanelController {
    public void showAll(JFrame gui, String baseCurrency, String currency){
        gui.dispose();
        SwingUtilities.invokeLater(() -> new AllCurrencyGUI(baseCurrency,currency));
    }
    public void showOne(JFrame gui, String baseCurrency, String currency) {
        gui.dispose();
        SwingUtilities.invokeLater(() -> new OneCurrencyGUI(baseCurrency,currency));
    }
}
