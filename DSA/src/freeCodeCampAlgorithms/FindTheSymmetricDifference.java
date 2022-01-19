package freeCodeCampAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

/* Problem:Find the Symmetric Difference
The mathematical term symmetric difference (△ or ⊕) of two sets is the set of elements 
which are in either of the two sets but not in both. 

For example, for sets A = {1, 2, 3} and B = {2, 3, 4}, A △ B = {1, 4}.
Symmetric difference is a binary operation, which means it operates on only has two elements.

So to evaluate an expression involving symmetric differences among three elements (A △ B △ C),
you must complete one operation at a time.
Thus, for sets A and B above,and C = {2, 3}, A △ B △ C = (A △ B) △ C = {1, 4} △ {2, 3} = {1, 2, 3, 4}.*/

public class FindTheSymmetricDifference {
	public static void main(String args[]) {
// Defining the input array 
		int[] firstList = new int[] { 1, 2, 3 };
		int[] secondList = new int[] { 2, 3, 4 };
//	    Defining the output array
		int[] union, inter, result;

// starting 
		int count = 0;
		int max = firstList.length + secondList.length;
		ArrayList<Integer> temp = new ArrayList<Integer>(max);

// Step 1 :  For Union adding both list to Temp

		for (int i = 0; i < firstList.length; i++) {
			if (!temp.contains(firstList[i])) {
				++count;
				temp.add(firstList[i]);
			}
		}

		for (int i = 0; i < secondList.length; i++) {
			if (!temp.contains(secondList[i])) {
				++count;
				temp.add(secondList[i]);
			}
		}

		union = new int[count];
		for (int i = 0; i < count; i++) {
			union[i] = (int) temp.get(i);
		}
		// Sorting the union array.
		Arrays.sort(union);

// Step 2:  For Intersection 

		temp = new ArrayList<Integer>(max);
		count = 0;
		Arrays.sort(secondList);
		for (int i = 0; i < firstList.length; i++) {
			if (Arrays.binarySearch(secondList, firstList[i]) >= 0) {
				++count;
				temp.add(firstList[i]);
			}
		}

		inter = new int[count];
		for (int i = 0; i < count; i++) {
			inter[i] = (int) temp.get(i);
		}
		Arrays.sort(inter);

// Step 3 : Difference of Both UNION and Intersection.
		temp = new ArrayList<Integer>(max);
		count = 0;
		for (int i = 0; i < union.length; i++) {
			if (Arrays.binarySearch(inter, union[i]) < 0) {
				++count;
				temp.add(union[i]);
			}
		}
		result = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = (int) temp.get(i);
		}
		Arrays.sort(result);
		System.out.println("resultant array : \n " + Arrays.toString(result));

	}
}
