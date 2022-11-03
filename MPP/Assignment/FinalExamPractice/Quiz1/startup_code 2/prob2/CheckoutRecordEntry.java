package prob2;

import java.time.LocalDate;

public class CheckoutRecordEntry {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	private ItemType type;
	private LendingItem item;
	
	public CheckoutRecordEntry(LendingItem item, LocalDate chDate, LocalDate dueDate, ItemType type) {
		this.item = item;
		checkoutDate = chDate;
		this.dueDate = dueDate;
		this.type = type;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public ItemType getLendingItemType() {
		return type;
	}

	public LendingItem getLendingItem() {
		return item;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof CheckoutRecordEntry)) return false;
		CheckoutRecordEntry e = (CheckoutRecordEntry)obj;
		return item.equals(e.getLendingItem());
	}
}
