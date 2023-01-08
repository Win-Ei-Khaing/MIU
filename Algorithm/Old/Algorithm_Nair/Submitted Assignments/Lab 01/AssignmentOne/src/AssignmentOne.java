import java.util.Arrays;
import java.util.Random;

public class AssignmentOne {

    public static void main(String[] args){

        // ------------------------ Generate Array of random numbers ------------------------- //
        int[] inputs = generateEvenRandomNumberArray(10000);
        for (int i=0; i<inputs.length; i++){
            System.out.println("Index : "+i+" ,Value : "+inputs[i]);
        }

        // ------------------------ Display results on the console --------------------------- //
        System.out.println();
        System.out.println("Maximum Distance using Algorithm One ----> "+ algorithmOne(inputs));

        System.out.println();
        System.out.println("Maximum Distance using Algorithm Two ----> "+ algorithmTwo(inputs));

        System.out.println();
        System.out.println("Maximum Distance using Algorithm Three ----> "+ algorithmThree(inputs));

        System.out.println();
        System.out.println("Maximum Distance using Algorithm Four ----> "+ algorithmFour(inputs));
    }

    // --------- ALGORITHM ONE ------------------//
    // Maximum distance using newly created array
    public static int algorithmOne(int[] inputs){
        int maximumDistance = Integer.MIN_VALUE;;
        int counter = 0;
        long startTime = System.nanoTime();
        int[] evenNumberArray = new int[inputs.length];
        for(int i= 0; i<inputs.length; i++){
            if(inputs[i] % 2 == 0 ){
                evenNumberArray[counter] = inputs[i];
                counter++;
            }
        }

        // Copy the elements of the new array to a new array
        int[] evenArray = new int[counter];
        for(int i=0; i<counter; i++){
            evenArray[i] = evenNumberArray[i];
        }
        // Delete the array after being copied
        evenNumberArray = null;

        for (int i=0; i<evenArray.length; i++){
            for(int j=i+1; j<evenArray.length; j++){
                int distance = Math.abs(evenArray[i] - evenArray[j]);
                if(maximumDistance < distance){
                    maximumDistance = distance;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm One ---> "+(endTime - startTime)+" nanoseconds");
        return maximumDistance;
    }

    // ----------- ALGORITHM TWO -----------------//
    // Maximum distance without creating a new array
    public static int algorithmTwo(int[] inputs){
        int maximumDistance = Integer.MIN_VALUE;
        long startTime = System.nanoTime();
        for (int i=0; i<inputs.length; i++){
            if(inputs[i] % 2 == 0){
                for(int j=i+1; j<inputs.length; j++){
                    if(inputs[j] % 2 == 0){
                        int distance = Math.abs(inputs[i] - inputs[j]);
                        if(maximumDistance < distance){
                            maximumDistance = distance;
                        }
                    }
                }
            }

        }
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm Two ---> "+(endTime - startTime)+" nanoseconds");
        return maximumDistance;
    }

    // -------------- ALGORITHM THREE -----------------//
    // Maximum distance using maximum and minimum values
    public static int algorithmThree(int[] inputs){
        int maximumNumber = Integer.MIN_VALUE;
        int minimumNumber = Integer.MAX_VALUE;
        long startTime = System.nanoTime();
        for (int i=0; i<inputs.length; i++){
            if(inputs[i] % 2 == 0){
                if(inputs[i] < minimumNumber){
                    minimumNumber = inputs[i];
                }
                if(inputs[i] > maximumNumber){
                    maximumNumber = inputs[i];
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm Three ---> "+(endTime - startTime)+" nanoseconds");
        return maximumNumber - minimumNumber;
    }

    // ------------ ALGORITHM FOUR ---------------//
    // Maximum distance using streams
    public static int algorithmFour(int[] inputs){
        long startTime = System.nanoTime();
        int maximumNumber = Arrays.stream(inputs).filter(i -> i % 2== 0).max().getAsInt();
        int minimumNumber = Arrays.stream(inputs).filter(i -> i % 2== 0).min().getAsInt();
        long endTime = System.nanoTime();
        System.out.println("Running time for Algorithm Four ---> "+(endTime - startTime)+" nanoseconds");
        return maximumNumber - minimumNumber;
    }

    // --------- METHOD TO GENERATE ARRAY OF NUMBERS ----------//
    // Generate an array containing random numbers
    public static int[] generateEvenRandomNumberArray(int size){
        int[] randomNumbersArray = new int[size];
        int counter = 0;
        Random random = new Random();
        int lowestNumber = 1;
        int highestNumber = 83;
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
