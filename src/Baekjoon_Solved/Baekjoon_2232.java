package Baekjoon_Solved;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2232 {
	
	
public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n, i, e, cnt = 1;
        n = sc.nextInt();
        Mine[] m = new Mine[n];
        int[] P = new int[n];
        for(i = 0; i < n; i++){
        	P[i] = sc.nextInt();
        	m[i] = new Mine(i, i, i);
        }
        for(i = 1; i < n; i++) if(P[i-1] < P[i]) m[i].L = m[i-1].L;
        m[n-1].R = n-1;
        for(i = n-2; i >= 0; i--) if(P[i] > P[i+1]) m[i].R = m[i+1].R;
        Arrays.sort(m);
        int[] ans = new int[n]; // 이 부분부터는 필자의 방식대로 풀이를 변형한 거라 위와는 좀 상이할 수 있다.
        e = m[0].R;
        for(i = 1; i < n; i++){
        	if(m[i].R <= e) continue;
        	while(1 == 1){
        		if(cnt == 1 || m[ans[cnt-2]].R < m[i].L){
        			e = m[i].R;
        			ans[cnt++] = i;
        			break;
        		}else cnt--;
        	}
        }
        for(i = 0; i < cnt; i++) ans[i] = m[ans[i]].ID+1;
        Arrays.sort(ans, 0, cnt);
        for(i = 0; i < cnt; i++) System.out.print(ans[i]+"\n");
     
        
}
    
static class Mine implements Comparable<Mine>{
    	
    	int L, R, ID;
    	
    	Mine(int l, int r, int idx){
    		L = l; R = r; ID = idx;
    	}
    	
    	public int compareTo(Mine m){
    		if(L == m.L){
    			if(R == m.R) return 0;
    			else return (R < m.R) ? 1 : -1;
    		}else return (L < m.L) ? -1 : 1;
    	}
	}
}
