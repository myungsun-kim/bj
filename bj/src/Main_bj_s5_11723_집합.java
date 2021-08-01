import java.io.*;
import java.util.*;

//비어있는 공집합 S에 add, remove, check, toggle, all, empty 연산을 수행하는  프로그램
//add x : S에 x를 추가. S에 x가 이미 있는 경우 연산 무시
//remove x : S에 x를 제러. S에 x가 없는 경우 연산 무시
//check x : S에 x가 있으면 1, 없으면 0
//toggle x : S에 x가 있으면 x 제거 ,없으면 x 추가
//all : S를 {1,2,...,20}으로 변경
//empty : S를 공집합으로 바꿈
public class Main_bj_s5_11723_집합 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_11723.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M=Integer.parseInt(br.readLine());//연산의 수
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			String oper=st.nextToken();
			int x = 0;
			if(st.hasMoreTokens()) {		
				x=Integer.parseInt(st.nextToken());
			}
			switch(oper) {
			case "add":
				set.add(x);
				break;
			case "remove":
				if(set.contains(x)) {					
					set.remove(x);
				}
				break;
			case "check":
				if(set.contains(x)) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
				break;
			case "toggle":
				if(set.contains(x)) {
					set.remove(x);
				}else {
					set.add(x);
				}
				break;
			case "all":
				set.clear();
				for(int j=1;j<=20;j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		br.close();
		System.out.print(sb.toString());
	}
}
