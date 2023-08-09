/*
Author: Donnie Clark
Date: 8/9/2023

Description: For exercise 19-9
 */
import java.util.ArrayList;
import java.util.Stack;

public class Exercise19_09 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);
		Exercise19_09.<Integer>sort(list);

		System.out.print(list);
	}

	private static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		E currentMax;
		Stack<E> ordered = new Stack<E>();
		int spaces = list.size();
		for (int i = 0; i < list.size() - 1;) {
			currentMax = list.get(0);
			int toRemove = 0;
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMax.compareTo(list.get(j)) < 0) {
					currentMax = list.get(j);
					toRemove = j;
				}
			}
			list.remove(toRemove);
			ordered.push(currentMax);
		}
		
		for (int i = 0; i < spaces - 1; i++) {
			list.add(ordered.pop());
		}
	}
}
