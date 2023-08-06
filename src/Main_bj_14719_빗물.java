import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14719_빗물 {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_bj_14719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int maxHeight = 0; //가장 높게 쌓여있는 블록의 높이
		boolean[][] map = new boolean[h][w]; //블록은 true
		int answer = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<w;++i) {
			int height = Integer.parseInt(st.nextToken());
			if(height>maxHeight) maxHeight = height;
			for(int j=0;j<height;++j) map[j][i] = true;
		}

		// 블록 사이 빈 공간 찾기
		for(int i=0;i<maxHeight;++i) {
			int start = -1;
			int water = 0;
			for(int j=0;j<w;++j) {
				if(map[i][j]) {
					start = j;
					if(start != -1) { // 새 블록 등장
						answer += water;
						water = 0;
					}
				}else {
					if(start != -1) ++water;
				}
			}
		}
		
		br.close();
		System.out.print(answer);
	}
}
