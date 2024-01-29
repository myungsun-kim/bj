import java.io.*;
import java.util.*;
// 기타에서 n개의 줄이 끊어졌고, 새로운 줄을 사거나 교체해야 한다. 6줄 패키지 또는 낱개로 살 수있다
// 끊어진 기타줄의 개수 n과 기타줄 브랜드 m개가 주어지고 각각의 브랜드에서 파는 기타줄 6개 패키지의 가격과 낱개의 가격이 주어질때
// 적어도 n개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램 작성
// 낱개로만 살 때, 패키지로만 살 때, 패키지+낱개로 살 때 가격 비교
public class Main_bj_1049_기타줄 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1049.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //끊어진 기타줄의 개수
		int m = Integer.parseInt(st.nextToken()); //브랜드의 개수

		int packPrice = Integer.MAX_VALUE; //가장 저렴한 패키지의 가격
		int piecePrice = Integer.MAX_VALUE; //가장 저렴한 낱개의 가격
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int tmp = Integer.parseInt(st.nextToken()); //패키지의 가격
			if(packPrice>tmp) packPrice=tmp;
			tmp = Integer.parseInt(st.nextToken()); //기타줄의 가격
			if(piecePrice>tmp) piecePrice=tmp;
		}
		int answer = Math.min(piecePrice*n, Math.min(packPrice*(n/6+(n%6==0?0:1)), packPrice*(n/6)+piecePrice*(n%6)));
		System.out.print(answer);
		br.close();
	}
}
