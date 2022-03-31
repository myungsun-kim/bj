import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
// 순간이동 하는 경우에는 1초 후에 2*X의 위치로 이동
// 이전에 방문했다면 방문하지 않는다(N과 K의 범위는 0이상 100000이하)

public class Main_bj_1697_숨바꼭질 {
	static final int arr=100000;//최대값 범위
	static int answer, k;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1697.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[arr+1];
		
		answer = Integer.MAX_VALUE;
		
		bfs(n, 0);
		br.close();
		System.out.print(answer);
	}
	
	static void bfs(int cur, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {cur,cnt});
		visited[cur]=true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[1]>answer) break;
			if(tmp[0]==k) {
				if(tmp[1]<answer) answer=tmp[1];
				break;
			}
			
			if(tmp[0]+1<=arr && !visited[tmp[0]+1]) {
				q.offer(new int[] {tmp[0]+1,tmp[1]+1});
				visited[tmp[0]+1]=true;
			}
			if(tmp[0]-1>=0 && !visited[tmp[0]-1]) {				
				q.offer(new int[] {tmp[0]-1,tmp[1]+1});
				visited[tmp[0]-1]=true;
			}
			if(tmp[0]*2<=arr && !visited[tmp[0]*2]) {				
				q.offer(new int[] {tmp[0]*2,tmp[1]+1});
				visited[tmp[0]*2]=true;
			}
		}
	}
}
