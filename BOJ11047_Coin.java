/*
 백준 11047번
 풀이 방법: 동전의 가치가 큰 순으로 탐색하며 K원 보다 작으면 그 동전이 몇 개 있을 때까지 K보다 작은지 찾는다.
 그 수를 count에 더해주고 더한 만큼의 동전의 가치를 K에서 빼준다. 이 과정을 계속 반복해 K가 0이 될 때까지 하고
 count를 출력한다.
 어려웠던 점: 없었다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047_Coin {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(K < coin[i])
				continue;
			else {
				int c=0;
				do {
					c++;
					K -= coin[i];
				} while(K >= coin[i]);
				count += c;
			}
		}
		
		System.out.print(count);
		
	}

}
