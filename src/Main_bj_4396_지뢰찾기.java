import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 지뢰찾기는 nxn 격자 위에서 이루어짐
// 지뢰가 없는 지점을 건드리면, 그곳의 상하좌우 혹은 대각선으로 인접한 8개의 칸에 지뢰가 몇 개 있는지 알려주는 0과 8사이의 숫자가 나타남
// 일부가 플레이된 게임의 정보를 읽어 해당하는 격자 출력
public class Main_bj_4396_지뢰찾기 {
	static int n;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[n][n]; //격자 정보
		ArrayList<int[]> mine = new ArrayList<>(); //지뢰 정보
		char[][] result = new char[n][n]; //결과
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<n;j++) {
				if(input.charAt(j)=='*') {
					mine.add(new int[] {i,j});
					map[i][j]=true;//지뢰 정보 저장
				}
				result[i][j] = '.'; //결과 초기화
			}
		}
		
		boolean mineCheck = false; //지뢰를 밟았는지 밟지 않았는지
		
		// 사용자 정보
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<n;j++) {
				if(input.charAt(j)=='x') {
					if(!mineCheck && map[i][j]) {
						mineCheck=true; //지뢰를 밟음
					}else {
						int cnt=0; //해당 위치의 인접한 8칸에 몇개의 지뢰가 있는지ㄴ
						for(int d=0;d<8;d++) {
							if(check(i+dr[d],j+dc[d]) && map[i+dr[d]][j+dc[d]]) {
								cnt++;
							};
						}
						result[i][j]=(char)(cnt+'0');
					}
				}
			}
		}
		
		if(mineCheck) { //지뢰를 밟았는지 아닌지
			for(int i=0;i<mine.size();i++) {
				result[mine.get(i)[0]][mine.get(i)[1]]='*';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(result[i][j]);
			}sb.append('\n');
		}
		
		br.close();
		System.out.print(sb.toString());
	}
	
	static boolean check(int r, int c) { //인덱스 벗어나는지 유무
		if(r<0 || c<0 || r>=n || c>=n) return false;
		return true;
	}
}
