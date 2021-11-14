package Baekjoon_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1699 {
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[100001];
		
		//double sqrt = Math.sqrt((double) n);
		
		//������ �����ϴ� ���� ���� ���� -> ���ص� �ȴ�.
		//���, 1�� �� �� �����ϴ��� �ʱ� ������ ���ش�. (�ִ밪���� �ʱ� ����)
		for(int i  = 1; i<=N; i++) {
			dp[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			
			//�ּҰ� �Ǵ� ������ = N�� ���� �� �� �� ������ + N - �������� �ּ��� ����
			for(int j = 1; j * j <= i; j++) {
				if(dp[i] > dp[ i - j * j] + 1) {
					
					dp[i] = dp[i - j * j ] + 1;
				}
			}
		}
		System.out.println(dp[N]);
		
	
	}

}
