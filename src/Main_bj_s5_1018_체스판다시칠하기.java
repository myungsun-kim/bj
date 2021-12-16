import java.io.*;
import java.util.*;

public class Main_bj_s5_1018_체스판다시칠하기 {
	static char[][] map;
	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		String in;
		
		for(int i=0;i<n;i++) {
			in = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = in.charAt(j);
			}
		}
		
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {//8X8체스판 시작점 설정
				check(i,j);
			}
		}
		br.close();
		System.out.print(cnt);
	}
	
	static void check(int x, int y) {
		int tmp_cnt=0;
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) { //첫 시작점이 'W'라고 가정
				if((i+j)%2==0 && map[i][j]=='B') {
					tmp_cnt++;
				}else if((i+j)%2==1 && map[i][j]=='W') {
					tmp_cnt++;
				}
			}
			if(tmp_cnt>cnt) break;
		}
		cnt=Math.min(cnt, tmp_cnt);
		
		tmp_cnt=0;
		for(int i=x;i<x+8;i++) { //첫 시작점이 'B'라고 가정
			for(int j=y;j<y+8;j++) {
				if((i+j)%2==0 && map[i][j]=='W') {
					tmp_cnt++;
				}else if((i+j)%2==1 && map[i][j]=='B') {
					tmp_cnt++;
				}
			}
			if(tmp_cnt>cnt) break;
		}
		cnt=Math.min(cnt, tmp_cnt);
	}
}
