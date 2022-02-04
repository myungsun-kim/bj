import java.io.*;

public class Main_bj_b3_2010_플러그 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2010.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) answer+=Integer.parseInt(br.readLine());
		answer-=n-1;
		br.close();
		System.out.print(answer);
	}
}
