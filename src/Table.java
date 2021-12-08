public class Table {

    private int state;

    private final int q1 = 0;
    private final int q2 = 1;
    private final int q3 = 2;
    private final int q4 = 3;
    private final int q5 = 4;

    private final int[][] delta = {
            {q1, q2, q1, q1, q1},
            {q1, q3, q1, q2, q1},
            {q1, q3, q4, q2, q1},
            {q5, q2, q1, q1, q1},
            {q5, q5, q5, q5, q5}
    };

    public static void main(String[] args) {
        Table t = new Table();
        t.test();

    }

    public void test (){
//        GGLE
        int state = 0;
        String [] words = {"GOOGLE","GOOGLLE","XXOOOXXXEELLLGOOGLEEEEEXXXXLLLOOOO","GOOOOOOOOOOOOOOOOOOOGGGGLLGGGOOOOOOGLEEEEEEXXXXO","GLE","GXGLE"};
        char [] alphabet = {'G','L','O','E','X'};
        for(String word : words){
            for(char character : word.toCharArray()){


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

               else  if(state == 1 && character == 'O'){
                        state = delta[1][3];

                }
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

            System.out.println("WORD:"+word+" "+(state == q5));
            state=0;
        }



    }

}