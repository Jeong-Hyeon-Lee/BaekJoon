/*백준 21316번
 * 풀이 방법: 이차원 배열을 이용해 행렬 형태로 연결된 별들을 저장한다. 스피카는 세 개의 별과 연결되어 있고, 그 세 개의 별은 각각 한 개, 두 개, 세 개의 별과 연결되어 있으므로 for문을 이용해 그런 별을 찾는다.
 * 어려웠던 점: 풀이 방향은 맞았지만 int k=0을 안쪽 for문 안쪽에 넣어서 값이 커져야 하는데 자꾸 초기화되게 만드는 실수를 했다. 앞으로는 이런 실수를 하지 않도록 해야겠다
 */
package ICPC_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21316_Spica {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] star = new int[13][13];
		for(int i=0; i<12; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			star[x][y] = 1;
			star[y][x] = 1;
		}
		int [] linkcount = new int[13];
		for(int i=1; i<13; i++)
			for(int j=1; j<13; j++)
				if(star[i][j] == 1)
					linkcount[i]++;
		int [][] spicalink = new int[13][3];
		for(int i=1; i<13; i++) {
			if(linkcount[i] == 3) {
				int k=0; //이거 밑에 넣어서 자꾸 초기화됐다. 이런 실수 이제 하지 말자..
				for(int j=1; j<13; j++) {
					if(star[i][j] == 1) {
						spicalink[i][k] = j;
						k++;
					}
				}
				if(linkcount[spicalink[i][0]]+linkcount[spicalink[i][1]]+linkcount[spicalink[i][2]] == 6)
					System.out.print(i);
			}
		}
		br.close();
	}

}
