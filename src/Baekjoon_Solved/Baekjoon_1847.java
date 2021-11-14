package Baekjoon_Solved;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_1847 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = scanner.nextInt();
		
		int start = 0;
		
		//N���ݺ�
		
		while(N --> 0) {
			
			int value = scanner.nextInt();
			
			if(value > start) {
				//start + 1�κ��� �Է¹��� value ���� push�� �Ѵ�.
				for(int i = start +1; i<=value; i++) {
					stack.push(i);
					sb.append('+').append('\n'); //+�������Ѵ�.
					
				}
				start = value; //���� push �� ���� ���������� �����ϱ� ���� ���� �ʱ�ȭ
			}
			
			//top�� �ִ� ���Ұ� �Է¹��� ���� ���� ���� ���
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			scanner.close();
		}
		
		System.out.println(sb);
		

	}
	

}
