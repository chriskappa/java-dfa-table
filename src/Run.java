import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Alphabet = E, G, L, O, X
 */

public class Run {

    // Nfa example
    Table table = new Table();

    /**
     * IO Helpers
     */
    private void importFileAndRead () {
        File file = new File(System.getProperty("user.dir") + "/words.txt");

        if (!file.exists()) {
            System.out.println("The file you are trying to read does not exist.");
            return;
        }

        readFile(file);
    }

    /**
     * Please edit lines 68 and 69 to swap between both methods.
     *
     * @param file File
     */
    private void readFile (File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String w = scanner.nextLine();
                String result = nfaParallel.checkWord(w);

                System.out.println(w + ": " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        Run main = new Run();
        main.importFileAndRead();
    }

}