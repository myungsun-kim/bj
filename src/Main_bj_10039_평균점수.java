import java.io.*;
import java.util.*;
// 점수가 40점 이상이면 그 점수를 반영. 40점 미만은 40점
public class Main_bj_10039_평균점수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10039.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cnt=5; //학생의 수
		int answer=0;
		for(int i=0;i<cnt;i++) {
			int tmp = Integer.parseInt(br.readLine());
			tmp = tmp>40?tmp:40;
			answer+=tmp;
		}
		answer/=5;
		br.close();
		System.out.print(answer);
	}
}
