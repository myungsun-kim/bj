import java.io.*;
import java.util.*;

public class Main_bj_b4_14681_사분면고르기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		if(x>0 & y>0) {
			sb.append(1);
		}else if(x<0 & y>0) {
			sb.append(2);
		}else if(x<0 & y<0) {
			sb.append(3);
		}else if(x>0 & y<0) {
			sb.append(4);
		}
		br.close();
		System.out.print(sb);
	}
}