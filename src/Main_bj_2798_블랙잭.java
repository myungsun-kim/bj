import java.io.*;
import java.util.*;

public class Main_bj_2798_블랙잭 {
	static int N,M,sum,tmp_idx;
	static int[] card, selected;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2798.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//카드의 개수
		M = Integer.parseInt(st.nextToken());//카드의 최대 가능한 합
		
		card = new int[N];
		check = new boolean[N];
		selected = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0);
		br.close();
		System.out.println(sum);
	}

	private static void comb(int cnt) {
		if(cnt==3) {
			int tmp_sum=0;
			for(int i=0;i<3;i++) {
				tmp_sum+=selected[i];
				if(tmp_sum>M) return;
			}
			sum = Math.max(sum, tmp_sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				selected[cnt] = card[i];
				comb(cnt+1);
				check[i]=false;
			}
		}
	}
}
