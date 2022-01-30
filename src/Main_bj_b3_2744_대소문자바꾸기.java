import java.io.*;

public class Main_bj_b3_2744_대소문자바꾸기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2744.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		for(int i=0;i<input.length;i++) {
			if(input[i]-'0'>=49) {
				sb.append((char)(input[i]-32));
			}else {
				sb.append((char)(input[i]+32));
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
