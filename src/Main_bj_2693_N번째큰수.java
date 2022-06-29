import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 A가 주어졌을 때 N번째 큰 값을 출력하는 프로그램 작성
// 배열 A의 크기는 항상 10, 자연수만 가지고 있다. N은 항상 3
public class Main_bj_2693_N번째큰수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2693.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] a = new int[10];
		final int n = 3;
		
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<a.length;i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			sb.append(a[a.length-n]).append('\n');
		}
		
		System.out.print(sb.toString());
	}
}
