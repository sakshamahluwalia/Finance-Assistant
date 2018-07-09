package Model;

import java.util.ArrayList;

public class Calculator {

    double creditLeft(double credit, double expense) {
        return credit - expense;
    }

    public double creditSpent(ArrayList<Transaction> transactions) {

        double creditSpent = 0;
        for (Transaction transaction: transactions) {
            creditSpent += transaction.getAmount();
        }
        return creditSpent;
    }

    int numberOfTransactions(ArrayList<Transaction> transactions) {
        return transactions.size();
    }


}
