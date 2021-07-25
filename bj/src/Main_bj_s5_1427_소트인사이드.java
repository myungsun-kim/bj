import java.io.*;
import java.util.*;

public class Main_bj_s5_1427_소트인사이드 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1427.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		String tmp = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tmp.length();i++) {
			list.add(tmp.charAt(i)-'0');
		}
		Collections.sort(list);
		Collections.reverse(list);
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i));
		}
		br.close();
		System.out.print(sb);
	}
}
