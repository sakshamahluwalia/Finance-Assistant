package Model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;


public class Scraper {

    public String getNetWorth(Document document) {

        try {

            // this query gets user's net worth
            Element netWorth = document.getElementsByClass("category-balance").first();

            return netWorth.text();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public ArrayList<Transaction> getTransactions(Document document) {

        org.jsoup.select.Elements table = document.getElementsByTag("tbody");

        org.jsoup.select.Elements rows = table.select("tr");
        rows.remove(0);

        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Element row : rows) {

            String classname = "debit";
            double amount = 0;
            String date = row.getElementsByClass("Date").text().substring(0, 6).replace(",", "");
            String month = date.substring(0, 3);
            String place = row.getElementsByClass("transactions").text();


            if (!row.getElementsByClass(classname).text().toLowerCase().contains("e")) {

                amount = stringToDouble(row.getElementsByClass(classname).text());

            } else {
                classname = "credit";
                if (!row.getElementsByClass(classname).text().toLowerCase().contains("e")) {

                    amount = stringToDouble(row.getElementsByClass(classname).text());

                }
            }

            Transaction transaction = new Transaction(place, month, date, classname, amount);
            transactions.add(transaction);
        }
        return transactions;

    }

    public Double stringToDouble(String value) {
        value = value.replace(",", "");
        return new Double(value.substring(1, value.length()));
    }


}
