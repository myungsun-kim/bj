import java.io.*;
import java.util.*;
//스티커를 붙이는 방법
//1. 스티커를 회전시키지 않고 모눈종이에서 떼어냄
//2. 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾음
//	스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽, 왼쪽의 위치를 선택
//3. 선택한 위치에 스티커를 붙이고, 스티커를 붙일 수 있는 위치가 없어서 스티커를 못붙인다면
//	스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복
//4. 0도, 90도, 180도, 270도 회전시켰음에도 스티커를 붙이지 못했다면 해당 스티커를 버림

public class Main_bj_g3_18808_스티커붙이기 {
	static int N, M, K, R, C;
	static boolean[][] notebook,sticker,sticker_tmp;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_18808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());//세로길이
		M=Integer.parseInt(st.nextToken());//가로길이
		K=Integer.parseInt(st.nextToken());//스티커의 개수
		notebook = new boolean[N][M];//노트북
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine()," ");
			R=Integer.parseInt(st.nextToken());//스티커가 인쇄된 모눈종이의 행의 개수
			C=Integer.parseInt(st.nextToken());//열의 개수
			sticker=new boolean[R][C];
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<C;j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						sticker[i][j]=true;//스티커 정보 입력
					}
				}				
			}
			boolean chk=false;//해당 스티커 붙였는지 유무
			for(int d=0;d<4;d++) {//사방향 탐색
				if(d!=0) rotate();//회전하는 메소드
				
				for(int i=0;i<=N-R;i++) {
					for(int j=0;j<=M-C;j++) {
						if(check(i,j)) {
							stick(i,j);//해당 스티커를 붙임
							chk=true;
							break;
						}
					}
					if(chk) break;//해당 스티커 붙임
				}
				if(chk) break;//해당 스티커 붙임
			}
		}
		
		System.out.print(count());
	}
	
	
	static boolean check(int start_row, int start_col) {//스티커를 붙일 수 있는지 확인
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(sticker[i][j] && notebook[i+start_row][j+start_col]) return false;
				//스티커를 붙일 수 없는 경우
			}
		}
		return true;
	}
	
	static void stick(int start_row, int start_col) {//스티커를 붙임
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(sticker[i][j]) notebook[i+start_row][j+start_col]=true;
			}
		}
	}
	
	static void rotate() {//90도 회전
		sticker_tmp=new boolean[R][C];
		copyTmp();
		int tmp=R;
		R=C;
		C=tmp;//R,C값 변경
		sticker=new boolean[R][C];
		copyRotate();
	}
	
	static void copyTmp() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sticker_tmp[i][j]=sticker[i][j];
			}
		}
	}
	
	static void copyRotate() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sticker[i][j]=sticker_tmp[C-j-1][i];
			}
		}
	}
	
	static int count() {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(notebook[i][j]) cnt++;
			}
		}
		return cnt;
	}
	
}
