import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

// N장의 카드 중 가장 많이 가지고 있는 정수 구하기. 가장 많이 가지고 있는 정수가 여러가지라면 작은 것 출력
public class Main_bj_11652_카드 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11652.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<Long, Integer> map = new TreeMap<>();
		int maxCount = 0;
		long answer = 0;
		for(int i=0;i<n;i++) {
			Long tmp = Long.parseLong(br.readLine());
			int val = 1;
			if(map.containsKey(tmp)) {
				val+=map.get(tmp);
			}
			map.put(tmp, val);
		}
		
		for(Entry<Long, Integer> e:map.entrySet()) {
			if(e.getValue()>maxCount) {
				answer = e.getKey();
				maxCount = e.getValue();
			}
		}
		br.close();
		System.out.print(answer);
	}
}
