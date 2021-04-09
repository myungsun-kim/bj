import java.io.*;
import java.util.*;

public class Main_bj_15829_Hashing {
	static int r=31;
	static int M=1234567891;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15829.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer=0;
		String in=br.readLine();
		for(int i=0;i<n;i++) {
			long tmp= (in.charAt(i)-'a'+1);
			for(int j=0;j<i;j++) {
				tmp*=r;
				tmp%=M;
			}
			answer+=tmp;
			answer%=M;
		}
		br.close();
		System.out.println(answer);
	}
}
