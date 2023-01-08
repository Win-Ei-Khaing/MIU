import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Find the largest distance between any two even integers in an integer array.
 **/
public class Question1 {
	int max = 100000, min = 10;
	int size1 = 1000, size2 = 2000, size3 = 3000, size4 = 4000;
	ArrayList<Integer> list1, list2, list3, list4;

	public static void main(String[] args) {
		Question1 lab1 = new Question1();
		lab1.createList();
		System.out.println("ALGORITHM 1 ");
		lab1.algorithm1(lab1.list1);
		lab1.algorithm1(lab1.list2);
		lab1.algorithm1(lab1.list3);
		lab1.algorithm1(lab1.list4);

		System.out.println("ALGORITHM 2");
		lab1.algorithm2(lab1.list1);
		lab1.algorithm2(lab1.list2);
		lab1.algorithm2(lab1.list3);
		lab1.algorithm2(lab1.list4);

		System.out.println("ALGORITHM 3");
		lab1.algorithm3(lab1.list1);
		lab1.algorithm3(lab1.list2);
		lab1.algorithm3(lab1.list3);
		lab1.algorithm3(lab1.list4);


		System.out.println("ALGORITHM 4");
		lab1.algorithm4(lab1.list1);
		lab1.algorithm4(lab1.list2);
		lab1.algorithm4(lab1.list3);
		lab1.algorithm4(lab1.list4);

	}

	/*
	 * Algorithm 1
	 * Create a new array consisting of even numbers only. Then use nested loops to solve
	 * the problem using the newly created array of even numbers only.
	 * */
	private void algorithm1(ArrayList<Integer> list) {

		int distance = 0;
		long time = System.currentTimeMillis();
		ArrayList<Integer> listEven = new ArrayList<>();
		for (int i : list)
			if (i % 2 == 0) listEven.add(i);

		for (int i = 0; i < listEven.size(); i++) {
			for (int j = i + 1; j < listEven.size(); j++) {
				int diff = Math.abs(listEven.get(i) - listEven.get(j));
				if (diff > distance)
					distance = diff;
			}
		}
		System.out.println("Max distance =  " + distance + "; Time to calculate = " + (System.currentTimeMillis() - time)
				+ "; List Size = " + list.size());
	}

	/*
	 * Algorithm 2
	 * Use a nested loop to solve the problem without creating an extra array.
	 * */
	private void algorithm2(ArrayList<Integer> list) {
		int distance = 0;
		long time = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(j) % 2 == 0) {
						int diff = Math.abs(list.get(i) - list.get(j));
						if (diff > distance)
							distance = diff;
					}
				}
			}
		}
		System.out.println("Max distance = " + distance + "; Time to calculate = " + (System.currentTimeMillis() - time) + "; List Size = " + list.size());
	}

	/*
	 * Algorithm 3
	 * Use one loop. Find max and min of even integers. Compute max – min.
	 * */
	private void algorithm3(ArrayList<Integer> list) {
		int min = list.get(0);
		int max = list.get(0);
		long time = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				if (list.get(i) > max) max = list.get(i);
				else if (list.get(i) < min) min = list.get(i);
			}
		}
		System.out.println("Max distance = " + (max - min) + "; Time to calculate =  " + (System.currentTimeMillis() - time) + "; List Size = " + list.size());
	}

	/*
	 * Algorithm 4
	 * Use Streams to find the max and min. Compute max – min.
	 * */
	private void algorithm4(ArrayList<Integer> list) {
		long time = System.currentTimeMillis();
		IntSummaryStatistics intSummaryStatistics = list.stream().filter(x -> x % 2 == 0).collect(Collectors.summarizingInt(Integer::intValue));
		int max = intSummaryStatistics.getMax();
		int min = intSummaryStatistics.getMin();
		System.out.println("Max distance = " + (max - min) + "; Time to calculate =  " + (System.currentTimeMillis() - time) + "; List Size = " + list.size());

	}


	private void createList() {

		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		list3 = new ArrayList<>();
		list4 = new ArrayList<>();

		Random r = new Random();

		for (int i = 0; i < size1; i++)
			list1.add(r.nextInt(1000));

		for (int i = 0; i < size2; i++)
			list2.add(r.nextInt(1000));

		for (int i = 0; i < size3; i++)
			list3.add(r.nextInt(1000));

		for (int i = 0; i < size4; i++)
			list4.add(r.nextInt(1000));
	}

}

