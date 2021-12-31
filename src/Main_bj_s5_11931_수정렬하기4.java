import java.io.*;
import java.util.*;
// n개의 수가 주어졌을때 주어진 수를 내림차순으로 정렬. 1<=n<=1000000 
// 주어진 수는 절대값이 1000000 이하인 정수로 중복 X
public class Main_bj_s5_11931_수정렬하기4 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		final int range = 1000000; //절대값이 1000000 이하
		int max = Integer.MIN_VALUE; //주어진 수 중 가장 큰 수
		int min = Integer.MAX_VALUE; //주어진 수 중 가장 작은 수
		boolean[] visited = new boolean[2*range+1];
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			visited[tmp+range] = true;
			if(tmp>max) max = tmp;
			if(tmp<min) min = tmp;
		}
		for(int i=max+range;i>=min+range;i--) {
			if(visited[i]) {
				sb.append(i-range).append('\n');
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
