import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 1. 첫 번째 수로 양의 정수가 주어짐
// 2. 두 번째 수는 양의 정수 중에서 하나를 선택
// 3. 세 번째부터 이후에 나오는 모든 수는 앞의 앞의 수에서 앞의 수를 빼서 만든다. 
//    예를 들어, 세 번째 수는 첫 번째 수에서 두 번째 수를 뺀 것이고, 
//    네 번째 수는 두 번째 수에서 세 번째 수를 뺀 것
// 	  i>=3 arr[i]=arr[i-2]-arr[i-1]
// 4. 음의 정수가 만들어지면, 이 음의 정수를 버리고 더 이상 수를 만들지 않음
// 두 번째 수는 첫 번째 수보다 작은 양의 정수
public class Main_bj_2635_수이어가기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2635.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max_cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		int[] answer = null;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++) {//i=두번째수
			list.add(n);//첫번째수
			list.add(i);//두번째수
			while(true) {
				int idx=list.size()-1;//현재 리스트의 마지막 인덱스
				int next=list.get(idx-1)-list.get(idx);//다음 수
				if(next<0) {//음의 정수가 생긴다면
					if(max_cnt<list.size()) {//현재 생긴 수가 가장 크다면 저장
						max_cnt=list.size();
						answer=new int[list.size()];
						for(int j=0;j<list.size();j++) {
							answer[j]=list.get(j);
						}
					}
					list.clear();
					break;
				}
				list.add(next);
			}
		}
		
		sb.append(max_cnt).append('\n');
		for(int i=0;i<answer.length;i++) {
			sb.append(answer[i]).append(' ');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
