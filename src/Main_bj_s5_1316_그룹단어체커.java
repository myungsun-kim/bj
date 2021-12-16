import java.io.*;
import java.util.*;

public class Main_bj_s5_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;//그룹단어의 개수
		String word;
		for(int i=0;i<n;i++) {
			boolean[] chk = new boolean[26];
			word = br.readLine();
			for(int j=0;j<word.length();j++) {
				if(chk[word.charAt(j)-97]) break;
				if(j+1<word.length() && word.charAt(j)!=word.charAt(j+1)) {
					chk[word.charAt(j)-97]=true;
					continue;
				}
				if(j==word.length()-1) cnt++;
			}
		}
		br.close();
		System.out.print(cnt);
	}
}
