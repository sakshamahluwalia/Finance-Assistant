package Controller;

import Model.Transaction;
import Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

// find a way to close the popup when ok is pressed.
public class addTransactionController {

    private User user;

    @FXML
    private TextField place;

    @FXML
    private TextField amount;

    @FXML
    private TextField type;

    @FXML
    private TextField date;

    void setup(User user) {
        this.user = user;
    }

    public void finish() {
        Transaction transaction = new Transaction(place.getText().trim(),
                date.getText().substring(0, 2).trim(), date.getText().trim(), type.getText().trim(), new Double(amount.getText().trim()));
        user.addTransaction(transaction);
    }

}
