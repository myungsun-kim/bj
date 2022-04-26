import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_17478_재귀함수가뭔가요 {
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_17478.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		br.close();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n');
		question(0);
		System.out.print(sb.toString());
	}
	static void question(int count) {
		if(count>n) return;
		if(count==n) {
			out(count);
			sb.append("\"재귀함수가 뭔가요?\"").append('\n');
			out(count);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append('\n');
			answer(count);
		}else {		
			out(count);
			sb.append("\"재귀함수가 뭔가요?\"").append('\n');
			out(count);
			sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append('\n');
			out(count);
			sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append('\n');
			out(count);
			sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append('\n');
		}
		question(count+1);
	}
	
	static void answer(int count) {
		if(count<0) return;
		out(count);
		sb.append("라고 답변하였지.").append('\n');
		answer(count-1);
	}
	
	static void out(int count) {
		for(int i=count;i>0;i--) {
			sb.append("____");
		}
	}
}
