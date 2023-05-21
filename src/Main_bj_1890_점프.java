import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1890_점프 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_bj_1890.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);
            for (int j = 0; j < n; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int next = arr[i][j];
                if (next == 0)
                    continue;
                if (i + next < n)
                    dp[i + next][j] += dp[i][j];
                if (j + next < n)
                    dp[i][j + next] += dp[i][j];
            }
        }

        System.out.print(dp[n - 1][n - 1]);

    }
}
