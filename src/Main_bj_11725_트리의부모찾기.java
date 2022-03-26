import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_11725_트리의부모찾기 {
	static int[] root; // 각 정점의 부모 저장
	static ArrayList<Integer> list[]; // 각 정점 정보 저장
	static int n;
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_11725.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n  = Integer.parseInt(br.readLine()); //노드의 개수
		list = new ArrayList[n+1]; // 정점 정보 입력할 리스트
		root = new int[n+1]; // 각 정점의 부모 정보 저장
		
		for(int i=1;i<=n;i++) { // 한 정점에 연결된 정점들 관리
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<n;i++) { // 정점 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			list[tmp1].add(tmp2);
			list[tmp2].add(tmp1);
		}
		findParent();
		for(int i=2;i<=n;i++) {
			sb.append(root[i]).append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void findParent() { // 부모 찾기
		boolean[] visited = new boolean[n+1]; //노드 방문 체크
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); // 트리의 루트는 일
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(!visited[cur]) { // 현재 노드 방문한적 없을시
				visited[cur] = true;
				for(int i=0;i<list[cur].size();i++) { // 현재 노드의 자식 노드들
					int child = list[cur].get(i);
					if(root[child]!=0) continue; // 이미 부모 노드 체크함 
					root[child] = cur;
					q.offer(child);
				}
			}
		}
	}
}

