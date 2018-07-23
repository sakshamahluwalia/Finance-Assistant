package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private double netWorth;

    private double monthlyLimit;

    private int percentageToSave;

    private ArrayList<Transaction> transactions;

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (!this.transactions.contains(transaction)) {
                this.transactions.add(transaction);
            }
        }
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double balance) {
        this.netWorth = balance;
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public int getPercentageToSave() {
        return percentageToSave;
    }

    public void setPercentageToSave(int percentageToSave) {
        this.percentageToSave = percentageToSave;
    }
}
