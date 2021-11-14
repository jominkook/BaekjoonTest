package Baekjoon_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon_2606 {
	
	static int Com;
	static int Num;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int res;
	
	static void dfs(int start) {
		visited[start] = true;
		
		int y;
		for(int i = 0; i<graph.get(start).size(); i++) {
			y = graph.get(start).get(i);
			
			if(!visited[y]) {
				visited[y] = true;
				res++;
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Com = Integer.parseInt(br.readLine());
			Num = Integer.parseInt(br.readLine());
			
			graph = new ArrayList<>();
			visited = new boolean[Com+1];
			
			for(int i = 0; i<=Com; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			String str;
			int com1, com2;
			for(int i = 0; i<Num; i++) {
				str = br.readLine();
				com1 = Integer.parseInt(str.split(" ")[0]);
				com2 = Integer.parseInt(str.split(" ")[1]);
				
				graph.get(com1).add(com2);
				graph.get(com2).add(com1);
			}
		
			res = 0;
		    dfs(1);
		    System.out.println(res);
		

	}

}
