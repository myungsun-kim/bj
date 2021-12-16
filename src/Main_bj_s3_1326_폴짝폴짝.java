import java.io.*;
import java.util.*;
// 징검다리에서 점프 할 때 그 징검다리에 쓰여 있는 수의 배수만큼 떨어져 있는 곳으로 갈 수 있음
// a번째 징검다리에서 b번째 징검다리까지 가려고 할 때 최소 몇 번 점프를 하며 b번째 징검다리까지 갈 수 있는지 알아보는 프로그램 작성
// 갈 수 없을 경우 -1
public class Main_bj_s3_1326_폴짝폴짝 {
	static int n, answer;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1326.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		answer = -1;

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken()); //출발점
		int b = Integer.parseInt(st.nextToken()); //도착점
		
		bfs(a,b);
		System.out.print(answer);
	}
	
	static void bfs(int start, int end) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==end) {
				if(answer==-1 || answer>cur[1]) answer=cur[1];
				return;
			}
			if(answer!=-1 && cur[1]>answer) return;
			
			int next = 1;
			while(true) {
				int idx1 = (cur[0]-arr[cur[0]]*next);
				int idx2 = (cur[0]+arr[cur[0]]*next);

				if(check(idx1)) { //이전으로 이동하는 경우
					q.offer(new int[] {idx1, cur[1]+1});
				} 
				if(check(idx2)) { //이후로 이동하는 경우
					q.offer(new int[] {idx2, cur[1]+1});
				}
				++next;
				if(!check(idx1) && !check(idx2)) {
					break;
				}
			}
		}
	}
	
	static boolean check(int idx) {
		if(idx<=0 || idx>n) return false;
		return true;
	}
}
