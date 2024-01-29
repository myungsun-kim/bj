import java.io.*;
// 세 개의 장대가 있고 첫 번째 장대에 반경이 서로 다른 n개의 원판이 쌓여 있음
// 한 번에 한 개의 원판만 다른 탑으로 옮길 수 있다
// 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 함
// 작업 수행 시 필요한 이동 순서를 출력. 단 이동 횟수는 최소
public class Main_bj_11729_하노이탑이동순서 {
	static StringBuilder sb = new StringBuilder();
	static int sum = 0;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11729.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n, 1, 2, 3);
		// n개의 원반을 2를 거쳐 1에서 3으로 옮긴다
		
		br.close();
		System.out.println(sum);
		System.out.print(sb.toString());
	}
	
	// 횟수, 시작, 임시, 목적
	static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt==0) return;
		
		hanoi(cnt-1, from, to, temp);//cnt-1개의 원반을 1에서 3을 거쳐 2로 옮긴다
		sb.append(from).append(' ').append(to).append('\n');
		sum++;
		hanoi(cnt-1, temp, from, to);//cnt-1개의 원반을 2에서 1을 거쳐 3로 옮긴다
	}
}
