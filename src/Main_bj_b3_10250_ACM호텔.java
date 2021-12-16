import java.io.*;
import java.util.*;

public class Main_bj_b3_10250_ACM호텔 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_10250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());//테스트케이스
		StringTokenizer st;
		int h, w, n, cnt;
		for(int tc=0;tc<t;tc++) {			
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());//층의 개수
			w = Integer.parseInt(st.nextToken());//한 층에 있는 방의 개수
			n = Integer.parseInt(st.nextToken());//n번째로 도착한 손님
			cnt=0;
			for(int i=1;i<=w;i++) {
				for(int j=1;j<=h;j++) {
					cnt++;
					if(cnt==n) {
						if(i<10) {							
							System.out.println(j+"0"+i);
							break;
						}else {
							System.out.println(j+""+i);
							break;
						}
					}
				}
				if(cnt==n)break;
			}
		}
		br.close();
	}
}
