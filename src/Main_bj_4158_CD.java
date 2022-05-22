import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_bj_4158_CD {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4158.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0) break;
			int count = 0;
			
			HashSet<Integer> hash = new HashSet<>();
			for(int i=0;i<n;i++) {
				hash.add(Integer.parseInt(br.readLine()));
			}
			for(int i=0;i<m;i++) {
				if(hash.contains(Integer.parseInt(br.readLine()))) count++;
			}
			
			sb.append(count).append('\n');
		}
		
		br.close();
		System.out.print(sb.toString());
	}
}
