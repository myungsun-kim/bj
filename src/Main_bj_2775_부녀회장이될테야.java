import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 0층의 i호에는 i명
// 1층 1호 1 2호 3 3호 6 4호 10 ..
// 2층 1호 1 2호 4 3호 10 4호 20 ..
// 3층 1호 1 2호 5 3호 15 4호 35 ..
public class Main_bj_2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2775.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<>();
		int maxHeight = 0, maxNumber = 0;
		int[][] resident; //거주민
		
		for(int tc=0;tc<t;tc++) {
			int height = Integer.parseInt(br.readLine()); //층
			int number = Integer.parseInt(br.readLine()); //호
			if(maxHeight<height) maxHeight = height;
			if(maxNumber<number) maxNumber = number;
			queue.add(new int[] {height, number});
		}
		resident = residentCal(maxHeight, maxNumber);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			sb.append(resident[cur[0]][cur[1]]).append('\n');
		}
		
		br.close();
		System.out.print(sb.toString());
	}

	private static int[][] residentCal(int height, int number) {
		int[][] resident = new int[height+1][number+1];
		
		for(int i=1;i<=number;++i) resident[0][i] = i;//0층의 i호는 i명
		
		for(int i=1;i<=height;++i) { //i층의 j호에는 i-1층의 1호부터 j호까지 사는 사람들의 합
			for(int j=1;j<=number;++j) {
				int sum = 0;
				for(int k=1;k<=j;++k) {
					sum += resident[i-1][k];
				}
				resident[i][j] = sum;
			}
		}
		
		return resident;
	}
}
