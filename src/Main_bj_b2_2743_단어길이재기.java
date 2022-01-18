import java.io.*;

public class Main_bj_b2_2743_단어길이재기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2743.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(br.readLine().length());
		br.close();
	}
}
