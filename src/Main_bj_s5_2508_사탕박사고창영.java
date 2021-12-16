import java.io.*;
import java.util.*;
// .:빈곳 / o:사탕의 먹을 수 있는 부분 / <>v^:사탕껍질
// 사탕은 >o<
// v
// o
// ^
// 두 가지 모습만 있다
// >o.는 사탕으로 치지 않는다. 사탕의 개수를 출력하는 프로그램 작성
// . o < > v ^는 각각 아스키코드 46 111 60 62 118 94 
public class Main_bj_s5_2508_사탕박사고창영 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] dw = {118,94,62,60};//포장지 상태
	static int r, c;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
            br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[r][c];
			Queue<int[]> q= new LinkedList<>();//사탕의 위치 저장
			int answer=0; //박스에 들어있는 사탕 개수
			
			for(int i=0;i<r;i++) {
				String input = br.readLine();
				for(int j=0;j<c;j++) {
					arr[i][j] = input.charAt(j);
					if(arr[i][j]==111) q.offer(new int[] {i,j});//사탕의 위치
				}
			}
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				if(isCandy(tmp)) answer++;;
			}
			System.out.println(answer);
		}
	}

	static boolean isCandy(int[] tmp) {//사탕인지 아닌지 체크
		for(int l=0;l<2;l++) {
			int chk=0; //사탕인지 아닌지 유무 체크. 2면 사탕
			for(int d=2*l;d<2*l+2;d++) {
				int nr=tmp[0]+dr[d];
				int nc=tmp[1]+dc[d];
				if(check(nr,nc) && arr[nr][nc]==dw[d]) chk++;
			}
			if(chk==2) return true;

		}
		return false;
	}
	
	static boolean check(int row, int col) {//배열 범위를 벗어나지 않도록 체크
		if(row<0 || col<0 || row>=r || col>=c) return false;
		return true;
	}
}
