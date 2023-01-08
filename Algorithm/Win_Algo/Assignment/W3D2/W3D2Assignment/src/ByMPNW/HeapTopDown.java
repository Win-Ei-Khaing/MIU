package ByMPNW;

import java.util.Arrays;

public class HeapTopDown {

    public static void main(String[] args) {
        //    int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//    int[] array = new int[]{0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
//    int[] array = new int[]{0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] array = new int[]{0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};

        HeapTopDown heap = new HeapTopDown();
        heap.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            upHead(array, i);
        }
    }

    private void upHead(int[] array, int index) {
        int i = index;
        while (i > 1) {
            int parent = i / 2;
            int child = i;
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            }
            i /= 2;
        }
    }

    private void swap(int[] array, int parent, int child) {
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }

}
