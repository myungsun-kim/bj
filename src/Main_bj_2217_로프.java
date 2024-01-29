import java.io.*;
import java.util.*;
// n(1이상 100000이하)개의 로프가 있다
// 로프를 사용하여 물체를 들어올릴 수 있다
// 각각의 로프는 들 수 있는 물체의 중량이 다르다
// 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다
// ex) k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 중량
// 각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구하라
// 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라 사용해도 된다
public class Main_bj_2217_로프 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2217.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] rope = new int[n];
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		for(int i=n-1;i>=0;i--) {
			int sum = rope[i]*(-1*i+n);
			if(answer<sum) answer=sum;
		}
		br.close();
		System.out.print(answer);
	}
}
