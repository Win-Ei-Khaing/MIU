package lesson8testing.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestingList {
public static void main(String[] args) {
	List list1=Arrays.asList("A", "B","C");
	List list2=Arrays.asList("D", "E","F");
	List[] listOfLists= {list1, list2};
	System.out.println(Arrays.toString(listOfLists));
	
	List<String> l1=new LinkedList<>();
	l1.add("A");
	List<String> l2=new ArrayList<String>();
	l2.add("B");
	ArrayList<List<String>> al=new ArrayList<List<String>>();
	al.add(l1);
	al.add(l2);
	System.out.println(al.toString());
}
}
