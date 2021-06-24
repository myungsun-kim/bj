import java.io.*;
import java.util.*;

public class Main_bj_s2_18870_좌표압축 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_18870.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] X = new int[N][2];//좌표 정보
		int[] X_c = new int[N];//압축한 좌표 정보
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int n=0;n<N;n++) {
			X[n][0] = Integer.parseInt(st.nextToken());//좌표값
			X[n][1] = n;//위치
		}
		
		Arrays.sort(X, Comparator.comparingInt(o1->o1[0]));
		
		int cnt=0;
		for(int n=0;n<N;n++) {
			if(n>0 && X[n-1][0]<X[n][0]) cnt++;
			X_c[X[n][1]]=cnt;
		}
		
		for(int n=0;n<N;n++) {
			sb.append(X_c[n]).append(' ');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
