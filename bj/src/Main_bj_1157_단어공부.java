import java.io.*;
import java.util.*;

public class Main_bj_1157_단어공부 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1157.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] chk = new int[26];
//		System.out.println('A'-65);
		String input = br.readLine();
		input = input.toUpperCase();
		int cnt=0; //가장 많이 출력되는 경우
		boolean duple=false;//가장 많이 출력되는 단어가 여러개인 경우
		char max=' ';//가장 많이 출력된 단어
		
		for(int i=0;i<input.length();i++) {
			chk[input.charAt(i)-65]++;
			if(cnt<chk[input.charAt(i)-65]) {
				cnt=chk[input.charAt(i)-65];
				duple=false;
				max=input.charAt(i);
			}else if(cnt==chk[input.charAt(i)-65]) {
				duple=true;
			}
		}
		
		if(duple) {
			System.out.print("?");
		}else {
			System.out.print(max);
		}
	}
}
