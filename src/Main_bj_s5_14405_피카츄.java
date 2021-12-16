import java.io.*;
import java.util.*;
// 피카츄는 "pi","ka","chu"만 발음 가능
// 이 세 음절을 합친 단어만 발음 가능
// 문자열 S가 주어졌을 때 피카츄가 발음할 수 있는 문자열인지 아닌지 구하는 프로그램 작성
public class Main_bj_s5_14405_피카츄 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_14405.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] check = {"pi","ka","chu"};
		
		boolean answer = false;
		
		for(int i=0;i<check.length;i++) {
			s = s.replace(check[i], "1");
		}
		s = s.replace("1", "");
		
		if(s.equals("")) answer = true;
		
		br.close();
		System.out.print(answer?"YES":"NO");
	}
}
