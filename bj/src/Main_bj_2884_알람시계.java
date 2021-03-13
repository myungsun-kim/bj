import java.io.*;
import java.util.*;

public class Main_bj_2884_알람시계 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A;
		if(H==0) {
			if(M<45) H=24;
		}
		A = 60*H+M-45;
		sb.append(A/60).append(" ").append(A-(A/60)*60);
		br.close();
		System.out.print(sb);
	}
}