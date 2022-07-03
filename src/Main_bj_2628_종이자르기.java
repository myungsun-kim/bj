import java.io.*;
import java.util.*;
// 주어진 종이를 자를때 가장 큰 면적의 넓이
public class Main_bj_2628_종이자르기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_2628.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		if(n==0) {
			answer = width*height;
		}else {	
			ArrayList<Integer> width_divide = new ArrayList<>();
			ArrayList<Integer> height_divide = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int direction = Integer.parseInt(st.nextToken());
				int tmp = Integer.parseInt(st.nextToken());
				if(direction==1) {
					width_divide.add(tmp);
				}else {
					height_divide.add(tmp);					
				}
			}
			Collections.sort(width_divide);
			Collections.sort(height_divide);
			width_divide.add(width);					
			height_divide.add(height);
			
			int start_width=0, end_width=0, start_height=0, end_height=0;
			for(int i=0;i<height_divide.size();i++) {	
				end_height = height_divide.get(i);
				int cur_width = end_height-start_height;
				for(int j=0;j<width_divide.size();j++) {
					end_width = width_divide.get(j);
					int cur_height = end_width - start_width;
					int area = cur_width*cur_height;
					if(area>answer) {
						answer=area;
					}
					if(j==width_divide.size()-1) start_width = 0;
					else start_width = end_width; 
				}
				start_height = end_height;
			}
		}
		br.close();
		System.out.print(answer);
	}
}