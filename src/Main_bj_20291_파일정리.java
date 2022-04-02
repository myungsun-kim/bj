import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 파일을 확장자 별로 정리해서 몇 개씩 있는지
// 확장자들을 사전 순으로 정렬
public class Main_bj_20291_파일정리 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_20291.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 파일의 개수
		Map<String, Integer> map = new TreeMap<>(); // 파일 확장자와 개수 저장
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),".");
			st.nextToken();
			String input = st.nextToken(); //확장자명
			int val = 1;
			if(map.get(input) != null) { //맵에 이미 저장되어 있다면
				val += map.get(input);
			}
			map.put(input, val);
		}

		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
		}
		System.out.print(sb.toString());
	}
}
