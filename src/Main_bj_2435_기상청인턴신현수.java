import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2435_기상청인턴신현수 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2435.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int sum = 0;
		int answer = 0;
		// 10 2일때 .. 8 9 까지만 비교 > -7 +9 	9-2
		// 10 3일때 .. 7 8 9 까지만 비교 > -6 +9 	9-3
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i<k) sum += arr[i];
			else sum = sum + arr[i] - arr[i-k];
			if(i==k-1 || answer<sum) answer = sum;
		}
		br.close();
		System.out.print(answer);
	}
}
