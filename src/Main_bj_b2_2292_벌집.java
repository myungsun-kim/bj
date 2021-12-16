import java.io.*;
import java.util.*;
// 1 7 19 37 
//  6 12 18.. > 1+6*(n-1)
public class Main_bj_b2_2292_벌집 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2292.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(true) {
			if(n<=1+3*cnt*(cnt-1)) break;
			cnt++;
		}
		br.close();
		System.out.print(cnt);
	}
}
