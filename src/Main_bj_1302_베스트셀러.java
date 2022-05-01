import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_bj_1302_베스트셀러 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1302.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String answer = "";
		for(int i=0;i<n;i++) {
			String title = br.readLine();
			int value = 1;
			if(map.containsKey(title)) {
				value = map.get(title)+1;
			}
			map.put(title, value);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()>count) {
				count = entry.getValue();
				answer = entry.getKey();
			}
		}
		br.close();
		System.out.print(answer);
	}
}
