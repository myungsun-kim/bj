import java.io.*;
import java.util.*;
// 정수형으로 표현된 스킬 레벨을 가지고 있는 네 명의 사람이 있다
// 숫자가 높을수록 더 좋은 플레이
// 두 명씩 팀을 이룰 때 두 팀의 점수 차가 가장 작을 때의 차이 출력
// 0,1 2,3 / 0,2 1,3 / 0,3 1,2 > 팀 구성 방법
public class Main_bj_13866_팀나누기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_13866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int count = 4;
		int[] arr = new int[count];
		int answer = Integer.MAX_VALUE;
		int[][] team = {{0,1,2,3},{0,2,1,3},{0,3,1,2}};
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0;i<team.length;i++) {
			int team1 = arr[team[i][0]]+arr[team[i][1]];
			int team2 = arr[team[i][2]]+arr[team[i][3]];
			int dif = Math.abs(team1-team2);
			if(answer>dif) answer=dif;
		}
		br.close();
		System.out.print(answer);
	}
	
}
