import java.io.*;
// 서로 다른 N개의 자연수의 합이 S. S가 주어질 때 자연수 N의 최댓값 구하기
public class Main_bj_s5_1789_수들의합 {
	static long N;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1789.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		N = 0;
		
		for(long i=1;i<=S;i++) { //1부터 S까지 더함
			sum+=i;
			N++;
			if(sum>S) { //1부터 S까지 더했을때 S보다 더 커지는 시점에서 sum-S의 값을 빼줌
				if(sum!=1) N--;
				break;
			}
		}
		br.close();
		System.out.print(N);
	}
}
