import java.io.*;
import java.util.*;

public class Main_bj_1065_한수 {
	static int cnt=0;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1065.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {			
			if(check(i)) cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean check(int n) {
		if(n==1000) {
			return false;
		}else if(n>=100) {
			if(n/100-n%100/10 != n%100/10-n%10) return false;
		}
		return true;
	}
}
