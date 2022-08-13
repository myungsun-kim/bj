import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1205_등수구하기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = -1;
		int n = Integer.parseInt(st.nextToken()); //리스트에 있는 점수
		int newScore = Integer.parseInt(st.nextToken()); //새 점수
		int p = Integer.parseInt(st.nextToken()); //랭킹에 오를 수 있는 점수의 개수
		int[] list = new int[n];
		if(n!=0) st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(st.nextToken());
			if(answer==-1 && newScore>=list[i])	answer = i+1;	
			if(i==n-1 && n==p && list[i]==newScore) answer = -1;
		}

		if(answer==-1 && n<p) answer=n+1; //리스트 내엔 없으나 랭킹 안엔 들었을 경우
		br.close();
		System.out.print(answer);
		
	}
}
