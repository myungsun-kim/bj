import java.io.*;
import java.util.*;

public class Main_bj_s5_2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt1=0, cnt2=0, total=0;
		for(int i=0;i<input.length();i++) {
			if(i+3<=input.length() && input.substring(i,i+3).equals("dz=")) {
				cnt1++;
			}else if(i+2<=input.length() && (input.substring(i, i+2).equals("c=") || input.substring(i, i+2).equals("c-") || input.substring(i, i+2).equals("d-") || input.substring(i, i+2).equals("lj") || input.substring(i, i+2).equals("nj") || input.substring(i, i+2).equals("s=") || (input.substring(i, i+2).equals("z=") && (i==0 || (i-1>0 && input.charAt(i-1)!='d'))))) {//두 글자씩 쪼개기
				cnt2++;
			}
		}
		total = input.length()-cnt2-2*cnt1;
		br.close();
		System.out.print(total);
	}
}
