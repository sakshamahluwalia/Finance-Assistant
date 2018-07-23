package Model;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author ashraf
 *
 */
public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Place,Date,Month,Amount,Type,Category";

    public static void writeCsvFile(User user) {


        //Create a new list of student objects

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("Transactions.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Transaction transaction : user.getTransactions()) {
                fileWriter.append(String.valueOf(transaction.getPlace()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transaction.getDate());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transaction.getMonth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transaction.getAmountString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transaction.getType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transaction.getCategory());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }



            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}