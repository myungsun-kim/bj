import java.util.*;
import java.io.*;

public class Main_bj_b4_2588_곱셈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int a = num2/100;
		int b = (num2-a*100)/10;
		int c = num2 - a*100 - b*10;
		sb.append(num1*c).append("\n").append(num1*b).append("\n").append(num1*a).append("\n").append(num1*num2);
		System.out.println(sb.toString());
		
	}
}