import java.io.*;
import java.util.*;

public class Main_bj_s4_10815_숫자카드 {
	static int[] card;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10815.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());//카드 수
		card = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);//정렬
		
		int m = Integer.parseInt(br.readLine());//입력 횟수
		int input;
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<m;i++) {
			input = Integer.parseInt(st.nextToken());
			
			if(binarySearch(input)) sb.append("1 ");
			else sb.append("0 ");
		}
		
		br.close();
		System.out.print(sb.toString());
	}
	
	static boolean binarySearch(int input) {
		int first = 0;
		int end = card.length-1;
		int mid = (first+end)/2;
		
		while(first<=end) {
			mid = (first+end)/2; //중간값
			
			if(input == card[mid]) {
				return true;
			}else {
				if(input < card[mid]) {
					end = mid-1;
				}else {
					first = mid+1;
				}
			}
		}
		return false;
	}
}
