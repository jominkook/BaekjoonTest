package Baekjoon_Solved;


import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2012 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = 1; 
		long sum = 0;
		int [] arr = new int[N];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			
		}
		Arrays.sort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			sum += Math.abs(arr[i] - (i+B));
		}
		System.out.println(sum);
		sc.close();

	}

}
