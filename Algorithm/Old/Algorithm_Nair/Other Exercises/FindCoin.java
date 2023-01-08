public class FindCoin {

    public static void main(String[] args){
        int[] G = { 2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2 };
        System.out.println("The less weighted coin is found in group "+findCoin(G, null, true));
    }

    private static String findCoin(int[] G, String letter, boolean isFirst) {
        if(G.length > 3){
            int n = G.length/3;
            String groupLetterOne, groupLetterTwo, groupLetterThree, groupLetter;
            int[] A = new int[n];
            int[] B = new int[n];
            int[] C = new int[n];
            System.arraycopy(G, 0, A, 0, n);
            System.arraycopy(G, n, B, 0, n);
            System.arraycopy(G, 2*n, C, 0, n);
            groupLetterOne = findCoin(A, "A", false);
            groupLetterTwo = findCoin(B, "B", false);
            groupLetterThree = findCoin(C, "C", false);
            for (int i=0; i<A.length; i++){
                System.out.println("A"+A[i]);
            }
            System.out.println("---------");
            for (int i=0; i<B.length; i++){
                System.out.println("B"+B[i]);
            }
            System.out.println("---------");
            for (int i=0; i<C.length; i++){
                System.out.println("C"+C[i]);
            }
            System.out.println("---------");
            System.out.println("Letter One --- "+groupLetterOne);
            System.out.println("Letter two --- "+groupLetterTwo);
            System.out.println("Letter Three --- "+groupLetterThree);
            groupLetter = compareLetters(groupLetterOne, groupLetterTwo, groupLetterThree);
            System.out.println("After letter comparison --- "+groupLetter);
            System.out.println("---------");
            return groupLetter;

        }else{
            return compareWeights(G, letter);
        }

    }


    private static String compareLetters(String lOne, String lTwo, String lThree){
        String groupLetter = "X";
        if(lOne == "A" || lOne == "B" || lOne == "C"){
            groupLetter = lOne;
        }
        else if(lTwo == "A" || lTwo == "B" || lTwo == "C"){
            groupLetter = lTwo;
        }
        else if(lThree == "A" || lThree == "B" || lThree == "C"){
            groupLetter = lThree;
        }else{
            groupLetter = "X";
        }
        return groupLetter;
    }


    private static String compareWeights(int[] G, String group){
        String groupLetter = group;
        if(G[0] == G[1] && G[0] == G[2] && G[1] == G[2]){
            groupLetter = "X";
        }
        return groupLetter;
    }


}
