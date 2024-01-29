import java.io.*;
import java.util.*;

public class Main_bj_1026_보물 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) a[i]=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) b[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0;i<n;i++) sum+=a[i]*b[n-1-i];
		
		System.out.print(sum);
	}
}
