import java.io.*;

// 벼락치기 공부법: 30분간 공부한 후 휴식을 취한 후 다시 30분 공부를 시작
// 한 챕터를 모두 공부하는 즉시 다음 챕터 공부 시작. 30분이 지나면 공부하던 챕터는 덮고 넘어감
public class Main_bj_b1_23739_벼락치기 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_23739.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0; //절반 이상 공부한 챕터의 개수
		int cur = 30; //현재 공부한 시간. 30분이 되면 초기화
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(cur-tmp>=0) { //모두 공부할 수 있다면
				if(cur==tmp) cur=30;
				else cur-=tmp;
				count++;
			}else { //현재 챕터를 공부하는 시간이 남아있는 시간보다 큼
				if(cur>=tmp/2+tmp%2) {
					count++; //절반 이상 공부했다면
				}
				cur=30; //공부하는 시간 초기화
			}
		}
		br.close();
		System.out.print(count);
	}
}
