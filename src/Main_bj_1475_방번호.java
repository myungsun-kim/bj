import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 다솜이는 방 번호를 플라스틱 숫자로 문에 붙이려고 함. 한 세트에는 0부터 9까지의 숫자가 들어있음
// 다솜이의 방 번호가 주어졌을때 필요한 세트의 개수의 최솟값 출력
// 9와 6은 뒤집어서 사용 가능
public class Main_bj_1475_방번호 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1475.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine(); //방 번호
		int[] count = new int[9]; //방 번호에 숫자들이 몇 번 쓰였는지
		int answer = 0;
		
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i)-'0'==9) {
				count[6]++; //9도 6으로 만들 수 있음
			}else {				
				count[n.charAt(i)-'0']++;
			}
		}
		
		count[6] = count[6]/2 + (count[6]%2==0?0:1);
		
		for(int i=0;i<count.length;i++) {
			if(answer<count[i]) answer=count[i];
		}
		
		br.close();
		System.out.print(answer);
	}
}
