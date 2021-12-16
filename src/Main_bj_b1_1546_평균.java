import java.io.*;
import java.util.*;

public class Main_bj_b1_1546_평균 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1546.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		int max = 0;
		double sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = (int) Math.max(max, score[i]);
		}
		for(int i=0;i<N;i++) {
			sum+= score[i]/max*100;
		}
		br.close();
		sb.append(sum/N);
		System.out.print(sb);
	}
}
