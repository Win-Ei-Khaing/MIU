import java.util.Random;

public class AssignmentTwo {
    public static void main(String[] args){
//        int[] inputs = { 7,20,18,4,20,19,20,3 };
        int[] inputs = generateEvenRandomNumberArray(10000);
        for (int i=0; i<inputs.length; i++){
            System.out.println("Index : "+i+" ,Value : "+inputs[i]);
        }
        System.out.println();
        System.out.println("The third largest number using Algorithm One is ------ "+findThirdLargestAlgorithmOne(inputs));
        System.out.println();
        System.out.println("The third largest number using Algorithm Two is ------ "+findThirdLargestAlgorithmTwo(inputs));

    }

    // Retrieves the third largest element from a given array using three separate loops
    private static int findThirdLargestAlgorithmOne(int[] inputs) {
        int largest = Integer.MIN_VALUE;
        int firstIndex = 0;
        int secondIndex = 0;
        long startTime = System.nanoTime();
        // Retrieves the index where first largest element exists
        for(int i=0; i<inputs.length; i++){
            if(inputs[i] > largest){
                largest = inputs[i];
                firstIndex = i;
            }
        }
        largest = Integer.MIN_VALUE;

        // Retrieves the index where second largest element exists
        for(int i=0; i<inputs.length; i++){
            if(inputs[i] > largest && i != firstIndex){
                largest = inputs[i];
                secondIndex = i;
            }
        }

        largest = Integer.MIN_VALUE;
        // Retrieves the third largest element
        for(int i=0; i<inputs.length; i++){
            if(inputs[i] > largest && i != firstIndex && i != secondIndex){
                largest = inputs[i];
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm One ---> "+(endTime - startTime)+" nanoseconds");
        return largest;
    }

    // Retrieves the third largest element from a given array using three a single loop
    private static int findThirdLargestAlgorithmTwo(int[] inputs){
        int max = inputs[0];
        int preMax = inputs[0];
        int prePreMax = inputs[0];
        long startTime = System.nanoTime();
        for (int i=0; i<inputs.length; i++){
            if(inputs[i] > max){
                prePreMax = preMax;
                preMax = max;
                max = inputs[i];
            }else if (inputs[i] > preMax){
                prePreMax = preMax;
                preMax = inputs[i];
            }else if(inputs[i] > prePreMax){
                prePreMax = inputs[i];
            }else{
                continue;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm Two ---> "+(endTime - startTime)+" nanoseconds");
        return prePreMax;
    }

    // --------- METHOD TO GENERATE ARRAY OF NUMBERS ----------//
    // Generate an array containing random numbers
    public static int[] generateEvenRandomNumberArray(int size){
        int[] randomNumbersArray = new int[size];
        int counter = 0;
        Random random = new Random();
        int lowestNumber = 1;
        int highestNumber = 100;
        int number ;
        while(counter != size){
            number = random.nextInt(highestNumber - lowestNumber) + lowestNumber;
            if(number != 0){
                randomNumbersArray[counter]= number;
                counter++;
            }
        }
        return randomNumbersArray;
    }
}
