import java.io.*;
import java.util.*;

public class Main_bj_2564_경비원 {
	static int C,R,S,start_d,start_n;
	static int[][] store;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2564.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		C=Integer.parseInt(st.nextToken());//열의 개수
		R=Integer.parseInt(st.nextToken());//행의 개수
		S=Integer.parseInt(br.readLine());//상점의 개수
		store=new int[S][2];
		
		for(int i=0;i<S;i++) {
			st=new StringTokenizer(br.readLine()," ");
			store[i][0]=Integer.parseInt(st.nextToken());
			store[i][1]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		start_d=Integer.parseInt(st.nextToken());
		start_n=Integer.parseInt(st.nextToken());
		
		int answer=0;
		for(int i=0;i<S;i++) {
			answer+=getDistance(store[i][0],store[i][1]);
		}
		br.close();
		System.out.print(answer);
	}
	
	static int getDistance(int d, int n) {
		if(d==start_d) {
			return Math.abs(start_n-n);
		}else if(start_d+d==3) {
			return R+Math.min(start_n+n, 2*C-start_n-n);
		}else if(start_d+d==7) {
			return C+Math.min(start_n+n, 2*R-start_n-n);
		}else{
			int num1;
			int num2;
			
			if(d%2==1) {
				num1=start_n;
			}else if(d==2) {
				num1=R-start_n;
			}else {
				num1=C-start_n;
			}
			
			if(start_d%2==1) {
				num2=n;
			}else if(start_d==2) {
				num2=R-n;
			}else {
				num2=C-n;
			}
			
			return num1+num2;
		}
	}
}
