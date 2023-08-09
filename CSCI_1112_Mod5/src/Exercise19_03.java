/*
Author: Donnie Clark
Date: 8/9/2023

Description: For exercise 19-3
 */
import java.util.ArrayList;

public class Exercise19_03 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);

		ArrayList<Integer> newList = removeDuplicates(list);

		System.out.print(newList);
	}

	private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		int i = 0;
		while (!list.isEmpty()) {
			newList.add(list.get(i));
			int removeValue = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (list.contains(removeValue)) {
					list.remove(list.get(j));
				}
			}
		}
		return newList;
	}
}