import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_3036_링 {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_bj_3036.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int firstRing = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n-1;++i) {
			int cur = Integer.parseInt(st.nextToken());
			
			for(int j=cur;j>0;--j) {
				if(firstRing%j==0 && cur%j==0) {
					sb.append(firstRing/j).append('/').append(cur/j).append('\n');
					break;
				}
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
