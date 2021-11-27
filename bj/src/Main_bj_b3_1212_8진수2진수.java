import java.io.*;

// 8진수가 주어졌을 때, 2진수로 변환하는 프로그램 작성
// 각 자리수를 이진변환 후(단, 세자리) 합치면 2진수가 됨
public class Main_bj_b3_1212_8진수2진수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1212.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n.length();i++) {
			String tmp = Integer.toBinaryString(n.charAt(i)-'0');	
			if(i!=0 && tmp.length()==1) sb.append("00");
			if(i!=0 && tmp.length()==2) sb.append("0");
			sb.append(tmp);
		}
		br.close();
		System.out.print(sb.toString());
	}
}
