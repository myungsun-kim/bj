import java.io.*;
import java.util.*;

public class Main_bj_s4_9012_괄호 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean chk;
		String input;
		Stack<Character> s= new Stack<>();
		for(int n=0;n<N;n++) {
			input=br.readLine();
			chk=true;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(') {
					s.push(input.charAt(i));
				}else if(input.charAt(i)==')') {
					if(s.isEmpty() || s.peek()!='(') {
						chk=false;
						s.clear();
						break;
					}else if(s.pop()==')'){
						continue;
					}
				}
				if(i==input.length()-1) {
					if(!s.isEmpty()) {
						chk=false;
						s.clear();
					}
				}
			}
			if(chk) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
