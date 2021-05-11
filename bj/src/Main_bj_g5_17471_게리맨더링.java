import java.io.*;
import java.util.*;

public class Main_bj_g5_17471_게리맨더링 {
	static int N,answer;
	static int[] people;//인구 수
	static int[][] adj;//도시 인접 구역
	static boolean[] selected;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		people = new int[N+1];
		adj = new int[N+1][N+1];
		selected=new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int l=Integer.parseInt(st.nextToken());
			for(int j=0;j<l;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				adj[i][tmp]=adj[tmp][i]=1;
			}
		}
		
		answer=Integer.MAX_VALUE;
		for(int i=1;i<=N/2+1;i++) {
			comb(i,1);
		}
		
		if(answer==Integer.MAX_VALUE) answer=-1;
		
		br.close();
		System.out.print(answer);
	}
	
	static void comb(int r, int idx) {//구역을 나누는 경우. r개를 뽑음
		if(r==0) {
			if(bfs()) count(); //연결되어있을시 인구수 차이 카운트
			return;
		}
		
		for(int i=idx;i<=N;i++) {
			selected[i]=true;
			comb(r-1,idx+1);
			selected[i]=false;				
		}
	}
	
	static boolean bfs() {//선택된 선거구들이 연결되어있는지 확인
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited=new boolean[N+1];//방문처리
		
		for(int i=1;i<=N;i++) {//초기값
			if(selected[i]) {
				q.offer(i);
				visited[i]=true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			//현재 구역과 연결된 구역 확인
			for(int i=1;i<=N;i++) {
				if(!visited[i] && selected[i] && adj[cur][i]==1) {
					visited[i]=true;
					q.offer(i);
				}
			}
		}
		
		//두 번째 구역 확인
		for(int i=1;i<=N;i++) {
			if(!selected[i]) {
				q.offer(i);
				visited[i]=true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			//현재 구역과 연결된 구역 확인
			for(int i=1;i<=N;i++) {
				if(!visited[i] && !selected[i] && adj[cur][i]==1) {
					visited[i]=true;
					q.offer(i);
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) return false;//방문하지 않은 정점이 있을 경우
		}
		
		return true;
	}

	
	static void count() {//인구 수 차이 구함
		int sum1=0, sum2=0;
		for(int i=1;i<=N;i++) {
			if(selected[i]) sum1+=people[i];
			else sum2+=people[i];
		}

		int dif=Math.abs(sum1-sum2);

		if(answer>dif) answer=dif;
	}
}
