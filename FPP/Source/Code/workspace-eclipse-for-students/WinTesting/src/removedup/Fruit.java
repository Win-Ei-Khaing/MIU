package removedup;

public class Fruit {
	private String name;
	Fruit(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Fruit name is "+name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Fruit f=(Fruit)obj;
		boolean isEqual=this.name.equals(f.name);
		return isEqual;
	}
}
