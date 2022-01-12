/* ���� 11048��
 * Ǯ�� ���: ������ �� ���� ���� ��� ���ϰ� ����� �迭�� �����ؼ� �ٽ� �̿��� ���� ���ߴ�.
 * ������� ��: ó���� ���� �迭�� �ڵ����� 0���� �ʱ�ȭ �Ǵ� �� �𸣰� ���� ���ٰ� ���� �� ������ ������ ���� �κ���
 * ���� ���α׷����߾��µ�, �˰� ���� �� �ʿ䰡 ������.
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
		int [][] candy = new int[N+1][M+1]; //���� �迭 �ڵ����� 0���� �ʱ�ȭ
		
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
