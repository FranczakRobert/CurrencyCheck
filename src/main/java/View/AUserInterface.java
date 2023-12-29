package View;

import Services.CurrencyService;

import javax.swing.*;
import java.awt.*;

public abstract class AUserInterface extends JFrame {
    private final static int WIDTH = 400;
    private final static int HEIGH = 400;

    protected void initFrame() {
        setSize(WIDTH, HEIGH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(4, 1));
    }

    protected abstract void createPanel(String baseCurrency, String currency);

    protected void checkIfCurrencyIsCorrect(String baseCurrency, String currency) {
        if(CurrencyService.getInstance().getData(baseCurrency,currency) == null) {
            JOptionPane.showMessageDialog(this, "BAD FORMAT");
            CurrencyService.getInstance().goBack(this);
        }
    }
}
