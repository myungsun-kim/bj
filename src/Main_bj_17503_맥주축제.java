import java.io.*;
import java.util.*;
// n일동안 맥주 축제가 열리고, k종류의 맥주를 제공
// 참가자들은 하루에 맥주 1병만 받을 수 있고, 이전에 받았던 종류의 맥주는 다시 받을 수 없음
// k종류의 맥주에 각각 선호도와 도수 레벨을 매김 
// 마시는 맥주의 도수 레벨이 간 레벨보다 높으면 맥주병이 발병해 기절
// 맥주병에 걸리지 않으면서 자신이 좋아하는 맥주를 많이 마시고 싶어함 > 맥주 n개의 선호도 합이 m이상 되도록
// 조건을 만족하는 간 레벨의 최솟값 출력
// 맥주를 도수 레벨 순으로 정렬
// 우선순위 큐에 선호도 추가. 선호도 합 계산
public class Main_bj_17503_맥주축제{
	static class Beer implements Comparable<Beer>{
		int preference; //선호도
		int alcohol; //도수
		
		public Beer(int preference, int alcohol) {
			super();
			this.preference = preference;
			this.alcohol = alcohol;
		}

		@Override
		public int compareTo(Beer o) {
			// 도수 레벨이 낮을 수록, 선호도가 높을 수록
			int compare = Integer.compare(this.alcohol, o.alcohol);
			if(compare==0) return Integer.compare(o.preference, this.preference);
			return compare;
		}
	}
	
	static Beer[] arr;
	static int n, m, k, answer, sumPre;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_17503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); //축제가 열리는 기간
		m = Integer.parseInt(st.nextToken()); //채워야하는 선호도의 합
		k = Integer.parseInt(st.nextToken()); //마실 수 있는 맥주 종류의 수
		answer = -1;
		sumPre = 0;
		arr = new Beer[k];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i] = new Beer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); 
		}
		Arrays.sort(arr);
		select();
		br.close();
		System.out.print(answer);
	}
	
	static void select() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //선호도를 담을 우선순위 큐
		
        for (int i=0;i<k;i++) {
            pq.add(arr[i].preference); // 우선순위 큐에 맥주의 선호도 값을 추가 (추가하면 선호도가 작은 순으로 정렬됨)
            sumPre += arr[i].preference; // 선호도 누적

            if (pq.size()>n) {
                int minPre = pq.peek() == null ? 0 : pq.poll();
                sumPre -= minPre;
            }

            if (pq.size()==n && sumPre>=m) { // 총 n개의 맥주, 선호도의 합 m 이상
                answer = arr[i].alcohol; // 간 레벨의 최솟값
                return;
            }
        }
	}
}
