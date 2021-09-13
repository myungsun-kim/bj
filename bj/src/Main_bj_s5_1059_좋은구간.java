import java.io.*;
import java.util.*;
// 정수 집합 S가 주어졌을 때 다음 조건을 만족하는 구간 [A,B]를 좋은 구간이라고 함
// A와 B는 양의 정수이고 A<B를 만족
// A<=x<=B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다
// 집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구함
public class Main_bj_s5_1059_좋은구간 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1059.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());//집합 s의 크기
		int[] s = new int[l];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<l;i++) s[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(s);
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int a=0, b=0;
		
		for(int i=0;i<l;i++) {
			if(s[i]>n) {
				if(i>0) a = s[i-1];
				b = s[i];
				sb.append(count(a, b, n));
				break;
			}
		}
		
		br.close();
		System.out.print(sb.toString());
	}
	// a이상 b이하에 n이 들어가야함
	// a는 s[i-1]초과 n이하	s[i-1]<a<=n
	// b는 s[i]미만 n이상	n<=b<s[i]
	static int count(int a, int b, int n) {
		int answer = 0;
		for(int i=a+1;i<=n;i++) {
			for(int j=i+1;j<b;j++) {
				if(j>=n) answer++;
			}
		}
		return answer;
	}
}
