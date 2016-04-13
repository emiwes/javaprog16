import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class numSum {
	public static void main(String[] args) {
		Scanner data = null;
		ArrayList<Integer> numArray;
		Integer n, index, limit, sum, highNumber;

		data = new Scanner(System.in);

		n = data.nextInt();
		numArray = new ArrayList<Integer>();

		index = 0;
		while (data.hasNextInt()) {
			numArray.add(index, data.nextInt());
			index++;
		}

		Collections.sort(numArray, Collections.reverseOrder());

		if ( (n % 2) == 0) {
			limit = n/2;
			sum = 0;

			for (Integer i=0; i<limit; i++) {
				highNumber = numArray.get(i);
				sum = sum + highNumber;
			}
			System.out.println(sum);

		}
		else {
			limit = (n+1)/2;
			sum = 0;

			for (Integer i=0; i<limit; i++) {
				highNumber = numArray.get(i);
				sum = sum + highNumber;
			}
			System.out.println(sum);
		}
	}
}