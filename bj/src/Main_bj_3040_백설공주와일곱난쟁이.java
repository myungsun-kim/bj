import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] selected;
	static int sum; //일곱난쟁이의 모자의 합.
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_3040.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];//9명의 값을 입력받는 배열
		selected = new int[7];//일곱난장이를 저장할 배열
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}	
		combination(0,0,arr.length,selected.length);
		//arr.length 중 selected.length만큼 뽑기
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	static void combination(int index, int cnt, int n, int r) {//index>새로 저장될 배열의 인덱스
		if(r==0) {//다 뽑았을 경우
			sum=0;
			for(int i=0;i<selected.length;i++) {
				sum+=selected[i];
			}
			if(sum==100) {
				for(int i=0;i<selected.length;i++) {
					sb.append(selected[i]).append("\n");
				}
			}
			return;
		}else if(cnt==n) {//인덱스를 벗어났을경우
			return;
		}
		selected[index] = arr[cnt];//해당 원소를 저장
		combination(index+1,cnt+1,n,r-1);//해당 원소를 뽑은 경우
		combination(index,cnt+1,n,r);//해당 원소를 뽑지 않는 경우	
	}
}
