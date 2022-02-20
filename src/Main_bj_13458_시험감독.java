import java.io.*;
import java.util.*;
// 총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자 수 A[i]
// 감독관은 총감독관과 부감독관으로 두 종류가 있다
// 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수 B명
// 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수 C명
// 각각의 시험장에 총감독관은 1명, 부감독관 여러명이 있을 수 있다
// 각 시험장마다 응시생들을 모두 감시해야 할 때, 필요한 감독관 수의 최솟값을 구하기
public class Main_bj_13458_시험감독 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_13458.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//시험장 수
		int[] A = new int[N];// 각 시험장의 응시자 수
		int[] manage = new int[2]; //각 감독관이 감시할 수 있는 응시자 수
		long supervisor = 0L;//감독관 수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<2;i++) {
			manage[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			supervisor+=1L;//총감독관은 1명
			if(A[i]-manage[0]>0) supervisor+=(A[i]-manage[0])/manage[1]+((A[i]-manage[0])%manage[1]==0?0:1);
		}
		
		br.close();
		System.out.print(supervisor);
	}
}
