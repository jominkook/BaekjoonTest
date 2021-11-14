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
		
		//제곱근 존재하는 수만 먼저 설정 -> 안해도 된다.
		//대신, 1이 몇 개 존재하는지 초기 설정을 해준다. (최대값으로 초기 설정)
		for(int i  = 1; i<=N; i++) {
			dp[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			
			//최소가 되는 제곱수 = N의 이전 수 들 중 제곱수 + N - 제곱수의 최소항 개수
			for(int j = 1; j * j <= i; j++) {
				if(dp[i] > dp[ i - j * j] + 1) {
					
					dp[i] = dp[i - j * j ] + 1;
				}
			}
		}
		System.out.println(dp[N]);
		
	
	}

}
