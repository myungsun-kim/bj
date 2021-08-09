import java.io.*;
import java.util.*;
// Java는 낙타표기법, C++은 소문자에 _를 구분자로 사용. 
// Java형식의 변수명은 C++ 형식으로, C++형식의 변수명은 Java형식으로 변환해줌
public class Main_bj_s5_3613_JavavsC {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_3613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean chk = false; //해당 변수가 자바 형식이나 C++형식이 아닌 경우 체크
		boolean j = false; //자바 형식의 변수인지 아닌지
		boolean c = false; //C++형식의 변수인지 아닌지
		for(int i=0;i<input.length;i++) {
			if(input[i]-'A'<26) j=true; //대문자가 있을 경우 자바 형식 변수
			if(input[i]-'A'==30) c=true; //_가 있을 경우 C++ 형식의 변수
		}
		if(j&&c || input[0]-'A'<=30) chk=true;
		else if(!j&&!c) {//소문자로만 이루어져 있는 경우
			for(int i=0;i<input.length;i++) sb.append(input[i]);
		}else {
			if(j && !c) {//자바 형식의 변수인 경우
				for(int i=0;i<input.length;i++) {
					if(input[i]-'A'<26) {//대문자인 경우
						sb.append('_').append(Character.toLowerCase(input[i]));
					}else {
						sb.append(input[i]);
					}
				}
			}else {//C++형식의 변수인 경우
				for(int i=0;i<input.length;i++) {
					if(input[i]=='_') {
						if(i==input.length-1) {//마지막 문자가 _인 경우
							chk=true;
							break;
						}else if(input[i+1]=='_') {//_가 두 번 이상 나오는 경우
							chk=true;
							break;
						}else {
							sb.append(Character.toUpperCase(input[++i]));
						}
					}else {
						sb.append(input[i]);
					}
				}
			}
		}
		br.close();
		if(chk) {
			System.out.print("Error!");
		}else {
			System.out.print(sb.toString());
		}
	}

}
