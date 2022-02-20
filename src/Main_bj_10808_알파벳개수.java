import java.io.*;

public class Main_bj_10808_알파벳개수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		final int size = 26;
		int[] count = new int[size];
		for(int i=0;i<input.length();i++) count[input.charAt(i)-'0'-49]++;
		for(int i=0;i<count.length;i++) sb.append(count[i]).append(' ');
		br.close();
		System.out.print(sb.toString());
	}
}
