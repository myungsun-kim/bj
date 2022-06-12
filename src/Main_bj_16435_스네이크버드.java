import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스네이크버드는 자신의 길이보다 작거나 같은 높이의 과일들을 먹을 수 있음
// 과일을 하나 먹으면 길이가 1만큼 늘어남
public class Main_bj_16435_스네이크버드 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_16435.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //과일의 개수
		int snake = Integer.parseInt(st.nextToken()); //뱀의 길이
		int[] fruit = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) fruit[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(fruit);
		for(int i=0;i<n;i++) {
			if(fruit[i]>snake) break; //더 이상 뱀이 과일을 먹지 못함
			++snake;
		}
		br.close();
		System.out.print(snake);
	}
}
