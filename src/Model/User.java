package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private double income;

    private double netWorth;

    private String userName;

    private String password;

    private int id;

    private double monthlyLimit;

    private int percentageToSave;

    private ArrayList<Goal> goals;

    private ArrayList<Transaction> transactions;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.id = UserManager.id;
        UserManager.id++;
        UserManager.addUsers(this);
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

    public void addTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (!this.transactions.contains(transaction)) {
                this.transactions.add(transaction);
            }
        }
    }

    public void removeTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction: transactions) {
            if (this.transactions.contains(transaction)) {
                this.transactions.remove(transaction);
            }
        }
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double balance) {
        this.netWorth = balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && ((User) obj).getId() == this.id;
    }
}
