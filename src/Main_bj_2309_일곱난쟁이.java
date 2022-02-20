import java.io.*;
import java.util.*;
// 아홉명의 난쟁이 중 일곱난쟁이를 찾는다
// 일곱난쟁이의 키의 합은 100
// 아홉명의 난쟁이의 키의 합-일곱명의 난쟁이가 아닌 난쟁이 두명의 키의 합=100
public class Main_bj_2309_일곱난쟁이 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2309.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int total=9;
		int[] arr = new int[total];
		int sum = 0;
		
		for(int i=0;i<total;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		
		boolean check=false;//일곱난쟁이가 아닌 난쟁이들을 찾았는지
		
		for(int i=0;i<total;i++) {//일곱난쟁이가 아닌 난쟁이 둘을 찾는다
			for(int j=0;j<total;j++) {
				if(i!=j && arr[i]+arr[j]==sum-100) {
					check=true;
				}
				if(check) {
					for(int k=0;k<total;k++) {
						if(k!=i && k!=j) sb.append(arr[k]).append('\n');
					}
					break;
				}
			}
			if(check) break;
		}
		br.close();
		System.out.print(sb.toString());
	}
	
}
