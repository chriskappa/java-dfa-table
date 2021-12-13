import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Σ= {E, G, L, O, X}
 */

public class Run {


    Table table = new Table();


    /**
     * Reading File from the path folder
     * @param file
     */

    private void readFile (File file) {
        try {
            Scanner scanner = new Scanner(file); // Getting user input

            // Checking file the file has more words to read
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                table.checkAlphabet(word); // Passing the word to the checkAlphabet method
            }
        } catch (IOException e) {
            e.printStackTrace(); // Catching the Input Output Exception
        }
    }

    private void readFile () {
        File file = new File(System.getProperty("user.dir") + "/words.txt"); // Creating words txt document to keep the words we want to test
        readFile(file); // Passing the file object to the read file method
    }


    public static void main (String[] args) {
        Run main = new Run();
        main.readFile();
    }

}