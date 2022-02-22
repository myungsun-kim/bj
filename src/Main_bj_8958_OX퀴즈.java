import java.io.*;
import java.util.*;

public class Main_bj_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_8958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String tmp;
		int cnt;
		int sum;
		for(int t=0;t<T;t++) {
			tmp = br.readLine();
			cnt = 0;
			sum = 0;
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i)=='O') {
					cnt++;
					sum+=cnt;
				}else {
					cnt=0;
				}
			}
			sb.append(sum).append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
