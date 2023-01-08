public class BuildHeapBottomUp {

    //    private static int[] input = {0,17, 20, 1, 75, 60, 5, 14, 99, 82 };
//    private static int[] input = {0,1, 2,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
//    private static int[] input ={0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
//    private static int[] input ={0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
    private static int[] input ={0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
    private static int size = input.length-1;
    private static int[] sortedArray = new int[input.length];
    private static int current = size/2;
    private static int numberOfComparisons = 0;

    public static void main(String[] args){
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Before Bottom Up Heaping");
        for (int i =0; i< input.length; i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
        buildHeapBottomUp();
        System.out.println("---------------------------------------------");
        System.out.println("After Bottom Up Heaping");
        for (int i =0; i< input.length; i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of comparisons for building max heap using Bottom Up : "+numberOfComparisons);
        System.out.println("-----------------------------------------------------------------");
    }

    // Returning true if given node is a leaf
    public static boolean isLeaf(int pos){
        return (pos > (size / 2) && pos <= size);
    }

    public static void swap(int indexOne, int indexTwo){
        int temp = input[indexOne];
        input[indexOne] = input[indexTwo];
        input[indexTwo] = temp;
    }

    // Recursive function to max heapify given subtree
    public static void maxHeapify(int position)
    {
        if (isLeaf(position))
            return;

        int leftChild = position*2;
        int rightChild = leftChild +1;
        numberOfComparisons++;
        if(rightChild > size){
            if(input[position] < input[leftChild]){
                swap(position, leftChild);
                maxHeapify(leftChild);
            }
        }else{

            if (input[position] < input[leftChild]
                    || input[position] < input[rightChild]) {
                numberOfComparisons = numberOfComparisons+2;
                if(input[rightChild] >= input[leftChild] && input[position] < input[rightChild]){
                    numberOfComparisons = numberOfComparisons+2;
                    swap(position, rightChild);
                    maxHeapify(rightChild);
                }

                if(input[rightChild] < input[leftChild] && input[position] < input[leftChild]){
                    numberOfComparisons = numberOfComparisons+2;
                    swap(position, leftChild);
                    maxHeapify(leftChild);
                }
            }
        }

    }
    // Builds Heap from Bottom Up
    public static void buildHeapBottomUp(){
        int leftChild, rightChild;
        while(current > 0){
            leftChild = current * 2;
            rightChild = leftChild + 1;
            if(rightChild > size){
                swap(current, leftChild);
            }else{
                if(input[leftChild] > input[rightChild] && input[current] < input[leftChild]){
                    numberOfComparisons = numberOfComparisons+2;
                    swap(current, leftChild);
                    maxHeapify(leftChild);
                }
                if(input[rightChild] > input[leftChild] && input[current] < input[rightChild]){
                    numberOfComparisons = numberOfComparisons+2;
                    swap(current, rightChild);
                    maxHeapify(rightChild);
                }
            }
            current--;
        }

    }
}
