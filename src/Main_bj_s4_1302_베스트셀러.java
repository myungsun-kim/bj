import java.io.*;
import java.util.*;

public class Main_bj_s4_1302_베스트셀러 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1302.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String answer = "";
		for(int i=0;i<n;i++) {
			String key = br.readLine();
			int value = 1;
			if(map.containsKey(key)) {
				value = map.get(key)+1;
			}
			map.put(key, value);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()>count) {
				count = entry.getValue();
				answer = entry.getKey();
			}
		}
		System.out.print(answer);
	}
}
