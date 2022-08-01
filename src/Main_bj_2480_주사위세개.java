import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임 
// 1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
// 2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
// 3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
public class Main_bj_2480_주사위세개 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2480.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[7];
		int[] num = new int[3];
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			++count[cur];
			if(count[cur]==2) {
				num[1] = cur;
			}else if(count[cur]==3) {
				num[2] = cur;
			}else {
				if(num[0]<cur) num[0] = cur;
			}
		}
		if(num[2]!=0) {
			answer = 10000+num[2]*1000;
		}else if(num[1]!=0) {
			answer = 1000+num[1]*100;
		}else {
			answer = num[0]*100;
		}
		br.close();
		System.out.print(answer);
	}
}
