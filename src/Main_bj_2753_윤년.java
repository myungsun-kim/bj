import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2753_윤년 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		if(n%4==0 && (n%100!=0 || n%400==0)) {
			sb.append(1);
		}else {
			sb.append(0);
		}
		br.close();
		System.out.print(sb);
	}
}