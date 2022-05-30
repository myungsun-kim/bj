import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_10430_나머지 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10430.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		sb.append((a+b)%c).append('\n');
		sb.append(((a%c)+(b%c))%c).append('\n');
		sb.append((a*b)%c).append('\n');
		sb.append(((a%c)*(b%c))%c);
		br.close();
		System.out.print(sb.toString());
	}
}