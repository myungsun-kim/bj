import java.io.*;
import java.util.*;

public class Main_bj_b5_8393_합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		br.close();
		sb.append(sum);
		System.out.print(sb);
	}
}