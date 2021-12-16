import java.io.*;
import java.util.*;
// 사회자가 몇 번째 수를 부른 후 빙고를 외치게 되는지 출력
// 선이 세 개 이상 그어지면 빙고
public class Main_bj_s5_2578_빙고 {
	static int[][] arr;
	static final int size = 5;
	static int rows;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2578.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[size][size];
		
		for(int i=0;i<size;i++) {//빙고 입력
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<size;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i=0;i<size;i++) {//사회자 번호 부름
			boolean chk=false;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<size;j++) {
				count++;
				int input = Integer.parseInt(st.nextToken());
				erase(input);
				chk=check();
				if(chk) break;
			}
			if(chk) break;
		}
		System.out.print(count);
	}
	
	static boolean erase(int input) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(arr[i][j]==input) {//해당 숫자 찾음
					arr[i][j]=0;
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean check() {//빙고 확인
		rows=0;
		
		boolean chk;
		for(int i=0;i<size;i++) {//행 확인
			chk=true;
			for(int j=0;j<size;j++) {				
				if(arr[i][j]!=0) {
					chk=false;
					break;
				}
			}
			if(chk) rows++;
		}
		
		for(int i=0;i<size;i++) {//열 확인
			chk=true;
			for(int j=0;j<size;j++) {				
				if(arr[j][i]!=0) {
					chk=false;
					break;
				}
			}
			if(chk) rows++;
		}
		
		chk = true;
		for(int i=0;i<size;i++) {//대각선 확인
			if(arr[i][size-i-1]!=0) {
				chk=false;
				break;
			}
		}
		if(chk) rows++;
		chk = true;

		for(int i=0;i<size;i++) {
			if(arr[i][i]!=0) {
				chk=false;
				break;
			}
		}
		if(chk) rows++;
	
		if(rows>=3) return true;
		return false;
	}
}
