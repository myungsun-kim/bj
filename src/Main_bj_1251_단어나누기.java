import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_bj_1251_단어나누기 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_bj_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        char[] input = br.readLine().toCharArray();
        int length = input.length;

        for (int i = 0; i < length - 2; ++i) {
            for (int j = i + 1; j < length - 1; ++j) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k >= 0; --k) {
                    sb.append(input[k]);
                }
                for (int k = j; k > i; --k) {
                    sb.append(input[k]);
                }
                for (int k = length - 1; k > j; --k) {
                    sb.append(input[k]);
                }
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.print(list.get(0));
    }
}
