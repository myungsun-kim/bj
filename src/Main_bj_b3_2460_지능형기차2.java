import java.io.*;
import java.util.*;
// 탈 때 내릴 사람이 모두 내린 후 기차에 탐
public class Main_bj_b3_2460_지능형기차2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 10; //역의 수
		int answer = 0;
		int cur = 0;
		for(int t=0;t<count;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int off = Integer.parseInt(st.nextToken()); //내린 사람 수
			int on = Integer.parseInt(st.nextToken()); //탄 사람 수
			cur = cur-off+on;
			if(cur>answer) answer=cur;
		}
		br.close();
		System.out.print(answer);
	}
}
