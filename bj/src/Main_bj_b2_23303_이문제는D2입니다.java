import java.io.*;

public class Main_bj_b2_23303_이문제는D2입니다 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_23303.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String answer = "unrated";
		if(input.contains("D2") || input.contains("d2")) answer="D2";
		
		System.out.print(answer);
	}
}
