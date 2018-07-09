package Model.Filters;

import Model.Transaction;
import java.util.ArrayList;

public abstract class Filter {

    public abstract ArrayList<Transaction> afterFilter(ArrayList<Transaction> transactions);
}
