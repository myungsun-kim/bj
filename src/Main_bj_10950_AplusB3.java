import java.io.*;
import java.util.*;

public class Main_bj_10950_AplusB3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;
		int A,B;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			str = new StringTokenizer(br.readLine());
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());
			sb.append(A+B).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}