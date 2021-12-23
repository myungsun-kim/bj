import java.io.*;
import java.util.*;
// P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열
// 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]
// 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열(P)을 찾는 프로그램을 작성
// 비내림차순=각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우 >오름차순
// 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력
// N<=50, 0<A[i]<=1000
public class Main_bj_s4_1015_수열정렬 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1015.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); //배열 A의 크기
		
		int[] a = new int[n]; //배열 A의 값 저장
		int[] seq = new int[n]; //배열 A의 순서를 정렬할 배열
		boolean[] visited = new boolean[n]; //중복값이 있을시 체크
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			seq[i] = a[i];
		}
		
		Arrays.sort(seq);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[j] && a[i]==seq[j]) {
					visited[j] = true;
					sb.append(j).append(' ');
					break;
				}
			}
		}
		System.out.print(sb.toString());
	}
}

