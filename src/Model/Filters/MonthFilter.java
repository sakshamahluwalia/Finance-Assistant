package Model.Filters;

import Model.Transaction;
import java.util.ArrayList;

public class MonthFilter extends Filter {

    private String month;

    @Override
    public ArrayList<Transaction> afterFilter(ArrayList<Transaction> transactions) {

        ArrayList<Transaction> afterFilterTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getDate().toLowerCase().trim().contains(month.toLowerCase())) {
                afterFilterTransactions.add(transaction);
            }
        }
        return afterFilterTransactions;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
