import java.io.*;
import java.util.*;
// 다음과 같이 정의된 수열이 있다.
// D[1] = A
// D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
// 1<=a<=9999 1<=p<=5
// 반복되는 부분을 제외했을때 수열에 남게되는 수의 개수
public class Main_bj_2331_반복수열 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2331.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(a);
		int d = a; //d[0]의 값
		int size = 0;//반복되는 부분을 제외했을때 수열에 남게되는 수의 개수
		boolean check = false;
		while(true) {
			int tmp = cal(d,p);
			for(int i=0;i<list.size();i++) {
				if(list.get(i)==tmp) {
					check = true; //중복되는 수 있음
					size = i;
				}
			}
			if(check) break;
			list.add(tmp);
			d = tmp;
		}
		br.close();
		System.out.print(size);
		
	}
	
	// D[n-1]의 각 자리의 숫자를 p번 곱한 수들의 합
	static int cal(int num, int p) {
		int d=0;
		while(num>0) {
			int tmp = num%10;
			d+=Math.pow(tmp, p);
			num/=10;
		}
		return d;
	}
}
