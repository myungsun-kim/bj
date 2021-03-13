

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] sw = new int[size];
		for(int i=0;i<size;i++) {
			sw[i] = Integer.parseInt(tmp[i]);
		}
		
		int stdCount = Integer.parseInt(br.readLine());
		int[][] std = new int[stdCount][2];
		
		
		for(int i=0;i<stdCount;i++) { //학생의 성별과 번호를 저장하는 배열
			tmp = br.readLine().split(" ");
			for(int j=0;j<2;j++) {
				std[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		
		
		for(int i=0;i<stdCount;i++) {
				int num = std[i][1]; //학생이 받은 번호
				if(std[i][0]==1) {//성별이 남성인 경우
					for(int k=0;k<sw.length;k++) {
						if((k+1)%num == 0) {
							sw[k] = (sw[k]==0?1:0);
						}
					}
				}else {//성별이 여성인 경우. 인덱스는 num-1
					if(num-1>=0 && num-1<sw.length) {
						sw[num-1] = (sw[num-1]==0)?1:0;
						for(int k=1;k<sw.length;k++) {
							if((num-1-k)<0 || (num-1+k)>=sw.length) {
								break;//범위 확인
							}else if(sw[num-1-k]==(sw[num-1+k])){
								sw[num-1-k] = (sw[num-1-k]==0?1:0);
								sw[num-1+k] = (sw[num-1+k]==0?1:0);
							}else {
								break;
							}
						}
					}
					
				}
			}
		for(int i=0;i<sw.length;i++) {
			sb.append(sw[i]).append(" ");
			if(i>=19 && (i+1)%20==0) {
				sb.append("\n");
			}

		}
		br.close();
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
