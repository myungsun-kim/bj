import java.io.*;

// 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 나선에서 가장 긴 변의 길이를 k라고 했을 때, 그 변에 길이가 k인 정삼각형을 추가
// 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1,1,1,2,2,3,4,5,7,9
// N이 주어졌을 때, P(N)을 구하는 프로그램을 작성
public class Main_bj_9461_파도반수열 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9461.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] P = new long[N+1];
			for(int i=0;i<=N;i++) {
				if(i<=3) P[i]=1;
				else if(i<=5) P[i]=2;
				else P[i]=P[i-1]+P[i-5];
			}
			sb.append(P[N]).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
