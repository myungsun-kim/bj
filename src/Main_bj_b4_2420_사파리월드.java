import java.io.*;
import java.util.*;

public class Main_bj_b4_2420_사파리월드 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2420.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		System.out.print(Math.abs(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken())));
		br.close();
	}
}
