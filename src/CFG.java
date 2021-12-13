import java.util.Scanner;

public class CFG {

    private int currState;

    public static void main(String[] args) {
    CFG t = new CFG();
    Scanner scanner = new Scanner(System.in);
    String word;
    do {
        System.out.println("Enter Your Word");
        word = scanner.next();
        String res = t.checkWord(word);
        System.out.println(res);
    }while(word != "q");
    }
    public String checkWord (String word) {
        currState = 0;
        for (int i = 0; i < word.length(); i++) {
            checkWords(word.charAt(i));
        }

        return (currState == 4) ? word+" IS ACCEPTED" : word+" IS REJECTED";
    }

//

    private void checkWords(char next) {
        switch (currState) {
            case 0:
                switch (next) {
                    case 'G':
                        currState ++;
                        break;
                }
                break;
            case 1:
                switch (next) {
                    case 'G':
                        currState ++;
                        break;
                    case 'O':
                        break;
                    default:
                        currState = 0;
                        break;
                }
                break;
            case 2:
                switch (next) {
                    case 'G':
                        break;
                    case 'O':
                        currState --;
                        break;
                    case 'L':
                        currState ++;
                        break;
                    default:
                        currState = 0;
                        break;
                }
                break;
            case 3:
                switch (next) {
                    case 'E':
                        currState ++;
                        break;
                    default:
                        currState = 0;
                        break;
                }
                break;
            default:
                //stay where it is
        }
    }




}