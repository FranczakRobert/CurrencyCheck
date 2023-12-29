package Model;

import Controllers.CurrencyController;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CurrencyData {
    public Map<String, String> getData(String baseCurrency, String currentCurrency) {
        Map<String, String > mapData = new HashMap<>();
        JSONObject data;
        try {
            CurrencyController currencyController = new CurrencyController();
            currencyController.setCurrency(currentCurrency);
            currencyController.setCurrency("");

            if(!baseCurrency.isEmpty())
                currencyController.setBase(baseCurrency);
            else
                currencyController.setBase("");
            currencyController.startURL();

            data = currencyController.readFromURL();
        } catch (Exception e) {
            mapData = null;
            return mapData;
        }
        JSONObject objects = data.getJSONObject("data");

        for (Object element : objects.names()) {
            String current = String.format("%s",objects.get(String.valueOf(element.toString())));
            int dotIndex = current.indexOf('.');
            int end = current.length();
            if(dotIndex + 3 <= end) {
                mapData.put(element.toString(),current.substring(0,dotIndex+3));
            }
            else  {
                mapData.put(element.toString(),current);
            }
        }

        return mapData;
    }





}
