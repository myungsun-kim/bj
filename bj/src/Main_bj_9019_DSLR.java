import java.io.*;
import java.util.*;
//n의 네 자리수 d1,d2,d3,d4
public class Main_bj_9019_DSLR {
	static boolean[] visited;//방문체크
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_9019.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int A,B;

		for(int tc=0;tc<T;tc++) {
			visited=new boolean[10000];
			st=new StringTokenizer(br.readLine()," ");
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());

			bfs(A,B);
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static void bfs(int A, int B) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(A,""));
		visited[A]=true;//방문 처리
		String answer="";
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.n==B) {//최종 값이라면
				q.clear();
				sb.append(tmp.answer);
				break;
			}
			
			if(!visited[D(tmp.n)]) {
				visited[D(tmp.n)]=true;
				q.offer(new Node(D(tmp.n),tmp.answer+"D"));
			}
			if(!visited[S(tmp.n)]) {
				visited[S(tmp.n)]=true;
				q.offer(new Node(S(tmp.n),tmp.answer+"S"));
			}
			if(!visited[L(tmp.n)]) {
				visited[L(tmp.n)]=true;
				q.offer(new Node(L(tmp.n),tmp.answer+"L"));
			}
			if(!visited[R(tmp.n)]) {
				visited[R(tmp.n)]=true;
				q.offer(new Node(R(tmp.n),tmp.answer+"R"));
			}			
		}
	}
	
	static int D(int n) {
//		if(2*n>9999) return ;
		return 2*n%10000;
	}
	static int S(int n) {
		if(n==0) return 9999;
		return n-1;
	}
	static int L(int n) {
		int d1=n/1000;
		int d2=n%1000/100;
		int d3=n%100/10;
		int d4=n%10;
		return d2*1000+d3*100+d4*10+d1;
	}
	static int R(int n) {
		int d1=n/1000;
		int d2=n%1000/100;
		int d3=n%100/10;
		int d4=n%10;
		return d4*1000+d1*100+d2*10+d3;
	}
	
	static class Node{//정수 값과 결과 값을 저장
		int n;
		String answer;
		
		public Node(int n, String answer) {
			super();
			this.n = n;
			this.answer = answer;
		}
	}
}
