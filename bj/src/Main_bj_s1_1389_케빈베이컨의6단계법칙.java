import java.io.*;
import java.util.*;
//플로이드 와샬 알고리즘 : 모든 쌍 최단 경로를 찾는 동적 계획 알고리즘.
public class Main_bj_s1_1389_케빈베이컨의6단계법칙 {
	static final int INF = 9999999;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1389.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //유저의 수
		int M = Integer.parseInt(st.nextToken()); //친구 관계의 수
		int[][] distance=new int[N+1][N+1]; //케빈 베이컨의 수 입력
		
		//초기화
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				distance[i][j]=INF;
			}
		}
		//친구 관계 입력 받음
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine()," ");
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			distance[n1][n2]=1;
			distance[n2][n1]=1;
		}
		
		//플로이드 워셜 알고리즘
		//모든 정점을 경유 가능한 정점들로 고려한 모든 쌍 i와 j의 최단 경로의 거리를 찾는 방식
		//distance[i][j]=정점 i에서 정점 j로의 최소비용.거리
		//경유지>출발지>목적지로 삼중 루프
		for(int k=1;k<=N;k++) {//경유지 > 경유 가능한 정점 1~N
			for(int i=1;i<=N;i++) {//출발지
				if(i==k) continue; //출발지와 경유지가 같다면 반복문 수행X
				for(int j=1;j<=N;j++) {//목적지
					if(i==j || k==j) continue; //경유지와 목적지가 같거나 출발지와 목적지가 같으면 패스
					if(distance[i][k]!=INF && distance[k][j]!=INF && distance[i][j]>distance[i][k]+distance[k][j]) {
						distance[i][j]=distance[i][k]+distance[k][j];
					}
				}	
			}
		}
		
		int[] answer= new int[N+1];
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=N;j++) {
				if(distance[i][j]==INF || distance[i][j]==0) continue; 
					sum+=distance[i][j];
			}
			answer[i]=sum;//i의 케빈 베이컨의 수
			if(min>answer[i]) min=answer[i];//최소값 저장
		}
		
		for(int i=1;i<=N;i++) {
			if(answer[i]==min) {
				System.out.print(i);
				break;
			}
		}
	}
}
