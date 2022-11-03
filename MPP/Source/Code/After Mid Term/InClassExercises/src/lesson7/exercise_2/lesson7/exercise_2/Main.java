package lesson7.exercise_2;

public class Main {

	public static void main(String[] args) {
		//System.out.println(Constants.COMPANY);
		//System.out.println(Constants.SALES_TARGET);

		System.out.println("From enum : ");
		System.out.println(EnumConstants.COMPANY.valInteger());
		System.out.println(EnumConstants.SALES_TARGET.valString());
	}

}
