/* 백준 11048번
 * 풀이 방법: 사탕이 더 많은 쪽을 계속 더하고 결과를 배열에 저장해서 다시 이용해 답을 구했다.
 * 어려웠던 점: 처음에 숫자 배열이 자동으로 0으로 초기화 되는 줄 모르고 가장 윗줄과 왼쪽 줄 사탕의 개수를 더한 부분을
 * 따로 프로그래밍했었는데, 알고 보니 할 필요가 없었다.
 */
package ICPC_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] maze = new int[N+1][M+1];
		int [][] candy = new int[N+1][M+1]; //숫자 배열 자동으로 0으로 초기화
		
		for(int i=1; i<=N; i++) {
			StringTokenizer lineN = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				maze[i][j] = Integer.parseInt(lineN.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				candy[i][j] = maze[i][j] + Math.max(candy[i][j-1], candy[i-1][j]);
			}
		}
		System.out.print(candy[N][M]);
		br.close();
	}

}
