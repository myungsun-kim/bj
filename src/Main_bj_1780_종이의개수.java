import java.io.*;
import java.util.*;
// NxN 크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1,0,1의 세 값 중 하나가 저장되어 있다. 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려 한다.
// 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다
// 2. 1이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해 1의 과정을 반복한다
// 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램 작성
// N은 3^k의 꼴
public class Main_bj_1780_종이의개수 {
	static int[][] arr;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1780.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cnt = new int[3];//각각 -1, 0, 1로 채워진 종이의 개수 출력
		boolean chk = true; //주어진 종이가 모두 같은 수인 경우
		int init = 0; //처음 종이에 쓰여진 숫자
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==0 && j==0) init=arr[i][j];
				if(chk && arr[i][j]!=init) chk=false; // 주어진 행렬은 다른 숫자로 이루어져 있음
			}
		}
		
		if(chk) {//주어진 행렬이 하나의 숫자로 채워져 있는 경우(한 장의 종이인 경우)
			cnt[++init]++;
		}else {
			recursive(0,0,N);
		}
		
		for(int i=0;i<cnt.length;i++) {
			sb.append(cnt[i]).append('\n');
		}
		System.out.print(sb.toString());
	}
	
	static void recursive(int start_r, int start_c, int size) {
		// 9개로 쪼갬
		int range=size/3;
		for(int i=start_r;i<=start_r+2*range;i+=range) {
			for(int j=start_c;j<=start_c+2*range;j+=range) {
				if(check(i, j, range)) cnt[arr[i][j]+1]++;//해당 종이 개수 증가
				else recursive(i, j, range);
			}
		}
	}
	
	static boolean check(int start_r, int start_c, int size) { //해당 행렬이 하나의 종이인지 아니인지 체크
		int init = arr[start_r][start_c];//처음 종이에 쓰여진 숫자
		for(int i=start_r;i<start_r+size;i++) {
			for(int j=start_c;j<start_c+size;j++) {
				if(arr[i][j]!=init) return false; //해당 행렬이 하나의 종이가 아님
			}
		}
		return true;
	}
}
