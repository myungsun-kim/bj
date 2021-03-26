import java.io.*;
import java.util.*;
// c d e f g a b C 총 8개 음. c는 1로, d는 2로, ..., C를 8로 변경
//1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed
public class Main_bj_2920_음계 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2920.txt"));
		int[] arr = new int[8];
		int dif=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i==1) {
				dif=arr[i]-arr[i-1];
			}else if(i>0 && i<arr.length) {
				if(dif!=arr[i]-arr[i-1]) {
					dif=2;
					break;
				}
			}
		}
		br.close();
		
		if(dif==1) {
			System.out.print("ascending");
		}else if(dif==-1) {
			System.out.print("descending");
		}else {
			System.out.print("mixed");
		}
	}
}
