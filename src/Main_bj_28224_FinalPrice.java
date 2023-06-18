import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_28224_FinalPrice {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_28224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;++i) answer += Integer.parseInt(br.readLine());
		
		System.out.print(answer);
	}
}
