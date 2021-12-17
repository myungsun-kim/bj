import java.io.*;
import java.util.*;
// 파일 이름의 개수 n. 파일 이름의 길이는 모두 같음
// 가능한 ?를 적게 사용하며 주어진 파일 이름을 모두 검색할 수 있는 패턴을 구하여라
public class Main_bj_b1_1032_명령프롬프트 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1032.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] answer = br.readLine().toCharArray();
		
		for(int i=1;i<n;i++) {
			char[] tmp = br.readLine().toCharArray();
			
			boolean check = true; //패턴이 ?로만 되어 있는 경우를 확인할 변수
			
			for(int j=0;j<answer.length;j++) { //현재 패턴과 비교
				if(answer[j]!='?' && answer[j]!=tmp[j]) answer[j]='?';
				if(check && answer[j]!='?') check=false;
			}
			if(check) break; //전부 ?로 이루어져 있다면
		}
		
		br.close();
		System.out.print(answer);
	}
}
