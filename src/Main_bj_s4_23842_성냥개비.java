import java.io.*;
import java.util.*;
// n개의 성냥개비가 주어졌을때 성냥을 모두 사용하여 조건에 만족하는 수식 만들기
// 수식은 ㅁㅁ+ㅁㅁ=ㅁㅁ의 형태. 불가능한 경우 impossible 출력
// +와 =에도 각각 두 개의 성냥개비 필요
public class Main_bj_s4_23842_성냥개비 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_23842.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = {6,2,5,5,4,5,6,3,7,6}; //각 숫자를 만드는데 필요한 성냥개비의 개수
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		
		if(n>20) { // 수식을 만들기 위해 필요한 최소의 성냥 개수
			n-=4; //+,= 수식을 만드는데 필요한 성냥
			for(int i=0;i<100;i++) {
				int tmp1 = n;
				tmp1 -= num[i/10];
				tmp1 -= num[i%10];
				for(int j=0;i+j<100;j++) {
					int tmp2 = tmp1;
					tmp2 -= num[j/10];
					tmp2 -= num[j%10];
					if(tmp2>=4 && tmp2-num[(i+j)/10]-num[(i+j)%10]==0) {
						if(i<10) sb.append(0);
						sb.append(i).append('+');
						if(j<10) sb.append(0);
						sb.append(j).append('=');
						if((i+j)<10) sb.append(0);
						sb.append(i+j);
						check = true;
						break;
					}
				}
				if(check) break;
			}
		}
		br.close();
		if(check) System.out.print(sb.toString());
		else System.out.print("impossible");
		
	}
}
