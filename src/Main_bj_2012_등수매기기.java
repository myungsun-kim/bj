import java.io.*;
import java.util.*;

public class Main_bj_2012_등수매기기 {
	// N명의 학생이 있고 모든 학생들이 N명 중 몇 등을 할 것인지 예상 등수를 적어 제출
	// 실수로 모든 학생의 프로그램을 날려서 각 사람이 제출한 예상 등수를 바탕으로 임의의 등수를 매김
	// 자신의 등수를 A로 예상하였는데 실제 등수가 B등인 경우 이 사람의 불만도는 A와 B의 차이
	// N명의 사람들의 불만도의 총 합을 최소로 하면서 학생들의 등수를 매김
	// 불만도의 합을 최소로 하는 프로그램 작성
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 0; //불만도의 합
		int[] score = new int[n];
		for(int i=0;i<n;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(score);
		for(int i=1;i<=n;i++) { //1등부터 n등까지 카운트
			answer += Math.abs(score[i-1]-i);
		}
		br.close();
		System.out.print(answer);
	}
}
