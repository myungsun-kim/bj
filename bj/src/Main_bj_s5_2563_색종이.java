import java.io.*;
import java.util.*;

public class Main_bj_s5_2563_색종이 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2563.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //색종이의 수
		int x,y,cnt=0;
		boolean[][] map = new boolean[100][100];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					map[i][j]=true;
				}
			}
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]) cnt++;
			}
		}
		sb.append(cnt);
		System.out.print(sb);
	}
}
