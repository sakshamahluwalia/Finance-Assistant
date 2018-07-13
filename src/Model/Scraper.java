package Model;

import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;


public class Scraper {

    public String getNetWorth(Document document) {

        try {

            // this query gets user's net worth
            Element netWorth = document.getElementById("ember1806").getElementsByClass
                    ("category-balance").first();

            return netWorth.text();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public ArrayList<Transaction> getTransactions(Document document) {

        Element table = document.getElementById("ember2861");

        org.jsoup.select.Elements rows = table.select("tr");

        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Element row: rows) {

            String classname = "debit";
            double amount = 0;

            String date = row.getElementsByClass("Date").text();
            String place = row.getElementsByClass("transactions").text();


            if (!row.getElementsByClass(classname).text().toLowerCase().contains("e")) {

                amount = stringToDouble(row.getElementsByClass(classname).text());

            } else {
                classname = "credit";
                if (!row.getElementsByClass(classname).text().toLowerCase().contains("e")) {

                    amount = stringToDouble(row.getElementsByClass(classname).text());

                }
            }

            Transaction transaction = new Transaction(place, date, classname, amount);
            transactions.add(transaction);
        }
        return transactions;

    }

    public Double stringToDouble(String value) {
        value = value.replace(",", "");
        return new Double(value.substring(1, value.length()));
    }


}
