import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_27962_오렌지먹은지오랜지 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_27962.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int cur = 1;
		String answer = "NO";
		
		while(cur<n) {		
			char[] start = input.substring(0, cur).toCharArray();
			char[] end = input.substring(n-cur, n).toCharArray();
			int dif = 0;
			for(int i=0;i<cur;++i) {
				if(start[i]!=end[i]) ++dif;
			}
			if(dif==1) {
				answer = "YES";
				break;
			}
			++cur;
		}
		
		System.out.print(answer);
	}
}
