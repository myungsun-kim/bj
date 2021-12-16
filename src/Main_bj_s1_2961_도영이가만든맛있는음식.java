import java.io.*;
import java.util.*;

public class Main_bj_s1_2961_도영이가만든맛있는음식 {
	static StringBuilder sb = new StringBuilder();
	static int[][] taste;
	static boolean[] visited;
	static int s,b,diff; //신맛의 곱, 쓴맛의 합, 신맛과 쓴맛의 차
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		taste = new int[N][2];
		visited = new boolean[N];
		diff = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());//신맛
			taste[i][1] = Integer.parseInt(st.nextToken());//쓴맛
		}
		powerset(taste.length,0);
		br.close();
		sb.append(diff);
		System.out.print(sb);
	}
	
	static void powerset(int n, int idx) {
		if(idx == n) {
			check();
			return; //뽑는 수와 n이 동일해지면 종료
		}
		
		visited[idx] = false;//현재 인덱스를 포함하지 않는 경우
		powerset(n,idx+1);
		
		visited[idx] = true;//현재 인덱스를 포함하는 경우
		powerset(n,idx+1);
	}

	static void check() {
		s = 1;
		b = 0;
		for(int i=0;i<taste.length;i++) {
			if(visited[i]) {
				s *= taste[i][0];//신맛
				b += taste[i][1];//쓴맛
				diff = Integer.min(diff, Math.abs(s-b));
			}
		}
	}
}
