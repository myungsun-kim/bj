import java.io.*;
import java.util.*;
// 웜 바이러스는 네크워크상 연결되어 있는 컴퓨터를 감염시킴
public class Main_bj_s3_2606_바이러스 {
	static int N, cnt;
	static boolean[][] network;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2606.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		network=new boolean[N+1][N+1];
		visited=new boolean[N+1];
		int M=Integer.parseInt(br.readLine());//연결되어 있는 컴퓨터 쌍의 개수
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			network[from][to]=network[to][from]=true;
		}
		cnt=0;//감염된 컴퓨터의 수
		bfs(1);
		br.close();
		System.out.print(cnt);
	}
	
	static void bfs(int cur) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(cur);
		visited[cur]=true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && network[tmp][i]) {
					visited[i]=true;
					q.offer(i);
					cnt++;
				}
			}
		}
	}
}
