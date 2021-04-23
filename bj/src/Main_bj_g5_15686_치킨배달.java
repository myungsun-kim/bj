import java.io.*;
import java.util.*;
// 크기가 NxN인 도시. 도시의 칸은 (r,c) 0:빈칸 1:집 2:치킨집
// 치킨거리 : 집(r1,c1)과 가장 가까운 치킨집(r2,c2) 사이의 거리|r1-r2|+|c1-c2|
// 도시의 치킨거리 = 모든 집의 치킨 거리의 합
public class Main_bj_15686_치킨배달 {
	static int[][] map;
	static ArrayList<Dot> home = new ArrayList<Dot>();
	static ArrayList<Dot> chicken = new ArrayList<Dot>();
	static Stack<Dot> selectedChicken = new Stack<>();
	static int N, M, total=Integer.MAX_VALUE;
	//도시의 크기 / 폐업시키지 않을 치킨집의 최대 수 / 도시의 치킨 거리
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //도시의 크기
		M = Integer.parseInt(st.nextToken()); //폐업시키지 않을 치킨집의 최대 수
		map = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home.add(new Dot(i,j));
				}
				if(map[i][j]==2) {
					chicken.add(new Dot(i,j));
				}
			}
		}
		//모든 치킨집에 대해 M개의 치킨집을 고르고 그때의 치킨 거리의 최소값을 구함
		comb(0,0);
		br.close();
		System.out.println(total);
	}
	
	static void comb(int start, int count) {
		if(count == M) {
			total=Math.min(total, getDistance());
			return;
		}
		
		for(int i=start;i<chicken.size();i++) {
			selectedChicken.push(chicken.get(i));
			comb(i+1,count+1);
			selectedChicken.pop();
		}
	}

	static int getDistance() {
		int sum=0;
		for(Dot h : home) {//각 도시의 치킨거리
			int distance = Integer.MAX_VALUE;
			for(Dot c : selectedChicken) {
				distance = Math.min(distance, Math.abs(h.x-c.x)+Math.abs(h.y-c.y));
			}
			sum += distance;
		}
		return sum;
	}
	
}

class Dot{
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
