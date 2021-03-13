import java.io.*;
import java.util.*;

public class Main_bj_9498_시험성적 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int j = Integer.parseInt(br.readLine());
		if(j>=90) {
			sb.append("A");
		}else if(j>=80) {
			sb.append("B");
		}else if(j>=70) {
			sb.append("C");
		}else if(j>=60) {
			sb.append("D");
		}else {
			sb.append("F");
		}
		br.close();
		System.out.print(sb);
	}
}