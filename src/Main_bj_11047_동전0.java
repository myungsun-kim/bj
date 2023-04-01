import java.io.*;
import java.util.*;
//준규는 총 n종류의 동전을 가지고 있고 각각의 동전을 매우 많이 가지고 있음. 동전은 오름차순으로 되어 있음
//동전을 적절히 활용해 k로 만들려고 한다. 이때 필요한 동전 개수의 최솟값 구하기

public class Main_bj_11047_동전0 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());//동전의 종류 개수
		int k = Integer.parseInt(st.nextToken());//만들어야 하는 금액
		int[] coin = new int[n];
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int answer=0;
		for(int i=n-1;i>=0;i--) {
			if(k>=coin[i]) {
				answer+=k/coin[i];
				k%=coin[i];				
			}
			if(k==0) break;
		}
		System.out.print(answer);
	}
}
