import java.io.*;
import java.util.*;

public class Main_bj_11718_그대로출력하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11718.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String tmp = br.readLine();
			if(tmp==null) break;
			sb.append(tmp).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
