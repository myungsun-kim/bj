import java.io.*;
import java.util.*;

public class Main_bj_7568_덩치 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_7568.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];//사람들의 키와 몸무게를 저장
		int grade;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());//몸무게
			arr[i][1] = Integer.parseInt(st.nextToken());//키
		}
		
		for(int i=0;i<n;i++) {
			grade = 1;
			for(int j=0;j<n;j++) {				
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) grade++;
			}
			sb.append(grade).append(" ");
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
