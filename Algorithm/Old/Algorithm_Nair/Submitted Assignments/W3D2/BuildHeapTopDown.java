public class BuildHeapTopDown {

    // private static int[] input = {0,17, 20, 1, 75, 60, 5, 14, 99, 82 };
    // private static int[] input = {0,7, 8, 15, 25, 6, 9, 3, 4, 2 };
    private static int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    // private static int[] input ={0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14,
    // 13, 16, 15};
    // private static int[] input ={0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13,
    // 14, 16, 15};
    // private static int[] input ={5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12,
    // 11, 9};
    private static int[] sortedArray = new int[input.length];
    private static int size = input.length - 1;
    private static int current = 2;
    private static int numberOfComparisons = 0;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("Before Top Down Heaping");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        buildHeapTopDown();
        System.out.println("---------------------------------------------");
        System.out.println("After Top Down Heaping");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Number of comparisons for building max heap using Top Down : " + numberOfComparisons);
        System.out.println("-----------------------------------------------------------------");
    }

    // Returning true if given node is a root
    public static boolean isRoot(int pos) {
        return (pos <= 0);
    }

    public static void swap(int indexOne, int indexTwo) {
        int temp = input[indexOne];
        input[indexOne] = input[indexTwo];
        input[indexTwo] = temp;
    }

    // Recursive function to max heapify given subtree
    public static void maxHeapify(int child) {
        int parent = child / 2;
        if (isRoot(parent))
            return;
        numberOfComparisons++;
        if (input[parent] < input[child]) {
            swap(parent, child);
            maxHeapify(parent);
        }
    }

    // Builds Heap from Top Down
    public static void buildHeapTopDown() {
        int parent;
        while (current <= size) {
            parent = current / 2;
            numberOfComparisons++;
            if (input[current] > input[parent]) {
                swap(current, parent);
                maxHeapify(parent);
            }
            current++;
        }
    }
}
