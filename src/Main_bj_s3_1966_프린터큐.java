import java.io.*;
import java.util.*;
//중요도가 낮은 순으로 인쇄
public class Main_bj_s3_1966_프린터큐 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1966.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N,M,cnt,input;
		boolean chk;
		final int imp=9;//중요도는 1-9까지
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			Queue<int[]> q = new LinkedList<>();//큐 작업
			
			st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());//문서의 개수
			M=Integer.parseInt(st.nextToken());//몇 번째에 문서인지
			int[] important=new int[imp+1];//중요도 저장
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				input = Integer.parseInt(st.nextToken());//현재 문서의 중요도
				q.offer(new int[] {i,input});//현재 순서와 중요도 저장
				important[input]++;//현재 중요도가 몇개인지
			}

			cnt=0;
			chk=false;//해당되는 숫자를 찾았는지 유무
			for(int i=imp;i>=0;i--) {
				while(important[i]>0) {
					int[] tmp = q.poll();
					if(tmp[1]==i) {//현재 중요도
						cnt++;
						important[i]--;
						if(tmp[0]==M) {//뽑아야 할 문서일 경우
							chk=true;
							break;
						}
					}else {
						q.offer(new int[] {tmp[0],tmp[1]});
					}
				}
				if(chk) break;//해당되는 숫자를 찾았을 경우
			}
			sb.append(cnt).append('\n');
		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}
