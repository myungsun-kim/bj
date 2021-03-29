import java.awt.List;
import java.io.*;
import java.util.*;
//요세푸스 문제:1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, N보다 작거나 같은 양의 정수 K가 주어짐
//이제 순서대로 K번째 사람을 제거하고, 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해나감
//N명의 사람들이 모두 제거될 때까지 계속되며, 원에서 사람들이 제거되는 순서를 (N,K)-요세푸스 순열이라고 함
public class Main_bj_11866_요세푸스문제0 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11866.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] number = new int[N];//기존에 있던 위치
		int[] arr=new int[N];//제거된 순서대로 저장할 배열
		int cnt=0; //제거된 숫자의 개수
		int idx=K-1; //제거된 숫자의 인덱스
		for(int i=0;i<N;i++) {
			number[i]=i+1;
		}
		while(true) {
			System.out.println(number.length);
			System.out.println(N);
			if(cnt==number.length) break;//N개만큼 뽑았으면 반복문 정지
			if(idx>=N) {//인덱스가 범위를 벗어난 경우
				System.out.println(Arrays.toString(number));
				for(int i=0;i<number.length;i++) {//비어있는 자리 없이 앞에서부터 채움
					if(number[i]==0) {
						for(int j=1;j<N;j++) {
							if(i+j>=number.length) break;
							if(number[i+j]!=0) {//뒤에 0이 아닌 수를 찾으면								
								number[i]=number[i+j];
								number[i+j]=0;
								break;
							}
						}
					}
				}
				System.out.println(Arrays.toString(number));
				idx-=N;
				N-=cnt;//N값 갱신
			}
			if(N<K) {//남은 수의 개수가 K보다 작은 경우
				for(int i=0;i<N;i++) {//남은 수를 하나씩 제거
					arr[cnt++]=number[i];
				}
				break;
			}
			arr[cnt++]=number[idx];//제거된 숫자 저장
			number[idx]=0;//숫자 제거
			idx+=K;//인덱스 증가
		}
		
		for(int i=0;i<number.length;i++) {
			if(i==0) {
				sb.append("<").append(arr[i]).append(", ");
			}else if(i==number.length-1) {
				sb.append(arr[i]).append(">");
			}else {				
				sb.append(arr[i]).append(", ");
			}
		}
		System.out.print(sb);
	}
}
