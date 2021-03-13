import java.io.*;
import java.util.*;

public class Main_bj_2908_상수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2908.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int cNum1 = num1%10*100 + num1/10%10*10 + num1/100;
		int cNum2 = num2%10*100 + num2/10%10*10 + num2/100;
		
		if(cNum1>cNum2) {
			System.out.print(cNum1);
		}else {
			System.out.print(cNum2);
		}
	}
}
