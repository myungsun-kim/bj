import java.io.*;
import java.util.*;
// 사람 성이 들어간 알고리즘을 두 가지 형태로 부름
// 1. 첫 번째는 성을 모두 쓰고, 이를 하이픈(-)으로 이어 붙임. 긴 형태라고 부름 ex) Knuth-Morris-Pratt
// 2. 두 번째로 짧은 형태는 만든 사람의 성의 첫 글자만 따서 부르는 것 ex)KMP
// 긴 형태의 알고리즘 이름이 주어졌을 때 이를 짧은 형태로 바꾸어 출력하는 프로그램 작성
public class Main_bj_2902_KMP는왜KMP일까 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2902.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));
		}
		
		br.close();
		System.out.print(sb.toString());
	}
}
