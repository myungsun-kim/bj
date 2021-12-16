import java.io.*;
import java.util.*;
// 알파벳 S 모양의 블록 n개와 알파벳 A 모양의 블록 m개를 건졌다
// 건진 블록을 이용해 학교에 전시할 SASA 모형을 최대한 많이 만들려고 한다
// SASA 모형 1개를 만들기 위해서는 S모양 블록 2개와 A모양 블록 2개가 필요
// 만들 수 있는 SASA 모형 개수의 최댓값은
public class Main_bj_b4_23825_SASA모형을만들어보자 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_23825.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		br.close();
		System.out.print(Math.min(n/2, m/2));
	}
}
