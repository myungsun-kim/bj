import java.io.*;

public class Main_bj_9086_문자열 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9086.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			String input = br.readLine();
			sb.append(input.charAt(0)).append(input.charAt(input.length()-1)).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
