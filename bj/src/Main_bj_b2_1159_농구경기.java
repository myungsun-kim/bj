import java.io.*;
import java.util.*;
// 성의 첫 글자가 같은 선수 5명을 선발
// 성의 첫 글자가 같은 선수가 5명보다 적다면 기권
// 뽑을 수 있는 성의 첫 글자를 모두 구함
public class Main_bj_b2_1159_농구경기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1159.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //선수의 수
		int[] count = new int[26];
		String answer = ""; 

		if(n>=5) {
			for(int i=0;i<n;i++) {
				count[br.readLine().charAt(0)-'a']++;
			}
			for(int i=0;i<count.length;i++) {
				if(count[i]>=5) {
					answer+=(char)(i+'a');
				}
			}
		}
		if(answer=="") answer="PREDAJA";
		
		System.out.print(answer);
	}
}
