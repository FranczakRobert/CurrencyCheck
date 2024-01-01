package Controllers;

import Services.CurrencyService;
import View.AllCurrencyGUI;
import View.OneCurrencyGUI;

import javax.swing.*;
import java.util.ArrayList;

public class MainPanelController {
    public void showAll(JFrame gui, String baseCurrency, String currency){
        gui.dispose();
        SwingUtilities.invokeLater(() -> new AllCurrencyGUI(baseCurrency,currency));
    }
    public void showOne(JFrame gui, String baseCurrency, String currency) {
        gui.dispose();
        SwingUtilities.invokeLater(() -> new OneCurrencyGUI(baseCurrency,currency));
    }

    public ArrayList<String> fetchCurrencies() {
        return new ArrayList<>(CurrencyService.getInstance().getData("").keySet());
    }

}
