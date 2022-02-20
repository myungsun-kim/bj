import java.io.*;
import java.util.*;
// N*M 크기의 행렬 A와 M*K 크기의 행렬 B가 주어졌을 때 두 행렬을 곱하는 프로그램 작성
// 나오는 행렬은 N*K
public class Main_bj_2740_행렬곱셈 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2740.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		int[][] b = new int[m][k];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<k;j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				int answer=0;
				for(int l=0;l<m;l++) {
					answer+=a[i][l]*b[l][j];
				}
				sb.append(answer).append(' ');
			}
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}

}
