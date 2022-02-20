import java.io.*;
import java.util.*;
// 2007년 1월 1일은 월요일. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램 작성
public class Main_bj_1924_2007 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1924.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken()); // 월
		int y = Integer.parseInt(st.nextToken()); // 일
		int days = y;
		for(int i=1;i<x;i++) days+=month[i];
		
		String answer = "";
		
		switch(days%7) {
		case 0:
			answer = "SUN";
			break;
		case 1:
			answer = "MON";
			break;
		case 2:
			answer = "TUE";
			break;
		case 3:
			answer = "WED";
			break;
		case 4:
			answer = "THU";
			break;
		case 5:
			answer = "FRI";
			break;
		case 6:
			answer = "SAT";
			break;
		}
		br.close();
		System.out.print(answer);
	}
}
