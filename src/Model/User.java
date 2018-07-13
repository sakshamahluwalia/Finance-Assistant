package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private double income;

    private double netWorth;

    private double monthlyLimit;

    private int percentageToSave;

    private ArrayList<Goal> goals;

    private ArrayList<Transaction> transactions;

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void addTransactions(ArrayList<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double balance) {
        this.netWorth = balance;
    }

    public int getPercentageToSave() {
        return percentageToSave;
    }

    public void setPercentageToSave(int percentageToSave) {
        this.percentageToSave = percentageToSave;
    }
}
