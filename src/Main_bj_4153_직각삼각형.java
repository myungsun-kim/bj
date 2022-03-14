import java.io.*;
import java.util.*;

public class Main_bj_4153_직각삼각형 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_4153.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] arr = new int[3];
		int[] square = new int[3];
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<3;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			if(arr[0]==0 && arr[1]==0 && arr[2]==0) break;
			square[0]=Math.max(arr[0], Math.max(arr[1], arr[2]));
			if(square[0]==arr[0]) {
				square[1]=arr[1]*arr[1];
				square[2]=arr[2]*arr[2];
			}else if(square[0]==arr[1]) {
				square[1]=arr[0]*arr[0];
				square[2]=arr[2]*arr[2];				
			}else {
				square[1]=arr[0]*arr[0];
				square[2]=arr[1]*arr[1];								
			}
			square[0]=square[0]*square[0];
			
			if(square[0]==square[1]+square[2]) {
				sb.append("right");
			}else {
				sb.append("wrong");
			}
			sb.append("\n");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
