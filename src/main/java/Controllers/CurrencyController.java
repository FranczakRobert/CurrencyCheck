package Controllers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyController {
    private String currency = ""; //"&currencies=PLN";
    private String base = "";     //&base_currency=
    private URL url = null;
    private HttpURLConnection connection = null;

    public CurrencyController()  {

    }

    public void setCurrency(String currency) {
        this.currency = "&currencies=" + currency;
    }

    public void setBase(String baseCurrency) {
        if(!baseCurrency.isEmpty())
            this.base = "&base_currency=" + baseCurrency;
        else
            this.base = "";
    }

    public void startURL() {
        initUrl();
        connect();
    }

    private void connect () {
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

        } catch (IOException e) {
            System.out.println("Connection Error : " + e.getMessage());
        }

    }
    public JSONObject readFromURL() {
        StringBuilder stringBuilder = null;
        try {
            stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Read from URL error : " + e.getMessage());
        } finally {
            connection.disconnect();
        }

        return new JSONObject(stringBuilder.toString());

    }
    private void initUrl() {
        try {
            String APIKey = readAPIKey();
            String request = "https://api.freecurrencyapi.com/v1/latest?apikey=" + APIKey + currency + base;
            url = new URL(request);

        } catch (IOException e) {
            System.out.println("URL error : " + e.getMessage());
        }
        base = "";
        currency = "";
    }
    private String readAPIKey() {
        StringBuilder key = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader("key.txt"))) {
            while (reader.ready()) {
                key.append(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return key.toString();
    }
}
