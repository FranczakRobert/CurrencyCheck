package View;

import Services.CurrencyService;
import Utils.ErrorHandler;

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

    protected boolean checkIfCurrencyIsCorrect(String baseCurrency) {
        if(CurrencyService.getInstance().getData(baseCurrency) == null) {
            switch (ErrorHandler.getInstance().getErrorStatus()) {
                case E_CONNECTION_LOST ->  {
                    JOptionPane.showMessageDialog(this, "CONNECTION LOST");
                    CurrencyService.getInstance().goBack(this);
                }
                case E_INVALID_DATA-> {
                    JOptionPane.showMessageDialog(this, "Invalid data");
                    CurrencyService.getInstance().goBack(this);
                }
            }
            return false;
        }
        return true;
    }
}
