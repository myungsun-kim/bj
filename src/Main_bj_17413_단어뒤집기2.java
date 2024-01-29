import java.io.*;
import java.util.*;
// 문자열 S는 알파벳 소문자, 숫자, 공백, 특수문자(<,>)로만 이루어져 있다
// 문자열의 시작과 끝은 공백이 아니다
// <와 >가 문자열에 있는 경우 번갈아가며 등장하며, <이 먼저 등장한다. 또 두 문자의 개수는 같다
// 태그는 <로 시작해서 >로 끝나는 길이가 3이상인 부분 문자열이며 <와 > 사이에는 알파벳 소문자와 공백만 있다
// 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
// 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다
// 이 문자열 S에서 단어만 뒤집는다
// 태그는 큐, 단어는 스택으로 구현한다
public class Main_bj_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17413.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<input.length;i++) {
			if(input[i]==' ') {
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				sb.append(' ');
			}else if(input[i]=='<') {
				while(!s.isEmpty()) {
					sb.append(s.pop());
				}
				while(input[i]!='>') {
					sb.append(input[i++]);
				}
				sb.append('>');
			}else {
				s.add(input[i]);
			}
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		br.close();
		System.out.print(sb.toString());
	}
}
