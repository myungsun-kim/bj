import java.io.*;
import java.util.*;

public class Main_bj_1259_팰린드롬수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1259.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tmp;
		int size;
		char[] chk;
		while(true) {
			tmp=br.readLine();
			if(tmp.equals("0")) break;
			boolean check=true;
			size=tmp.length();
			chk=tmp.toCharArray();
			for(int i=0;i<size/2;i++) {
				if(chk[i]!=chk[size-i-1]) {
					check=false;
					break;
				}
			}
			if(check) {
				sb.append("yes");
			}else {
				sb.append("no");
			}
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
