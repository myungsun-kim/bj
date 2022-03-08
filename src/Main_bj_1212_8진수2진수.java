import java.io.*;

// 8진수가 주어졌을 때, 2진수로 변환하는 프로그램 작성
// 각 자리수를 이진변환 후(단, 세자리) 합치면 2진수가 됨
public class Main_bj_1212_8진수2진수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1212.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] arr = {"000","001","010","011","100","101","110","111"};
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(n.charAt(0)-'0'));
		for(int i=1;i<n.length();i++) {
			sb.append(arr[n.charAt(i)-'0']);
		}
		br.close();
		System.out.print(sb.toString());
	}
}
