package problem04;

public class SecondSmallestInteger {
    public static int secondSmallest(int[] arr) {
        if(arr==null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }
        int smallest = arr[0];
        int secondSmallest = arr[1];
        for(int z: arr){
            if(z == smallest)
                continue;
            if(z < smallest){
                secondSmallest = smallest;
                smallest = z;
                continue;
            }
            if(z< secondSmallest)
                secondSmallest = z;
        }
        return secondSmallest;
        }
        public static void main(String[] args) {
            int[] arr = new int[]{1, 4, 2, 3};
            System.out.println(secondSmallest(arr));
            arr = new int[]{3, 3, 4, 7};
            System.out.println(secondSmallest(arr));
//            arr = new int[]{9};
            System.out.println(secondSmallest(arr));
        }
}