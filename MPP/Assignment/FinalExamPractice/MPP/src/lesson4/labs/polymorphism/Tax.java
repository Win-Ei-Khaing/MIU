package lesson4.labs.polymorphism;

public enum Tax {
	fica(0.23),
	state(0.05),
	local(0.01),
	medicare(0.03),
	socialSecurity(0.075);
	
	private final double taxValue;  
	
	Tax(double value)
	{
		this.taxValue= value;
	}
	
	public double getValue()
	{
		return this.taxValue;
	}
}
