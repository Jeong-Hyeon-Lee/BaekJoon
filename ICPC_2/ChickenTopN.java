package ICPC_2;

import java.util.Arrays;
import java.util.Scanner;

public class ChickenTopN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //치킨집 개수
		int [] tastescore = new int[N];
		for(int i=0; i<N; i++)
			tastescore[i] = sc.nextInt(); //치킨집 점수
		int k = sc.nextInt(); //현재 단계 진행하고 있는 회원수
		for(int i=2; i<=N/k; i*=2)
			for(int j=0; j<N/i; j++)
				Arrays.sort(tastescore, i*j, i*(j+1));
		/*처음에는 i<=N 까지로 하고 for문 안에 if(N/i==k) break;
		 * 를 넣었었는데 수정하다가 이게 나왔고 if 문을 계산할 필요없는 이게 조금이라도 더 빠를 것
		 * 같아서 이걸로 했다. 물론 더 빠르게 하고 싶다면 Scanner 대신 BufferedReader을 써야한다.
		 */
		for(int i=0; i<N; i++)
			System.out.print(tastescore[i] + " ");
		sc.close();
	}

}
