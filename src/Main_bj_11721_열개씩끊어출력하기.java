import java.io.*;
import java.util.*;
// 알파벳 소문자와 대문자로만 이루어진 길이가 n인 단어가 주어짐
// 한 줄에 10글자씩 끊어서 출력하는 프로그램 작성
public class Main_bj_11721_열개씩끊어출력하기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11721.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int n = input.length();
		for(int i=0;i<n;i+=10) {
			if(i+10<n) sb.append(input.substring(i, i+10));
			else sb.append(input.subSequence(i, n));
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
