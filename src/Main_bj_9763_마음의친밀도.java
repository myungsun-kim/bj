import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_9763_마음의친밀도 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_9763.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];

		for(int i=0;i<n;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); //x
			arr[i][1] = Integer.parseInt(st.nextToken()); //y
			arr[i][2] = Integer.parseInt(st.nextToken()); //z		
		}
		
		for(int i=0;i<n;++i) {
			int sum = 0;
			int min1 = 10000; //최소값
			int min2 = 10000;
			
			for(int j=0;j<n;++j) {	
				if(i!=j) {
					// d12+d23의 합을 구하기에 2번째마을의 값=i를 구함
						int d = Math.abs(arr[j][0]-arr[i][0])
								+Math.abs(arr[j][1]-arr[i][1])
								+Math.abs(arr[j][2]-arr[i][2]);
						
						if(min1>d) {
							min2 = min1;
							min1 = d;
						}else if(min2>d) {
							min2 = d;
						}
				}
			}
			sum = min1+min2;
			if(sum<answer) answer = sum;
		}
		br.close();
		System.out.print(answer);
	}
}
