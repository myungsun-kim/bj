import java.io.*;
import java.util.*;
//점수의 합이 최대한 100에 가깝게
public class Main_bj_b1_2851_슈퍼마리오 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2851.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int[] sum = new int[10];
		int tmp=0, min=Integer.MAX_VALUE, answer=0;
		for(int i=0;i<10;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			tmp+=arr[i];
			sum[i]=tmp;//임시값
		}
		for(int i=0;i<10;i++) {
			if(Math.abs(sum[i]-100)<=min) {
				min = Math.abs(sum[i]-100);
				answer = sum[i];
			}
		}
		System.out.print(answer);
	}
}
