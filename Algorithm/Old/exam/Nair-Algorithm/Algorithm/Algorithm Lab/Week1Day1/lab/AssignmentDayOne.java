package algorithm.lab;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

public class AssignmentDayOne {
	int max = 77000;
	int min =30;
	int inputSize1 = 1000;
	int inputSize2 = 2000;
	int inputSize3 = 3000;
	int inputSize4 = 4000;
	ArrayList<Integer>listNum1, listNum2, listNum3, listNum4;
	
	public static void main(String[]args) {
		AssignmentDayOne dayOne= new AssignmentDayOne();
		dayOne.randomList();
		System.out.println("Algo number one");
		dayOne.firstAlgorithm(dayOne.listNum1);
		dayOne.firstAlgorithm(dayOne.listNum2);
		dayOne.firstAlgorithm(dayOne.listNum3);
		dayOne.firstAlgorithm(dayOne.listNum4);
		
		System.out.println("Algo number two");
		dayOne.secondAlgorithm(dayOne.listNum1);
		dayOne.secondAlgorithm(dayOne.listNum1);
		dayOne.secondAlgorithm(dayOne.listNum1);
		dayOne.secondAlgorithm(dayOne.listNum1);
		
		System.out.println("Algo number three");
		dayOne.thirdAlgorithm(dayOne.listNum1);
		dayOne.thirdAlgorithm(dayOne.listNum2);
		dayOne.thirdAlgorithm(dayOne.listNum3);
		dayOne.thirdAlgorithm(dayOne.listNum4);
		
		System.out.println("Algo number four");
		dayOne.forthAlgorithm(dayOne.listNum1);
		dayOne.thirdAlgorithm(dayOne.listNum2);
		dayOne.thirdAlgorithm(dayOne.listNum3);
		dayOne.thirdAlgorithm(dayOne.listNum4);
	}
	
		private void firstAlgorithm(ArrayList<Integer>list) {
			int distance = 0;
			long time = System.currentTimeMillis();
			ArrayList<Integer> evenNums= new ArrayList();
			for(int i :list)
				if(i%2 == 0)evenNums.add(i);
			for(int i = 0; i < evenNums.size();i++) {
				for(int j= i+1 ; j < evenNums.size();j++) {
					int ad = Math.abs(evenNums.get(i)- evenNums.get(j));
					if(ad > distance);
					distance = ad;
				}
			}
			System.out.println("longest distance = "+ distance + " Time calculated ="
					+ (System.currentTimeMillis()- time ) + "ListSize = " + list.size());
		}
		private void secondAlgorithm(ArrayList<Integer> nums) {
			int distance = 0;
			long time= System.currentTimeMillis();
			for(int i = 0 ; i < nums.size();i++) {
				
					if(nums.get(i)%2==0){
						for (int j = i+1; j <nums.size();j++) {
							if(nums.get(j)%2==0) {
								int df = Math.abs(nums.get(i)-nums.get(j));
								if(df > distance);
								distance = df;
							}
						}
						
						
					}
				}
			System.out.println("longest distance = "+ distance + "Time calculated ="
					+ (System.currentTimeMillis()- time )+ "ListSize = " + nums.size());
			
			}
		private void thirdAlgorithm(ArrayList<Integer> num3) {
			int max= num3.get(0);
			int min= num3.get(0);
			long time = System.currentTimeMillis();
			for(int i= 0; i < num3.size();i++) {
				if(num3.get(i)%2==0) {
					if(num3.get(i)> max)
						max= num3.get(i);
					else if(num3.get(i)<min) min = num3.get(i);
				}
			}
			System.out.println("largest distance is " + (max-min) + " Time calculated = "
			
						+ (System.currentTimeMillis()- time )+ "ListSize = " + num3.size());
			
		}
		private void forthAlgorithm(ArrayList<Integer> list) {
			long time = System.currentTimeMillis();
			IntSummaryStatistics intSummaryStatistics = list.stream().filter(x -> x % 2 == 0).collect(Collectors.summarizingInt(Integer::intValue));
			int max = intSummaryStatistics.getMax();
			int min = intSummaryStatistics.getMin();
			System.out.println("largest distance is = "  + (max - min) + "; Time to calculate =  " + (System.currentTimeMillis() - time) + "; List Size = " + list.size());
		}
		
		public void randomList() {
		listNum1 = new ArrayList();
			listNum2 = new ArrayList();
			listNum3 = new ArrayList();
			listNum4 = new ArrayList();
			Random rand = new Random();
			for(int i = 0; i < inputSize1; i++) 
				listNum1.add(rand.nextInt(1000));
				for(int i = 0 ; i < inputSize2; i++)
					listNum2.add(rand.nextInt(1000));
				for(int i = 0 ; i < inputSize3; i++)
					listNum3.add(rand.nextInt(1000));
				for(int i = 0 ; i < inputSize3;i++)
					listNum4.add(rand.nextInt(1000));
				
		}
	}
	


