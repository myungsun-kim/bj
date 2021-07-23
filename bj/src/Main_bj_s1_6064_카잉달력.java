import java.io.*;
import java.util.*;

// 카잉 달력은 M과 N보다 작거나 같은 두 개의 자연수 x,y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다
// 이 세상의 시초에 해당하는 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다
// <x:y>의 다음 해를 표현한 것은 <x':y'> 인데 만일 x<M이면 x'=x+1이고 그렇지 않으면 x'=1, y<N이면 y'=y+1이고 그렇지 않으면 y'=1
// <M:N>은 그들 달력의 마지막 해
// 예를 들어 M=10이고 N=12이면 첫 번째 해는 <1:1>이고 11번째 해는 <1:11>. 13번째 해는 <3:1>. 60번째 해는 <10:12>
// 네 개의 정수 M,N,x,y가 주어질 때 <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라
public class Main_bj_s1_6064_카잉달력 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_6064.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //테스트 데이터의 수
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			sb.append(check(M,N,x,y)).append('\n');
		}
		System.out.print(sb.toString());
	}
	
	static int check(int M, int N, int x, int y) {
		if(x==1 && y==1) return 1;
		for(int i=0;i<=N;i++) {
			if(y==((M*i+x)%N==0?N:(M*i+x)%N)) {
				return M*i+x;
			}
		}
		return -1;
	}
}
