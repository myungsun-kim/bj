import java.io.*;
import java.util.*;

public class X_Main_bj_2304_창고다각형 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2304.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());//기둥의 개수
		int[][] pillar = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			pillar[i][0] = Integer.parseInt(st.nextToken());//위치
			pillar[i][1] = Integer.parseInt(st.nextToken());//높이
		}
	}
}
