import java.io.*;
import java.util.*;
//낚시왕은 처음에 1번 열의 한 칸 왼쪽에 있으며, 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동 멈춤
//1초 동안 일어나는 일: 
//		1. 낚시왕이 오른쪽으로 한 칸 이동
//		2. 낚시왕이 있는 열에 있는 상어 중 땅과 제일 가까운 상어를 잡음. 잡은 상어는 격자판에서 사라짐
//		3. 상어가 이동. 상어는 주어진 속도로 이동하며 이동하려는 칸이 격자판의 경계를 넘을 경우 방향 반대로 바꿔 이동
// 상어가 이동한 후 한 칸에 두 마리 이상 있을 수 있으나, 크기가 큰 상어가 모두 잡아먹음..
//낚시왕이 잡은 상어 크기의 합을 구함

public class Main_bj_g2_17143_낚시왕 {
	static class Shark{
		int r,c,s,d,z; //상어 위치, 상어 속력, 이동방향, 크기 (1상 2하 3우 4좌)

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}	
	}
	
	static int R,C,M,sum;
	static int[][] map;
	static Shark[] sharks;//상어 정보를 담은 배열
	static boolean[] death;//상어 존재 유무
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		sharks = new Shark[M+1];//1~M 사용
		death=new boolean[M+1];//상어 생존 유무
		
		for(int i=1;i<=M;i++) {//상어 입력
			st=new StringTokenizer(br.readLine()," ");
			int r=Integer.parseInt(st.nextToken());//행의 위치
			int c=Integer.parseInt(st.nextToken());//열의 위치
			int s=Integer.parseInt(st.nextToken());//속력
			int d=Integer.parseInt(st.nextToken());//이동방향
			int z=Integer.parseInt(st.nextToken());//크기
			map[r][c]=i;//몇번째 상어인지 저장
			sharks[i]=new Shark(r,c,s,d,z);
		}
		sum=0;
		for(int i=1;i<=C;i++) {//낚시꾼이 이동하면서 잡음
			fish(i);
			move();//상어 이동
		}
		br.close();
		System.out.print(sum);
	}
	
	static void fish(int col) {
		for(int i=1;i<=R;i++) {//행 탐색. 가장 가까운 상어를 잡음
			if(map[i][col]!=0) {
				sum+=sharks[map[i][col]].z;
				death[map[i][col]]=true;
				map[i][col]=0;
				break;
			}
		}
	}
	
	static void move() {
		for(int i=1;i<=M;i++) {
			if(!death[i]) {//잡히지도, 죽지도 않았다면
				moveShark(i);
			}
		}
        copyArr();//배열에 입력
	}
	
	//상하우좌
	static void moveShark(int n) {//몇번째 상어인지, 속력, 이동방향
		int s=sharks[n].s;//속력

		for(int i=0;i<s;i++) {
			switch(sharks[n].d) {
			case 1:
				sharks[n].r--;
				if(sharks[n].r<1) {
					sharks[n].r=2;
					sharks[n].d=2;
				}
				break;
			case 2:
				sharks[n].r++;
				if(sharks[n].r>R) {
					sharks[n].r=R-1;
					sharks[n].d=1;
				}
				break;
			case 3:
				sharks[n].c++;
				if(sharks[n].c>C) {
					sharks[n].c=C-1;
					sharks[n].d=4;					
				}
				break;
			case 4:
				sharks[n].c--;
				if(sharks[n].c<1) {
					sharks[n].c=2;
					sharks[n].d=3;
				}
				break;
			}
		}
	}

	static void copyArr() {
		map=new int[R+1][C+1];
		for(int i=1;i<=M;i++) {
			int r = sharks[i].r;
			int c = sharks[i].c;
			if(!death[i]) {//잡히지도, 죽지도 않았다면
				if(map[r][c]==0) {
					map[r][c]=i;
				}else if(map[r][c]>0){
					if(sharks[map[r][c]].z<sharks[i].z) {//현재 있는 상어보다 지금 상어의 크기가 크다면
						death[map[r][c]]=true;//기존에 있던 상어는 먹힘
						map[r][c]=i;
					}else {//원래 있는 상어의 크기가 더 크다면
						death[i]=true;//지금 상어 먹힘
					}
				}
			}
		}
	}
}