package Controllers;

import Services.CurrencyService;
import View.AllCurrencyGUI;
import View.OneCurrencyGUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<String> curriencies = new ArrayList<>(CurrencyService.getInstance().getData("").keySet());;
        Collections.sort(curriencies);
        return curriencies;
    }

}
