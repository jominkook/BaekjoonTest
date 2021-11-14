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
		
		//N번반복
		
		while(N --> 0) {
			
			int value = scanner.nextInt();
			
			if(value > start) {
				//start + 1로부터 입력받은 value 까지 push를 한다.
				for(int i = start +1; i<=value; i++) {
					stack.push(i);
					sb.append('+').append('\n'); //+를저장한다.
					
				}
				start = value; //다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
			}
			
			//top에 있는 원소가 입력받은 값과 같이 않은 경우
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
