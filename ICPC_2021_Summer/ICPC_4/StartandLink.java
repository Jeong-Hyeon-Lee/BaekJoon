/*백준 14889번
 * 어려웠던 점: 사람들을 두 그룹으로 나누는데 조합을 이용했는데, 조합을 처음 구현해봐서 어떻게 하는지 검색을 해야 했다.
 */
package ICPC_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartandLink {
	
	static int N, min = Integer.MAX_VALUE;
	static int [][] S; //팀에 더해지는 능력치
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
				visit[i] = true; //start 팀
				maketeam(i+1, N, r-1);
				visit[i] = false; //link 팀
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
		return Math.abs(start-link); //팀 능력치 차이 반환
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //사람 수, 4이상 20이하 짝수
		S = new int [N][N]; //팀에 더해지는 능력치
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
