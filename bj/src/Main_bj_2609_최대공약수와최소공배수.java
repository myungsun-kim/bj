import java.io.*;
import java.util.*;

public class Main_bj_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N1=Integer.parseInt(st.nextToken());
		int N2=Integer.parseInt(st.nextToken());
		for(int i=Math.min(N1, N2);i>0;i--) {
			if(N1%i==0 && N2%i==0) {
				sb.append(i).append("\n");//최소 공약수
				break;
			}
		}
		int num=Math.max(N1, N2);
		while(true) {//최대 공배수
			if(num%N1==0 && num%N2==0) {
				sb.append(num);
				break;
			}
			num++;
		}
		br.close();
		System.out.print(sb);
	}
}
