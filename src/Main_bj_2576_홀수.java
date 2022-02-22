import java.io.*;
// 7개의 자연수가 주어질 때 이 중 홀수인 자연수들을 골라 합을 구하고 고른 홀수들 중 최솟값 찾기  
public class Main_bj_2576_홀수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 7;
		int min = 101; //주어지는 자연수는 100보다 작다
		int sum = 0; //홀수들의 합
		for(int i=0;i<count;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input%2==1) {
				sum+=input;
				if(min>input) min=input;
			}
		}
		br.close();
		if(sum==0) {
			System.out.print(-1);
		}else {
			System.out.println(sum);
			System.out.print(min);
		}
	}
}
