package study_21_11;

/*백준 19539번
 * 풀이 방법: 1만큼 성장시키는 물뿌리개와 2만큼 성장시키는 물뿌리개를 동시에 사용하므로 나무의 높이의 합은 3의 배수이다.
 * 또, 나무의 높이가 홀수이면 반드시 1만큼 성장시키는 물뿌리개를 사용한 것이므로 1만큼 성장시키는 물뿌리개의 최소 개수는 높이가 홀수인 나무의 개수이다.
 * 조건을 사용해 답을 출력한다.
 * 어려웠던 점: 딱히 없었다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539_AppleTree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] h = new int[N]; //나무의 높이
		int sum = 0;
		int odd = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			sum += h[i];
			if(h[i]%2 == 1)
				odd++;
		}
		if(sum%3==0 && sum/3 >= odd )
			System.out.println("YES");
		else
			System.out.println("NO");
		br.close();
		
	}

}
