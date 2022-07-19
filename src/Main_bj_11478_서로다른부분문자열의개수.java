import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_bj_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11478.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		HashSet<String> map = new HashSet<>();
		map.add(s);
		for(int start=0;start<s.length();start++) {
			for(int size=1;size<s.length();size++) {
				if(start+size<=s.length()) map.add(s.substring(start, start+size));
			}
		}
		br.close();
		System.out.print(map.size());
	}
}
