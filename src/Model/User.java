package Model;

import java.util.ArrayList;

public class User {

    private double income;

    private double netWorth;

    private double monthlyLimit;

    private int percentageToSave;

    private ArrayList<Goal> goals;

    private ArrayList<Transaction> transactions;

    private Calculator calculator = new Calculator();


    public double getExpenseReport() {
        return calculator.creditSpent(transactions);
    }



    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
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
