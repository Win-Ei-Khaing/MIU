package prob2;

public class LendingItem {
	private Integer numCopiesInLib;

	public Integer getNumCopiesInLib() {
		return numCopiesInLib;
	}

	public void setNumCopiesInLib(Integer num) {
		numCopiesInLib = num;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof LendingItem)) return false;
		LendingItem item = (LendingItem)obj;
		return numCopiesInLib.equals(item.numCopiesInLib);
	}
	
}
