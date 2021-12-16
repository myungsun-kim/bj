import java.io.*;
import java.util.*;
//N개의 세로선(1~N)과 M개의 가로선으로 이루어져 있고, 인접한 세로선 사이에는 가로선을 놓을 수 있다
//각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H(1~H)이며 모든 세로선이 같은 위치를 갖는다
//사다리 게임은 각각의 세로선마다 게임을 진행하고, 세로선의 가장 위에서부터 아래 방향으로 내려감
//가로선을 만난다면 가로선을 이용해 옆 세로선으로 이동한 다음 이동한 세로선에서 아래 방향으로 이동해야함
//사다리에 가로선을 추가해서 i번 세로선의 결과가 i번이 나와야한다. 그러기 위해 추가해야 하는 가로선 개수의 최소값은?
//오른쪽으로 이동시 1, 왼쪽으로 이동시 2
//1,i에서 h,i로 도착
public class Main_bj_g4_15684_사다리조작 {
	static int N,M,H,answer;
	static int[][] ladder;
	static boolean chk;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15684.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());//세로선 개수
		M=Integer.parseInt(st.nextToken());//가로선 개수
		H=Integer.parseInt(st.nextToken());//가로선이 있을 수 있는 위치
		ladder=new int[H+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			ladder[a][b]=1;
			ladder[a][b+1]=2;
		}
		
		chk=false;
		for(int i=0;i<=3;i++) {//사다리를 0~3개까지 놓는 경우
			answer=i;
			perm(1,0);
			if(chk) break;
		}
		if(!chk) answer=-1;
		
		System.out.print(answer);
	}
	
	static void perm(int row,int cnt) {
		if(answer==cnt) {
			if(check()) chk=true;
			return;
		}
		for(int i=row;i<=H;i++) {//새로운 사다리를 놓는 경우
			for(int j=1;j<N;j++) {
				if(ladder[i][j]==0 && ladder[i][j+1]==0) {
					ladder[i][j]=1;//사다리를 놓는다
					ladder[i][j+1]=2;
					perm(i,cnt+1);
					ladder[i][j]=ladder[i][j+1]=0;//다시 원래대로 돌림
				}
			}
		}
	}
	
	static boolean check() {//사다리 출발 지점과 도착 지점이 같은 열인지
		for(int i=1;i<=N;i++) {
			int col=i;
			for(int j=1;j<=H;j++) {//사다리 이동했을때 열의 위치 변경
				if(ladder[j][col]==1) {
					col++;
				}else if(ladder[j][col]==2) {
					col--;
				}
			}
			if(i!=col) return false;//시작점과 도착점이 다르면
		}
		return true;
	}
}
