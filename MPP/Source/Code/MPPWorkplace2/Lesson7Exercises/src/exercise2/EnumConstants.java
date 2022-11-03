package exercise2;

public enum EnumConstants{
	COMPANY("Microsoft"),
	SALES_TARGET(20000000);

	int intValue;
	String stringValue;

	EnumConstants(int value){
		intValue = value;
	}

	EnumConstants(String value){
		stringValue = value;
	}

	public int intValue() {
		return intValue;
	}

	public String stringValue() {
		return stringValue;
	}
}