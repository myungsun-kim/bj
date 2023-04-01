import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_11399_ATM {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11399.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];//돈을 인출하는데 얼마나 걸리는지
		int[] sum=new int[n+1];//n번째 사람이 돈을 인출하는 시간
		int totalSum = 0;//모든 사람이 돈을 인출하는데 걸리는 최소한의 시간
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		for(int i=1;i<=n;i++) {
			sum[i] = sum[i-1]+p[i];
			totalSum += sum[i];
		}
		br.close();
		System.out.print(totalSum);
	}
}
