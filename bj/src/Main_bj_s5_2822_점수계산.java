import java.io.*;
import java.util.*;

public class Main_bj_s5_2822_점수계산 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2822.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0; // 총 점수의 합
		final int count = 8; //문제의 개수
		final int cal = 5; //계산되는 문제의 수
		
		Score[] input = new Score[count]; //입력받는 문제의 번호와 점수
		int[] output = new int[cal]; //출력되는 문제 번호 저장 
		
		for(int i=0;i<count;i++) {
			input[i] = new Score(i+1,Integer.parseInt(br.readLine()));
		}
		Arrays.sort(input);
		
		for(int i=0;i<cal;i++) {
			output[i] = input[i].no;
			sum += input[i].score;
		}
		
		Arrays.sort(output); //출력되는 번호 오름차순 저장
		
		sb.append(sum).append('\n');
		for(int i=0;i<cal;i++) {
			sb.append(output[i]).append(' ');
		}
		
		br.close();
		System.out.print(sb.toString());
	}
}

class Score implements Comparable<Score>{
	int no;
	int score;
	
	Score(int no, int score) {
		this.no = no;
		this.score = score;
	}

	@Override
	public int compareTo(Score o) { //점수를 기준으로 내림차순 정렬
		return Integer.compare(o.score, this.score);
	}
}
