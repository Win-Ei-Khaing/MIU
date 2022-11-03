package lesson7.labs.prob5;

public interface Flyable {
   public default void fly()
   {
	   System.out.println("\tFly with Wings");
   }
}
