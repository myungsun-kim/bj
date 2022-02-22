import java.io.*;
import java.util.*;
// 5를 6으로, 6을 5로 잘못 볼 수 있음
// 두 수가 주어졌을 때 두 수의 가능한 합 중 최솟값과 최댓값을 출력
public class Main_bj_2864_5와6의차이 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2864.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] num = new int[4];
		for(int i=0;i<2;i++) {
			String tmp = st.nextToken().replace('6', '5'); //6을 5로
			num[2*i] = Integer.parseInt(tmp);
			tmp = tmp.replace('5', '6'); //5를 6으로
			num[2*i+1] = Integer.parseInt(tmp);
		}
		int min = num[0]+num[2];
		int max = num[1]+num[3];

		br.close();
		System.out.println(min+" "+max);
	}
}
