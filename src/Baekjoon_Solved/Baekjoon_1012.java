package Baekjoon_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1012 {
	
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean arr[][];
	static boolean check[][];
	static int M,N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int Map = Integer.parseInt(br.readLine());
		int res;
		
		for(int i = 0; i<Map; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			arr = new boolean[N][M];
			check = new boolean[N][M];
			
			res = 0;
			
			for(int j = 0; j<cnt; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				//x == col, y ==row
				arr[Y][X] = true;
			}
			
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<M; k++) {
					if(checkLocation(j,k) == true) {
						res++;
						dfs(j,k);
					}
				}
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);

	}
	public static boolean checkLocation(int row, int col) {
		//ÁÂÇ¥°ªÀÌ Àß¸øµÈ °æ¿ì
		if(row < 0 || row >= N || col < 0 || col >= M) return false;
		
		//ÀÌ¹Ì Áö³ª°£ °æ·ÎÀÎ °æ¿ì
		if(check[row][col] == true || arr[row][col] == false) return false;
		return true;
	}
	
	public static void dfs(int X, int Y) {
		check[X][Y] = true;
		
		//'»ó'ÀÇ ÁÂÇ¥
		if(checkLocation(X-1, Y)) dfs(X-1,Y);
		
		//'¿ì'ÀÇ ÁÂÇ¥
		if(checkLocation(X, Y+1)) dfs(X,Y+1);
		
		//'ÇÏ'ÀÇ ÁÂÇ¥
		if(checkLocation(X+1, Y)) dfs(X+1,Y);
		
		//'ÁÂ'ÀÇ ÁÂÇ¥
		if(checkLocation(X, Y-1)) dfs(X, Y-1);
	}

}
