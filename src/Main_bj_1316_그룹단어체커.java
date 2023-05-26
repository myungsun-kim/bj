import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_bj_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1316.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; ++i) {
            char[] input = br.readLine().toCharArray();
            boolean[] visited = new boolean[26]; // 이전에 나온 문자인지 아닌지
            boolean check = true; // 그룹문자인지 아닌지
            for (int j = 0; j < input.length; ++j) {
                int cur = input[j] - 'a';
                if (j != 0 && visited[cur] && input[j - 1] != input[j]) {
                    check = false;
                    break;
                } else {
                    visited[cur] = true;
                }
            }
            if (check)
                ++count;
        }
        System.out.print(count);
	}
}
