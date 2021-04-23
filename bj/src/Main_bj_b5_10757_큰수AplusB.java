import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main_bj_10757_큰수AplusB {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10757.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		BigInteger add = a.add(b);
		System.out.print(add);
		br.close();
	}
}
