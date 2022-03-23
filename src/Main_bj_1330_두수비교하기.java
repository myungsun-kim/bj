import java.io.*;
import java.util.*;

public class Main_bj_1330_두수비교하기{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(A>B) {
			sb.append('>');
		}else if(A<B) {
			sb.append('<');
		}else {
			sb.append("==");
		}
		br.close();
		System.out.print(sb.toString());
	}
}
