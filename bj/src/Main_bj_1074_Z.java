import java.io.*;
import java.util.*;

public class Main_bj_1074_Z {
	static int N,n,r,c,cnt;
	static int[] dx = {0, 0, 1, 1};//지그재그
	static int[] dy = {0, 1, 0, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		n = (int)Math.pow(2,N);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dfs(n, 0, 0);
		br.close();
		System.out.print(sb);
	}
	static void dfs(int size, int row, int col) {//배열의 크기, 행 시작 인덱스, 열 시작 인덱스
		if(size==2) {//가장 작은 Z
			for(int i=0;i<4;i++) {
				int row2 = row+dx[i];
				int col2 = col+dy[i];
				System.out.println(i+" "+row2+" "+col2+" "+cnt);
				if(row2 == r && col2 == c) {//입력한 값과 일치할때
					System.out.println("조건"+i+" "+row2+" "+col2+" "+cnt);
					sb.append(cnt);
				}
				cnt++;
			}
			return;
		}
//		System.out.println(size+" "+row+" "+col);
		dfs(size/2,row,col); //1사분면
		dfs(size/2,row,col+size/2); //2사분면
		dfs(size/2,row+size/2,col); //3사분면
		dfs(size/2,row+size/2,col+size/2); //4사분면
	}
}
