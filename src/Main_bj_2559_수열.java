import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2559_수열 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2559.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long answer = Long.MIN_VALUE;
		long tmp = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) tmp+=arr[i];
		answer = tmp;
		for(int i=0;i<n-k;i++) {
			tmp = tmp-arr[i]+arr[k+i];
			if(tmp>answer) answer=tmp;
		}
		br.close();
		System.out.print(answer);
	}
}
