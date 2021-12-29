import java.io.*;
import java.util.*;
// TV의 대각선 길이와, 높이 너비의 비율이 주어졌을 때, 
// 실제 높이와 너비의 길이를 출력하는 프로그램을 작성
public class Main_bj_b4_1297_TV크기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1297.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int d = Integer.parseInt(st.nextToken()); //대각선 길이
		int h = Integer.parseInt(st.nextToken()); //높이 비율
		int w = Integer.parseInt(st.nextToken()); //너비 비율
		double tmp = Math.sqrt(h*h+w*w);
		br.close();
		System.out.printf((int)(d*h/tmp)+" "+(int)(d*w/tmp));
	}
}
