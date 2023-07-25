import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_5567_결혼식 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_5567.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int start = 1; //상근이의 학번은 1
		int count = 0;
		boolean[][] rel = new boolean[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		
		for(int i=0;i<m;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a][b] = rel[b][a] = true;
		}
		
		for(int i=1;i<=n;++i) {
			if(rel[start][i]) {
				if(!visited[i]) { //친구 찾기
					++count;
					visited[i] = true;
				}
				for(int j=2;j<=n;++j) { //친구의 친구 찾기
					if(!visited[j] && rel[i][j]) {
						visited[j] = true;
						++count;
					}
				}
			}
		}
		br.close();
		System.out.print(count);
	}
}
