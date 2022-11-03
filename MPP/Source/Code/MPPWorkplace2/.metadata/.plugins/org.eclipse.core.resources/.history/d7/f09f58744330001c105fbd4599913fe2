package prob2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Admin {
	//Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
	public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
		List<String> phoneNums = new ArrayList<>();
		//implemented by Win
		for(LibraryMember member : members) {
			CheckoutRecord record = member.getCheckoutRecord();
			for(CheckoutRecordEntry entry : record.getCheckoutEntryList()) {
				if(entry.getLendingItem().equals(item))
					phoneNums.add(member.getPhone());
			}
		}
		Collections.sort(phoneNums);
		return phoneNums;
	}

	public static List<String> getPhoneNumsByStream(LibraryMember[] members, LendingItem item) {

		List<String> phoneNums = new ArrayList<>();
		//implemented by Win
		/*Stream.of(members)
		.filter(m->m.getCheckoutRecord().getCheckoutEntryList().size()>0)
		.sorted(Comparator.comparing(LibraryMember::getPhone))
		.forEach(m->{
			for(CheckoutRecordEntry entry: m.getCheckoutRecord().getCheckoutEntryList()){
				if(entry.getLendingItem().equals(item))
					phoneNums.add(m.getPhone());
			}
		});*/

		phoneNums =  Stream.of(members)
				.filter(m->m.getCheckoutRecord().getCheckoutEntryList().size()>0)
				.filter(m->m.getCheckoutRecord().getCheckoutEntryList().contains(new CheckoutRecordEntry(item, null, null, null)))
				.map(m->m.getPhone())
				.sorted()
				.collect(Collectors.toList());
		
		return phoneNums;
	}
}
