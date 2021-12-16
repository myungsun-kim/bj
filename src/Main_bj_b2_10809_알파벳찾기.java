import java.io.*;
import java.util.*;

public class Main_bj_b2_10809_알파벳찾기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		boolean check=false;
		for(char i='a';i<='z';i++) {
			for(int j=0;j<input.length();j++) {
				if(i == input.charAt(j)) {
					sb.append(j).append(" ");
					check=true;
					break;
				}
			}if(!check)sb.append(-1).append(" ");
			check=false;
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
