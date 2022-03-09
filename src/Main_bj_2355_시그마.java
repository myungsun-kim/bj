import java.io.*;
import java.util.*;
public class Main_bj_2355_시그마 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2355.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		// a와 b 중 어떤 수가 더 큰지 정해져있지 않음
		long sum = 0;
		if(b>a) {
			sum=b*(b+1)/2-a*(a-1)/2;
		}else {
			sum=a*(a+1)/2-b*(b-1)/2;			
		}
		br.close();
		System.out.print(sum);
	}
}
