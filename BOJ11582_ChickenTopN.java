/* 백준 11582번
 * 
 * 풀이 방법: 주어진 k를 통해 어디까지 정렬되었는지 파악해 구간별로 치킨집의 맛의 수치를 정렬한다.
 * 
 * 어려웠던 점: 처음에는 이중 for문을 사용하여 현재 단계까지 순서대로 맛의 수치를 정렬했는데
 * 그렇게 할 필요 없이 현재 단계가 어디까지 정렬된 상태인지를 이용하면 된다는 사실을 꺠달았다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11582_ChickenTopN {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] chicken = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			chicken[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		
		int h = N/k;
		for(int j=0; j<N/h; j++)
			Arrays.sort(chicken, h*j, h*j+h);
		
		
		/* 처음에 했던 방법
		 for(int i=2; i<=N/k; i*=2) {
			for(int j=0; j<N/i; j++)
				Arrays.sort(chicken, i*j, i*j+i);
		}*/
		
		for(int i=0; i<N; i++)
			System.out.print(chicken[i] + " ");
		
		br.close();
	}

}
