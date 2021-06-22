import java.io.*;
import java.util.*;
// 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다
// 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수 찾기
// 단, 회의는 한 번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다
// 이차원 배열에 회의가 시작하는 시간과 끝나는 시간 저장
// 종료 시간을 기준으로 오름차순 정렬, 종료 시간이 같다면 시작 시간 고려
public class Main_bj_s2_1931_회의실배정 {
	public static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public int compareTo(Meeting o) {
			int dif= Integer.compare(this.end, o.end);
			return dif==0?Integer.compare(this.start, o.start):dif;
		}
	}
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //회의의 수
		ArrayList<Meeting> list = new ArrayList<>();
		for(int n=0;n<N;n++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			list.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		Meeting tmp = list.get(0);
		int answer=1;//회의실의 개수
		
		for(int i=1;i<list.size();i++) {
			if(tmp.getEnd()>list.get(i).start) continue; //아직 회의실을 사용하고 있음
			tmp=list.get(i);
			answer++;
		}
		br.close();
		System.out.print(answer);
	}
}
