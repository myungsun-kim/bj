import java.io.*;
// 탁자 위에 돌 n개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며
// 돌은 1개 또는 3개 가져갈 수 있다
// 마지막 돌을 가져가는 사람이 게임을 이기게 됨
// 두 사람이 완벽하게 게임을 했을 때 이기는 사람을 구하는 프로그램 작성
// 상근이가 이기면 SK, 창영이가 이기면 CY 출력
public class Main_bj_9655_돌게임 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9655.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// n=1 상근1
		// n=2 상근1 창영1
		// n=3 상근3
		// n=4 상근1 창영3 또는 상근3 창영1
		// n 홀수 상근이김 짝수 창영이김
		
		String answer = (n%2==1)?"SK":"CY";
		
		br.close();
		System.out.print(answer);
	}
}
