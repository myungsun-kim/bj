import java.io.*;
import java.util.*;
// 길이가 n으로 같은 문자열 x와 y가 있을 때 두 문자열 x와 y의 차이는 x[i]!y[i]인  i의 개수
// 두 문자열 A와 B가 주어진다. 이때 A의 길이는 B의 길이보다 작거나 같다
// A의 길이가 B의 길이와 같아질 때까지 다음과 같은 연산을 할 수 있다
// 1. A의 앞에 아무 알파벳이나 추가
// 2. A의 뒤에 아무 알파벳이나 추가
// 이 때 A와 B의 길이가 같으면서 A와 B의 차이를 최소로 하는 프로그램 작성. 차이를 출력
// A와 B의 길이는 최대 50 알파벳 소문자로만 이루어져 있음
public class Main_bj_1120_문자열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1120.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		int a_length = a.length;
		int b_length = b.length;
		int answer = 50;
		
		for(int i=0;i<b_length-a_length+1;i++) {
			int not_equal = 0; //같은 문자의 수
			for(int j=0;j<a_length;j++) {
				if(a[j] != b[i+j]) not_equal++;
			}
			if(not_equal<answer) answer=not_equal;
		}
		
		System.out.print(answer);
	}
}
