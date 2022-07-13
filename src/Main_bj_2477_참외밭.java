import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1m^2의 넓이에 자라는 참외 개수를 헤아린 다음 참외밭의 넓이를 구하면 비례식을 이용해 참외의 총개수를 구할 수 있음
// 참외밭은 육각형. 밭의 경계는 동서 방향이나 남북
// 입력받을때 1동 2서 3남 4북. 반시계 방향으로
// ┐ 2 3 (1 3) 1 4 // (2 4) // 면적=한 번만 나온 방향의 크기 - (면적의 크기)
// ┌ 2 3 1 (4 1) 4 // (2 3)
// └ (2 4) 2 3 1 4 // (3 1) // 4 2 3 1 4 2
// ┘ 2 (3 2) 3 1 4 // (1 4)
public class Main_bj_2477_참외밭 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2477.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[6][2]; //방향과 크기를 입력받음
		int max_width=0, max_height=0;
		int index1=0, index2=0;
		int small, large;
		int k = Integer.parseInt(br.readLine()); //1m^2 넓이에 자라는 참외의 개수
		for(int i=0;i<6;i++) {//참외밭은 육각형
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());//방향
			map[i][1] = Integer.parseInt(st.nextToken());//크기
			if(map[i][0] == 1 || map[i][0] == 2) {
				max_width = Math.max(max_width, map[i][1]);
				if(max_width == map[i][1]) index1=i;
			}else {
				max_height = Math.max(max_height, map[i][1]);
				if(max_height == map[i][1]) index2=i;
			}
		}
		large = max_width*max_height;
		if(Math.abs(index1-index2) == 1) {//큰 맵 높이와 너비 인덱스가 붙어있으면
			if(Math.max(index1, index2)==3) {
				small = map[0][1]*map[5][1];
			}else if(Math.max(index1, index2)>3) {//인덱스 범위를 벗어난 경우				
				small = map[Math.max(index1, index2)-3][1]*map[Math.max(index1, index2)-4][1];
			}else {								
				small = map[Math.max(index1, index2)+2][1]*map[Math.max(index1, index2)+3][1];
			}
		}else {		
			small = map[Math.min(index1, index2)+2][1]*map[Math.min(index1, index2)+3][1];
		}
		sb.append((large-small)*k);
		br.close();
		System.out.print(sb);
	}
}
