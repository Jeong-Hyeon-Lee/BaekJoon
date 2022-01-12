/*���� 14889��
 * ������� ��: ������� �� �׷����� �����µ� ������ �̿��ߴµ�, ������ ó�� �����غ��� ��� �ϴ��� �˻��� �ؾ� �ߴ�.
 */
package ICPC_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartandLink {
	
	static int N, min = Integer.MAX_VALUE;
	static int [][] S; //���� �������� �ɷ�ġ
	static boolean visit[];
	
	static void maketeam(int start, int N, int r) {
		if(r == 0){
			int diff = teamstatus();
			if(min> diff)
				min = diff;
			return;
		}
		for(int i=start; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true; //start ��
				maketeam(i+1, N, r-1);
				visit[i] = false; //link ��
			}
		}
	}
	
	static int teamstatus() {
		int start = 0;
		int link = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visit[i] && visit[j])
					start += S[i][j] + S[j][i];
				else if(!visit[i] && !visit[j])
					link += S[i][j] + S[j][i];
			}
		}
		return Math.abs(start-link); //�� �ɷ�ġ ���� ��ȯ
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //��� ��, 4�̻� 20���� ¦��
		S = new int [N][N]; //���� �������� �ɷ�ġ
		visit = new boolean[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maketeam(0, N, N/2);
		System.out.print(min);
		
	}

}
