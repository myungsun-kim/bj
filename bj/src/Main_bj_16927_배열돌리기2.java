import java.io.*;
import java.util.*;
public class Main_bj_16927_배열돌리기2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //배열의 행의 크기
		int M = Integer.parseInt(st.nextToken()); //배열의 열의 크기
		int R = Integer.parseInt(st.nextToken()); //수행해야하는 회전의 수. 회전은 반시계 방향으로 돔		
	}
}
