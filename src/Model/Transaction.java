package Model;

public class Transaction {

    private String place;

    private double amount;

    private String date;

    public Transaction(String place, String date, double amount) {
        this.place = place;
        this.amount = amount;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }


    public void setPlace(String place) {
        this.place = place;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
