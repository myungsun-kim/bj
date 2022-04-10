import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인공지능 오븐은 오븐구이가  끝나는 시간을 초 단위로 자동적으로 계산
// 훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 초 단위로 주어졌을 때, 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성
// 디지털 시계는 23시 59분 59초에서 1초가 지나면 0시 0분 0초가 됨
public class Main_bj_2530_인공지능시계 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2530.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int[] current = new int[3];
		int[] complete = new int[3];
		
		current[0] = Integer.parseInt(st.nextToken()); //시
		current[1] = Integer.parseInt(st.nextToken()); //분
		current[2] = Integer.parseInt(st.nextToken()); //초
		int d = Integer.parseInt(br.readLine()); //오븐구이를 하는 데 필요한 시간
		
		//60초 1분 3600초 1시간
		if(d>=3600) {
			complete[0] = d/3600;
			d%=3600;
		}
		if(d>=60) {
			complete[1] = d/60;
			d%=60;			
		}
		complete[2] = d;
		
		if(complete[2]+current[2]>=60) {
			complete[1]+=(complete[2]+current[2])/60;
			complete[2]=(complete[2]+current[2])%60;
		}else {
			complete[2]+=current[2];
		}
		if(complete[1]+current[1]>=60) {
			complete[0]+=(complete[1]+current[1])/60;
			complete[1]=(complete[1]+current[1])%60;
		}else {
			complete[1]+=current[1];			
		}
		if(complete[0]+current[0]>=24) {
			complete[0]=(complete[0]+current[0])%24;
		}else {			
			complete[0]+=current[0];			
		}
		
		for(int i=0;i<complete.length;i++) {
			sb.append(complete[i]);
			if(i!=complete.length-1) sb.append(' ');
		}
		br.close();
		System.out.print(sb.toString());
	}
}
