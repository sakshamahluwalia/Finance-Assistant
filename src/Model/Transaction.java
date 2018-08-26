package Model;

import java.io.Serializable;

public class Transaction implements Serializable {

    private String place;

    private double amount;

    private String month;

    private String date;

    private String type;

    private String category;

    public Transaction(String place, String month, String date, String type, double amount) {
        this.place = place;
        this.month = month;
        this.amount = amount;
        this.date = date;
        this.type = type;
        analysePlaceForCategory();
    }

    private void analysePlaceForCategory() {
        if (place.toLowerCase().contains("withdrawal")) {
            this.category = "fun";
        } else if (place.toLowerCase().contains("presto") || place.toLowerCase().contains("ttc")) {
            this.category = "travel";
        } else {
            this.category = "miscellaneous";
        }
    }

    public String getPlace() {
        return place;
    }

    public double getAmount() {
        return amount;
    }

    public String getAmountString() {
        return Double.toString(amount);
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
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

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Transaction && ((Transaction) obj).getPlace().equalsIgnoreCase(this.place)
                && ((Transaction) obj).getAmount() == this.amount;
    }
}
