import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이진 트리를 입력받아 전위, 중위, 후위 순회한 결과를 출력하는 프로그램을 작성
// 전위 순회 (루트) (왼쪽 자식) (오른쪽 자식)
// 중위 순회 (왼쪽 자식) (루트) (오른쪽 자식)
// 후위 순회 (왼쪽 자식) (오른쪽 자식) (루트)
// 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 
//둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
// 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드 
// 자식 노드가 없는 경우에는 .
class Node{
	char left;
	char right;
	char parent;
	
	public Node() {};
	
	public Node(char left, char right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	public Node(char left, char right, char parent) {
		super();
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}

public class Main_bj_1991_트리순회 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int size;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1991.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputCount = Integer.parseInt(br.readLine()); //입력 개수
		size = 26;
		boolean[] checked = new boolean[size]; //노드의 개수 확인
		Node[] node = new Node[size];
		for(int i=0;i<size;i++) node[i] = new Node();
		for(int i=0;i<inputCount;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int val = st.nextToken().charAt(0)-'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(!checked[val]) {
				checked[val] = true;
				n++;
			}
			if(left !='.' && !checked[charToInt(left)]) {
				checked[charToInt(left)] = true;
				n++;
			}
			if(right != '.' && !checked[charToInt(right)]) {
				checked[charToInt(right)] = true;
				n++;
			}
			node[val].left = left;
			node[val].right = right;
			if(left!='.') node[charToInt(left)].parent = intToChar(val);
			if(right!='.') node[charToInt(right)].parent = intToChar(val);
		}
		preOrder(0, node);
		inOrder(0, node);
		postOrder(0, node);
		System.out.println(sb.toString());
	}
	
	static void preOrder(int start, Node[] node) {
		// 루트, 왼쪽, 오른쪽
		int cur = start;
		boolean[] visited = new boolean[size];
		int left = charToInt(node[cur].left);
		int right = charToInt(node[cur].right);
		int parent = charToInt(node[cur].parent);
		int count = 0;
		
		while(true) {
			if(count == n) {
				sb.append('\n');
				break;
			}
			left = charToInt(node[cur].left);
			right = charToInt(node[cur].right);
			parent = charToInt(node[cur].parent);
			
			if(!visited[cur]) {
				visited[cur] = true;
				count++;
				sb.append(intToChar(cur));
				if(left >=0 && !visited[left]) {
					cur = left;
				}else if(right>=0 && !visited[right]) {
					cur = right;
				}
			}else {
				if(left>=0 && !visited[left]) {
					cur = left;
				}else if(right>=0 && !visited[right]) {
					cur = right;
				}else {	
					cur = parent;
				}
			}
		}

	}
	
	static void inOrder(int start, Node[] node) {
		// 왼쪽, 루트, 오른쪽
		int cur = start;
		boolean[] visited = new boolean[size];
		int left = charToInt(node[cur].left);
		int right = charToInt(node[cur].right);
		int parent = charToInt(node[cur].parent);

		int count = 0;
		
		while(true) {
			if(count == n) {
				sb.append('\n');
				break;
			}
			left = charToInt(node[cur].left);
			right = charToInt(node[cur].right);
			parent = charToInt(node[cur].parent);
			if(left>=0 && !visited[left]) {
				cur = left;
			}else if(!visited[cur]){
				visited[cur] = true;
				sb.append(intToChar(cur));
				count++;
				if(right>=0 && !visited[right]) {
					cur = right;
				}else if(parent>=0) {
					cur = parent;
				}
			}else {
				// 오른쪽
				if(right>=0 && !visited[right]) {					
					cur = right;
				}else {
					cur = parent;
				}
			}
		}
	}
	
	static void postOrder(int start, Node[] node) {
		// 왼쪽, 오른쪽, 루트
		int cur = start;
		boolean[] visited = new boolean[size];
		int left = charToInt(node[cur].left);
		int right = charToInt(node[cur].right);
		int parent = charToInt(node[cur].parent);

		int count = 0;
		
		while(true) {
			if(count == n) break;
			left = charToInt(node[cur].left);
			right = charToInt(node[cur].right);
			parent = charToInt(node[cur].parent);
			if(left>=0 && !visited[left]) {
				cur = left;
			}else if(right>=0 && !visited[right]) {
				cur = right;
			}else {
				visited[cur] = true;
				sb.append(intToChar(cur));
				count++;
				if(parent>=0 && !visited[parent]) {
					cur = parent;
				}else if(right>=0 && !visited[right]) {
					cur = right;
				}
			}
		}
	}
	
	static char intToChar(int input) {
		return (char)(input+65);
	}
	
	static int charToInt(char input) {
		return input-'A';
	}
}
