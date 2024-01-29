import java.io.*;
import java.util.*;
// ( ) [ ] 괄호가 짝에 맞게 들어있는지 아닌지
public class Main_bj_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String tmp;//입력받은 문자열. 한 줄 단위
		int length;//문자열의 길이
		boolean chk;//문자열이 균형을 이루고 있는지 없는지
		
		while(true) {
			tmp = br.readLine();
			if(tmp.equals(".")) break;//기저조건 "."을 입력하면 종료
			chk=true;
			
			length=tmp.length();
			for(int i=0;i<length;i++) {//문자열을 문자 하나하나씩 체크
				if(tmp.charAt(i)=='.') {//마지막엔 스택에 값이 있으면 안 됨
					if(!s.isEmpty()) chk=false;
					s.clear();
					break;
				}else if(tmp.charAt(i)=='[' || tmp.charAt(i)=='(') { //여는 괄호를 만나면 스택에 넣어줌
					s.push(tmp.charAt(i));
				}else if(tmp.charAt(i)==']') {// ]를 만나면 이전 괄호가 [였는지 확인
					if(s.isEmpty() || s.pop()!='[') {//스택이 비어있거나 이전 괄호가 [ 가 아니라면 균형을 이루고 있는 것이 아님
						chk=false;
						s.clear();
						break;
					}else continue;
				}else if(tmp.charAt(i)==')') {// )를 만나면 이전 괄호가 (였는지 확인
					if(s.isEmpty() || s.pop()!='(') {//스택이 비어있거나 이전 괄호가 (가 아니라면 균형을 이루고 있는 것이 아님
						chk=false;
						s.clear();
						break;
					}else continue;			
				}
			}
			if(chk) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}