import java.io.*;
import java.util.*;
// 상대편 마린의 위치 계산
// (x1,y1)에서 계산한 r1과 (x2,y2)에서 계산한 r2
// 마린이 있을 수 있는 좌표의 수 출력
public class Main_bj_s4_1002_터렛 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1002.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			
			int answer=2;
			int distance_pow=(int) (Math.pow(x2-x1,2)+Math.pow(y2-y1,2));//두 점 사이 거리
			if(x1==x2 && y1==y2 && r1==r2) {
				answer=-1;
			}else if(distance_pow>Math.pow(r2+r1, 2) || distance_pow<Math.pow(r2-r1, 2)){//서로 접하지 않음
				answer=0;
			}else if(distance_pow==Math.pow(r2+r1, 2) || distance_pow==Math.pow(r2-r1, 2)) {//한 점만 접할 때
				answer=1;
			}else {
				answer=2;
			}
			System.out.println(answer);
		}
		br.close();
	}
}
