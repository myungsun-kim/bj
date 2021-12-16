import java.io.*;
import java.util.*;
// N개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1m이며 높이는 다를 수 있다. 
// 이 기둥들을 이용하여 양철로 된 창고를 제작하려 한다. 창고에는 모든 기둥들이 들어간다. 창고의 지붕을 다음과 같이 만든다
// 1. 지붕은 수평 부분과 수직 부분으로 구성되며 모두 연결되어야 한다
// 2. 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다
// 3. 지붕의 수직 구분은 반드시 어떤 기둥의 옆면과 닿아야 한다
// 4. 지붕의 가장자리는 땅에 닿아야 한다
// 5. 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다>지붕의 높이는 높아졌다가 낮아져야함(반복X)
// 위의 조건을 충족한 창고의 최소 면적을 구한다 

public class Main_bj_s2_2304_창고다각형 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2304.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//기둥의 개수
		Pillar[] p = new Pillar[N];//기둥 정보 저장
		int max = 0;//최고 높이
		int cnt = 0;//최고 높이의 기둥 개수
		int area = 0;//면적
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int location = Integer.parseInt(st.nextToken());//위치
			int height = Integer.parseInt(st.nextToken());//높이
			if(max==height) cnt++;//최고 높이 기둥이 여러개일때
			if(max<height) {
				max=height;//최고 높이 저장
				cnt=1;
			}
			p[i]=new Pillar(location, height);
		}
		Arrays.sort(p);
		
		int[] max_location = new int[cnt];//최고 기둥의 위치 저장
		int idx=0;
		for(int i=0;i<N;i++) {
			if(p[i].height==max) max_location[idx++]=p[i].location;//위치 저장
		}
		ArrayList<Pillar> list = new ArrayList<>();//연산에 사용되는 기둥 정보 저장
		int pre_height=0;//이전 높이
		for(int i=0;i<N;i++) {//오르막 연산
			if(pre_height<p[i].height) {
				pre_height = p[i].height;
				list.add(p[i]);
			}
			if(p[i].location==max_location[0]) break;
		}
		list.add(new Pillar(max_location[0], max));
		for(int i=0;i<list.size()-1;i++) {
			area += (list.get(i+1).location-list.get(i).location)*list.get(i).height;
		}
		list.clear();
		
		pre_height=0;
		for(int i=N-1;i>0;i--) {//내리막 연산
			if(pre_height<p[i].height) {
				pre_height = p[i].height;
				list.add(p[i]);
			}
			if(p[i].location==max_location[cnt-1]) break;
		}
		
		for(int i=0;i<list.size()-1;i++) {//가장 높은 기둥들 연산
			area += (list.get(i).location-list.get(i+1).location)*list.get(i).height;
		}
		area+=max*(max_location[cnt-1]-max_location[0]+1);
		
		System.out.print(area);
		
	}
}
class Pillar implements Comparable<Pillar>{
	int location;
	int height;
	
	public Pillar(int location, int height) {
		super();
		this.location = location;
		this.height = height;
	}
	
	@Override
	public int compareTo(Pillar o) {
		return Integer.compare(this.location, o.location);//왼쪽에 있는 것부터 정렬
	}
}
