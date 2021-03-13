import java.io.*;
import java.util.*;

public class Main_bj_5568_카드놓기 {
	static int n,k;
	static int[] card, selected;
	static boolean[] visited;
	static Set<Integer> hashSet = new HashSet<>();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_5568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		card = new int[n];
		visited = new boolean[n];
		selected = new int[k];
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
		
		System.out.println(hashSet.size());
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==k) {
			String tmp = "";
			for(int i=0;i<k;i++) {
				tmp+=selected[i];
			}
			int tmp_n = Integer.parseInt(tmp);
			hashSet.add(tmp_n);
			return;
		}
		if(cnt>k) return;
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {				
				visited[i]=true;
				selected[cnt] = card[i];
				comb(cnt+1,i);
				visited[i]=false;
			}
		}
	}
}
