import java.io.*;
import java.util.*;
// 어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다.
// 편의장 일직선을 수평 방향으로 두고, 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려 한다
// 인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다. 도로 길이의 단위는 km 사용
// 처음 출발할 때 자동차에는 기름이 없어서 주유소에 기름을 넣고 출발. 기름통의 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다
// 도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용
// 각 도시에는 단 하나의 주유소가 있으며 도시 마다 주유소의 리터당 가격은 다를 수 있음. 단위는 원
// 각 도시의 주유소 기름 가격과, 각 도시를 연결하는 도로 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램 작성
public class Main_bj_s4_13305_주유소 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_13305.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시의 개수
		int[] distance = new int[n-1]; //distance[i]=i도시부터 i+1도시까지의 거리
		int[] price = new int[n]; //i도시의 주유소 비용
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n-1;i++) distance[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) price[i] = Integer.parseInt(st.nextToken());
		
		long total = 0;//비용
		long minPrice = price[0]; //최소 비용
		
		for(int i=0;i<n-1;i++) {
			if(minPrice>price[i]) minPrice = price[i];
			total+=minPrice*distance[i];
		}
		
		br.close();
		System.out.print(total);
	}
}
