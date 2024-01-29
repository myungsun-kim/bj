import java.io.*;
import java.util.*;
// 주어진 칸으로 이동하기 위해 나이트는 최소 몇 번 움직여야 하는지
public class Main_bj_7562_나이트의이동 {
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};//나이트 이동 가능한 방향
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static int n;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7562.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());//테스트케이스 수
		for(int tc=0;tc<t;tc++) {
			n = Integer.parseInt(br.readLine()); //체스판 한 변의 길이
			int[][] arr = new int[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start_r = Integer.parseInt(st.nextToken());
			int start_c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int destination_r = Integer.parseInt(st.nextToken());
			int destination_c = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(arr, start_r, start_c, destination_r, destination_c)).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}

	static int bfs(int[][] arr, int start_r, int start_c, int destination_r, int destination_c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int answer = Integer.MAX_VALUE;
		
		q.offer(new int[]{start_r, start_c, 0});
		visited[start_r][start_c]=true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == destination_r && tmp[1] == destination_c) {
				if(answer>tmp[2]) answer=tmp[2];
				break;
			}
			
			for(int d=0;d<8;d++) {
				int nr = tmp[0]+dr[d];
				int nc = tmp[1]+dc[d];
				int nCnt = tmp[2]+1;
				
				if(check(nr,nc) && !visited[nr][nc]) {
					q.offer(new int[] {nr,nc,nCnt});
					visited[nr][nc]=true;
				}
			}
		}
		return answer;
	}
	
	static boolean check(int r, int c) {//배열범위 벗어남 여부 체크
		if(r<0 || c<0 || r>=n || c>=n) return false;
		return true;
	}
}
