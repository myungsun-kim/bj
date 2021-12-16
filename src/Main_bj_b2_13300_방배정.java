import java.io.*;
import java.util.*;

public class Main_bj_b2_13300_방배정 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_13300.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int row, col, cnt=0;//방의 횟수
		int[][] std = new int[2][7];//학생의 성별과 학년. 1-6학년 성별/0:여 1:남
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			std[row][col]++;
		}
		
		for(int i=0;i<2;i++) {
			for(int j=1;j<7;j++) {
				if(std[i][j]==0) continue;
				cnt+=std[i][j]/K+(std[i][j]%K==0?0:1);
			}
		}
		sb.append(cnt);
		br.close();
		System.out.print(sb);
	}
}
