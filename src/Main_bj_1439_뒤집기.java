import java.io.BufferedReader;
import java.io.InputStreamReader;

// 0과 1로만 이루어진 문자열 S를 가지고 있고, 이 문자열 S에 있는 모든 숫자를 전부 같게 만드려고 한다
// S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집음
public class Main_bj_1439_뒤집기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1439.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		int[] count = new int[2];
		boolean check = true; //현재 수가 0이면 true, 1이면 false
		count[0] = 1;
		int cur = 0;
		
		for(int i=0;i<s.length;i++) {
			if(s[i]!=s[cur]) {// 값이 바뀐다면
				cur = i;
				check = !check;
				if(check) {
					count[0]++;
				}else {
					count[1]++;
				}
			}
		}
		
		br.close();
		System.out.print(Math.min(count[0], count[1]));
	}
}
