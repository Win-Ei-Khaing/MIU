package lesson4.equals.simple;

class Person {
	private String name;

	public Person(String n) {
		name = n;
	}
	public String getName() {
			return name;
	}
	@Override   //Cannot change type of argument to Person
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
}
