/*
Author: Donnie Clark
Date: 8/9/2023

Description: For exercise 19-5
 */
public class Exercise19_05 {
	public static void main(String[] args) {
		Integer[] numbers = {1, 2, 3};
		System.out.println(max(numbers));

		String[] words = {"red", "green", "blue"};
		System.out.println(max(words));

		Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
		System.out.println(max(circles));
	}

	private static <E extends Comparable<E>> E max(E[] list){
		E largest = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i].compareTo(largest) > 0) {
				largest = list[i];
			}
		}
		return largest;
	}

	static class Circle implements Comparable<Circle> {
		double radius;

		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public int compareTo(Circle c) {
			if (radius < c.radius) 
				return -1;
			else if (radius == c.radius)
				return 0;
			else
				return 1;
		}

		@Override
		public String toString() {
			return "Circle radius: " + radius;
		}
	}
}
