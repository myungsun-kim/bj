import java.io.*;
import java.util.*;
// 첫째 줄에는 별 n개, 둘째 줄에는 별 n-1개,.. n번째 줄에는 별 1개를 찍는 문제
public class Main_bj_2440_별찍기3 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2440.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=n;i>0;i--) {
			for(int j=0;j<i;j++) sb.append('*');
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
