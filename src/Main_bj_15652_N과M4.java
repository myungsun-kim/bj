import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_15652_N과M4 {
	static int n, m;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15652.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		select = new int[m];
		perm(0,1);
		br.close();
		System.out.print(sb.toString());
	}
	
	static void perm(int idx, int cur) {
		if(idx==m) {
			print();
			return;
		}
		
		for(int i=cur;i<=n;i++) {
			select[idx] = i;
			perm(idx+1,i);
		}
	}
	
	static void print() {
		for(int i=0;i<m;i++) sb.append(select[i]).append(' ');
		sb.append('\n');
	}
}
