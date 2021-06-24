import java.io.*;
import java.util.*;
//잘라진 하얀색 색종이의 수와 파란색 색종이 수 구하기
//N은 2,4,8,16,32,64,128 중 하나
public class Main_bj_s3_2630_색종이만들기 {
	static int[][] paper;
	static int w_cnt, b_cnt;//하얀색 색종이 수 / 파란색 색종이 수
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2630.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		paper=new int[N][N];
		boolean chk=true;//모든 부분이 같은 색일 경우
		int start=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
				if(i==0 && j==0) start=paper[0][0];
				if(paper[i][j]!=start) chk=false;
			}
		}
		w_cnt=b_cnt=0;
		if(chk) {
			if(start==0) {
				w_cnt++;
			}else {
				b_cnt++;
			}
		}else {			
			//사분면 체크
			quadrant(0,0,N);
		}
		
		sb.append(w_cnt).append('\n').append(b_cnt);
		System.out.print(sb.toString());
	}
	
	static void quadrant(int start_r, int start_c, int size) {
		if(size==1) {
			if(paper[start_r][start_c]==0) {
				w_cnt++;
			}else {
				b_cnt++;
			}
			return;
		}

		if(check(start_r, start_c+size/2, size/2)) {//1
			if(paper[start_r][start_c+size/2]==0) {//흰색
				w_cnt++;
			}else {//파란색
				b_cnt++;				
			}
		}else {
			quadrant(start_r, start_c+size/2, size/2);
		}
		
		if(check(start_r, start_c, size/2)) {//2
			if(paper[start_r][start_c]==0) {//흰색
				w_cnt++;
			}else {//파란색
				b_cnt++;				
			}
		}else {
			quadrant(start_r, start_c, size/2);
		}
		
		if(check(start_r+size/2, start_c+size/2, size/2)) {//3
			if(paper[start_r+size/2][start_c+size/2]==0) {//흰색
				w_cnt++;
			}else {//파란색
				b_cnt++;				
			}
		}else {
			quadrant(start_r+size/2, start_c+size/2, size/2);
		}
		
		if(check(start_r+size/2, start_c, size/2)) {//4
			if(paper[start_r+size/2][start_c]==0) {//흰색
				w_cnt++;
			}else {//파란색
				b_cnt++;				
			}
		}else {
			quadrant(start_r+size/2, start_c, size/2);
		}
	}
	
	static boolean check(int start_r, int start_c, int size) {
		int start=0;
		for(int i=start_r;i<start_r+size;i++) {
			for(int j=start_c;j<start_c+size;j++) {
				if(i==start_r && j==start_c) start=paper[start_r][start_c];
				if(paper[i][j]!=start) return false;
			}
		}
		return true;
	}
}
