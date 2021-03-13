import java.io.*;
import java.util.*;

public class Main_bj_11720_숫자의합 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11720.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		String tmp = br.readLine();
		for(int i=0;i<n;i++) {
			sum += tmp.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}
