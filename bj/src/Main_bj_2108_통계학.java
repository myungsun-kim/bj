import java.io.*;
import java.util.*;

public class Main_bj_2108_통계학 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2108.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		int[] arr = new int[n];
		int[] cnt = new int[8001];
		int min=-4001;
		int max_cnt=0, tmp_cnt=0;//최빈수, 최빈수의 개수
		int min_value, max_value;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			cnt[arr[i]+4000]++;
			max_cnt = Math.max(max_cnt, cnt[arr[i]+4000]);
			sum+=arr[i];
		}
		Arrays.sort(arr);
		min_value = arr[0];
		max_value = arr[n-1];

		for(int i=min_value+4000;i<max_value+4001;i++) {
			if(max_cnt==cnt[i]) {
				min = i-4000;
				tmp_cnt++;
				if(tmp_cnt==2) {
					break;
				}
			}
		}
		br.close();
		sb.append(Math.round(sum/(n*1.0))).append("\n");
		sb.append(arr[n/2]).append("\n");
		sb.append(min).append("\n");
		sb.append(max_value-min_value);
		System.out.print(sb);
	}
}
