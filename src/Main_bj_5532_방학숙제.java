import java.io.BufferedReader;
import java.io.InputStreamReader;

// 방학 숙제는 수학과 국어 문제 풀기
// 방학은 총 L일, 국어는 총 A페이지, 수학은 총 B페이지
// 상근이는 하루에  국어 최대 C페이지, 수학 최대 D페이지를 풀 수 있음
// 상근이가 겨울 방학동안 숙제를 하지 않고 놀 수 있는 최대 날의 수 구하기
public class Main_bj_5532_방학숙제 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_5532.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine()); // 방학일수
		int a = Integer.parseInt(br.readLine()); // 국어 총 페이지
		int b = Integer.parseInt(br.readLine()); // 수학 총 페이지
		int c = Integer.parseInt(br.readLine()); // 하루에 풀 수 있는 국어의 양
		int d = Integer.parseInt(br.readLine()); // 하루에 풀 수 있는 수학의 양
		br.close();
		int answer = l-Math.max(a/c+(a%c==0?0:1), b/d+(b%d==0?0:1));
		System.out.print(answer);
	}
}
