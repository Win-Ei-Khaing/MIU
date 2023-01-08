package problem03;

/**
 * GreatestCommonDivisor
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(12, 42));
        System.out.println(gcd(7, 9));
    }; 

    // Using Euclidean Algorithm
    public static int gcd(int a, int b){
        if(a == 0) return b;
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}