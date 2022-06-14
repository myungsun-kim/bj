import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
// 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성
// 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
public class Main_bj_1269_대칭차집합 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1269.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 2; //집합의 개수
		int[] setCount = new int[count]; //각 집합의 원소 수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = 0;
		for(int i=0;i<count;i++) {
			setCount[i] = Integer.parseInt(st.nextToken());
			answer += setCount[i];
		}
		int intersecCount = 0; //교집합의 원소 수
		HashSet<Integer> set = new HashSet<>(); //교집합을 구하기 위해
		
		for(int i=0;i<count;i++) {			
			st = new StringTokenizer(br.readLine()," "); //a집합 원소들
			for(int j=0;j<setCount[i];j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(set.contains(tmp)) ++intersecCount; //교집합의 경우
				set.add(tmp);
			}
		}
		answer -= intersecCount*2;
		br.close();
		System.out.print(answer);
	}
}
