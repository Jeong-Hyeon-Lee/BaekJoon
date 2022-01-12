/*���� 17086��
 * Ǯ�� ���: BFS�� �̿��Ѵ�. �Ÿ��� ��Ÿ���� dist �迭�� ����� �ѹ��� �̵����� �� �� �ִٸ� �Ÿ��� +1�� �����Ѵ�.
 * ������� ��: ó���� �� ĭ ������ �Ÿ��� ��� ���ұ ���� ����� �߾���.
 */
package study_21_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x, y;
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
public class BOJ17086_BabyShark2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] box = new int[N][M];
		Queue<Node> q = new LinkedList<>();
		int dist[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st2.nextToken());
				dist[i][j] = N*M;
				if(box[i][j] == 1) {
					q.add(new Node(i, j));
					dist[i][j] = 0;
				}
			}
		}
		
		int max = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1};
			int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
			for(int i=0; i<8; i++) {
				int nx = n.x + dx[i];
				int ny = n.y +dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(dist[nx][ny] > dist[n.x][n.y]+1) {
						dist[nx][ny] = dist[n.x][n.y] + 1;
						q.add(new Node(nx, ny));
						max = Math.max(dist[nx][ny], max);
					}
				}
			}
		}
		System.out.println(max);
	}

}
