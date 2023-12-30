package Services;

import Model.CurrencyData;
import View.MainPanelGUI;

import javax.swing.*;
import java.util.Map;

public class CurrencyService {
    private static CurrencyService instance = null;
    private CurrencyService() {}

    public static CurrencyService getInstance() {
        if(instance == null)
            instance = new CurrencyService();
        return instance;
    }

    public void goBack(JFrame gui) {
        gui.dispose();
        SwingUtilities.invokeLater(() -> new MainPanelGUI());
    }
    public Map<String, String> getData(String baseCurrency) {
        return new CurrencyData().getData(baseCurrency);
    }
}
