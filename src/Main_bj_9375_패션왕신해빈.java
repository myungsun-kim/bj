import java.io.*;
import java.util.*;
// 한 번 입었던 옷들의 조합은 절대 다시 입지 않는다
// 같은 종류의 의상은 하나만 입을 수 있다
public class Main_bj_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9375.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); //테스트케이스 수
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine());//가지고 있는 의상의 수
			HashMap<String, Integer> hash = new HashMap<>();
			for(int loop=0;loop<n;loop++) {				
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				st.nextToken();
				String tmp = st.nextToken();
				if(hash.containsKey(tmp)) hash.put(tmp, hash.get(tmp)+1);
				else hash.put(tmp, 1);
				// 해당 종류의 옷 개수 추가
			}
			int answer=1;
			//(옷개수+1)*(옷개수+1)*(옷개수+1)... -1이 값
			for(String key:hash.keySet()) {
				answer*=(hash.get(key)+1);
			}
			sb.append(answer-1).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
