package Model.Filters;

import Model.Transaction;

import java.util.ArrayList;

public class DebitFilter extends Filter {

    @Override
    public ArrayList<Transaction> afterFilter(ArrayList<Transaction> transactions) {

        ArrayList<Transaction> afterFilterTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("debit")) {
                afterFilterTransactions.add(transaction);
            }
        }
        return afterFilterTransactions;
    }

}
