public class Table {

    private int state; // Initializing state
    /**
     * Initializing states
     */
    private final int q1 = 0;
    private final int q2 = 1;
    private final int q3 = 2;
    private final int q4 = 3;
    private final int q5 = 4;


    /**
     *
     * Reprecentation of DFA Table using 2D Array
     */
    private final int[][] delta = {
            {q1, q2, q1, q1, q1},
            {q1, q3, q1, q2, q1},
            {q1, q3, q4, q2, q1},
            {q5, q2, q1, q1, q1},
            {q5, q5, q5, q5, q5}
    };

    public static void main(String[] args) {
        Table table = new Table();
        table.readWords();

    }

    public void readWords(){
        String [] words = {"GOOGLE","GOOGLLE","XXOOOXXXEELLLGOOGLEEEEEXXXXLLLOOOO","GOOOOOOOOOOOOOOOOOOOGGGGLLGGGOOOOOOGLEEEEEEXXXXO","GLE","GXGLE",""}; // Words to be tested
        for(String word : words){
            checkAlphabet(word); // Checking the alphabet and the transitions

        }
    }

    public void checkAlphabet (String word){
        int state = 0; // Resseting the initial State to start State


            for(char character : word.toCharArray()){

                /**
                 *
                 * Checking Transitions based on characters
                 */
               if(character == 'G' && state == delta[0][0] ){
                    state = delta[state][1];

               }


                else if(character == 'G' && state == delta[0][1] ){
                    state = delta[state][1];

                }

                else if(character == 'L' && state == delta[1][1] ){

                    state = delta[state][2];

                }

               else if(character == 'E' && state == delta[2][2] ){

                    state = delta[state][0];

                }

               /**
                *
                * Creating Loop if the character is O
                */
               else  if(state == 1 && character == 'O'){
                        state = delta[1][3];

                }
               /**
                *
                * Reseting the state back to start state
                */
               else if(state == 1 && (character == 'X' || character == 'L' || character == 'E' )){
                    state = delta[0][0];

                }
               else if(state == 2 && (character == 'X' || character == 'E' )){
                    state = delta[0][0];

                }
               else if(state == 2 && (character == 'G')){
                    state = delta[2][1];

                }
               else if(state == 2 && (character == 'O')){
                    state = delta[0][1];

               }
               else if(state == 3 && (character == 'L' || character == 'O' || character == 'X' )){
                    state = delta[0][0];

                }
               else if(state == 3 && (character == 'G')){
                    state = delta[1][3];

                }





            }

//            System.out.println("WORD:"+word+" "+(state == q5 ? "Accepted" : "Rejected")); // Ternary operation to check if the word is accepted or rejected
            checkifAccepted(state,word);
            state=0; // Resseting state after each checking




    }

    /**
     * Method to print if word is accepted or no
     * @param state
     * @param word
     */
    public void checkifAccepted(int state,String word ){

        System.out.println("WORD:"+word+" "+(state == q5 ? "Accepted" : "Rejected")); // Ternary operation to check if the word is accepted or rejected
    }

}