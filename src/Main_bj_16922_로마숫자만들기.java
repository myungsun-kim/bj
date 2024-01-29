import java.io.*;
import java.util.*;
//로마 숫자 I:1 V:5 X:10 L:50을 의미하고 이 문제에서 다른 문자는 사용X
//문자열이 나타내는 값=각 문자가 의미하는 수를 모두 합한 값.순서는 신경 쓰지 않음
//로마 숫자 N개를 사용해서 만들 수 있는 서로 다른 수의 개수를 구해보자
public class Main_bj_16922_로마숫자만들기 {
	static int N,count;
	static boolean[] chk=new boolean[1001];
	static int[] arr;
	static int[] roma= {1,5,10,50};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16922.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		count=0;
		comb(0,0);
		br.close();
		System.out.print(count);
	}
	//4개 중 N개를 뽑는 경우
	
	static void comb(int cnt,int idx) {
		if(cnt==N) {
			int answer=0;
			for(int i=0;i<N;i++) {
				answer+=arr[i];
			}
			if(!chk[answer]) {
				chk[answer]=true;
				count++;
			}
			return;
		}
		
		for(int i=idx;i<4;i++) {
			arr[cnt]=roma[i];
			comb(cnt+1,i);
		}
	}
}
