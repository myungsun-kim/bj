import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 아홉명의 난쟁이 중 일곱난쟁이를 찾는다
// 일곱난쟁이의 키의 합은 100
// 아홉명의 난쟁이의 키의 합-일곱명의 난쟁이가 아닌 난쟁이 두명의 키의 합=100
public class Main_bj_2309_일곱난쟁이 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static final int count = 9;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2309.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[count];
		int sum = 0;
		
		for(int i=0;i<count;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		
		boolean check=false;//일곱난쟁이가 아닌 난쟁이들을 찾았는지
		
		for(int i=0;i<count;i++) {//일곱난쟁이가 아닌 난쟁이 둘을 찾는다
			for(int j=i+1;j<count;j++) {
				if(sum-arr[i]-arr[j]==100) {
					print(i,j);
					check=true;
					break;
				}
			}
			if(check) break;
		}
		br.close();
		System.out.print(sb.toString());
	}
	
	static void print(int idx1, int idx2) {
		for(int i=0;i<count;i++) {
			if(i==idx1 || i==idx2) continue;
			sb.append(arr[i]).append('\n');
		}
	}
}
