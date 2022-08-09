import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_bj_25305_커트라인 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_25305.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> score = new ArrayList<>(); 
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) score.add(Integer.parseInt(st.nextToken()));
		Collections.sort(score, Collections.reverseOrder());
		br.close();
		System.out.print(score.get(k-1));
		
	}
}
