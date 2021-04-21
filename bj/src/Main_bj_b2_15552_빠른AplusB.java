import java.io.*;
import java.util.*;

public class Main_bj_b2_15552_빠른AplusB {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int A,B;
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
