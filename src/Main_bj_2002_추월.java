import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main_bj_2002_추월 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_2002.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		Queue<String> queue = new LinkedList<>();
		for(int i=0;i<n;++i) queue.add(br.readLine());
		for(int i=0;i<n;++i) {
			String input = br.readLine();
			if(!input.equals(queue.peek())) {
				queue.remove(input);
				++count;
			}else {
				queue.poll();
			}
		}
		System.out.print(count);
	}
}
