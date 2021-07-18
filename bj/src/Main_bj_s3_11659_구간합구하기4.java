import java.io.*;
import java.util.*;
// 수 N개가 주어졌을 때 , i번째 수부터 j번째 수까지 합을 구하는 프로그램 작성
public class Main_bj_s3_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11659.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());//수의 개수
		int M = Integer.parseInt(st.nextToken());//합을 구해야 하는 횟수
		int[] sum = new int[N+1]; //1부터 idx까지의 합
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {//N개의 수 입력
			sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
		}
		while(M-->0) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());//시작점
			int j = Integer.parseInt(st.nextToken());//끝점
			sb.append(sum[j]-sum[i-1]).append('\n');
		}
		br.close();
		System.out.print(sb);
	}
}