import java.io.*;
import java.util.*;

public class Main_bj_2775_부녀회장이될테야 {
	static int cnt;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2775.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int k,n;
		for(int tc=0;tc<t;tc++) {
			k = Integer.parseInt(br.readLine());//k층
			n = Integer.parseInt(br.readLine());//n호
			select(k,n);
			System.out.println(cnt);
		}
	}

	private static int select(int k, int n) {
		if(k==0) {
			return n;
		}
		cnt=0;
		for(int i=1;i<=n;i++) {
			cnt+=select(k-1,i);
		}
		return cnt;
	}
}
