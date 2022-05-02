import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_11654_아스키코드 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char input = br.readLine().charAt(0);
		
		System.out.println(input+0);
	}
}
