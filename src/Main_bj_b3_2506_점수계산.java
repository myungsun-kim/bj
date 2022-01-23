import java.io.*;
import java.util.*;
// 처음 문제는 1점, 연속으로 답이 맞는 경우는 두번째 문제는 2점, k번째 문제는 k점으로 계산
// 총 점수를 계산
public class Main_bj_b3_2506_점수계산 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2506.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		int score = 1;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp==0) {
				score=1;
			}else {
				total+=score++;
			}
		}
		br.close();
		System.out.print(total);
	}
}
