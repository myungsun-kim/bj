import java.io.*;
import java.util.*;

public class Main_bj_2441_별찍기4 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2441.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=n;i>0;i--) {
			for(int j=0;j<n-i;j++) sb.append(' ');
			for(int j=0;j<i;j++) sb.append('*');
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
