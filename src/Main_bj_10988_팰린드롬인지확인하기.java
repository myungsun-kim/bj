import java.io.*;
// 펠린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어
// 팰린드롬이면 1, 팰린드롬이 아니면 0 출력
public class Main_bj_b1_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_10988.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 1;
		String input = br.readLine();
		int length = input.length();
		for(int i=0;i<length/2;i++) {
			if(input.charAt(i)!=input.charAt(length-i-1)) {
				answer = 0;
				break;
			}
		}
		br.close();
		System.out.print(answer);
	}
}
