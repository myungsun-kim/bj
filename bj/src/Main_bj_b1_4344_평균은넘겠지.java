import java.io.*;
import java.util.*;

public class Main_bj_b1_4344_평균은넘겠지 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4344.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] score;
		int sum, avg;
		double cnt;
		//총점, 평균, 평균을 넘는 학생 수
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			score = new int[N];
			sum = 0;
			cnt = 0;
			for(int i=0;i<N;i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			avg = sum/N;
			for(int i=0;i<N;i++) {
				if(score[i]>avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f",cnt/N*100);
			System.out.println("%");
		}
		br.close();
	}
}
