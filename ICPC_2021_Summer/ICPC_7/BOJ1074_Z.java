/*백준 1074
 * 풀이방법: 4개의 부분으로 나눠서 r행 c열이 어디있는지에 따라 칸 개수를 더해주고 계속 나누어 더한다.
 * 어려웠던 점: 범위를 좁혀가며 더해야 하는데 더하는 식을 처음에 처음 상황에만 적용되는 식으로 적어서 틀렸다.
 * 또, x, y를 행/열을 맞추기 위해 집어넣은 것인데 좌표평면과 헷갈려서 x, y를 바꿔썼다. r행 c열이므로 행과 열이 당연하다!
 */
package ICPC_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int count=0;
		int x=0; int y=0;
		
		while(N>0) {
			int n = (int)Math.pow(2, N);
			if(r>=(n/2)+x && c>=(n/2)+y) { //오른쪽 아래
				count += (n*n)/2 + (n*n)/4;
				x+=n/2; y+=n/2;
			}
			else if(r>=(n/2)+x && c<(n/2)+y) { //왼쪽 아래
				count += (n*n)/2;
				x+=n/2;
			}
			else if(r<(n/2)+x && c>=(n/2)+y) { //오른쪽 위
				count += (n*n)/4;
				y+=n/2;
			}
			//왼쪽 위는 쓸 필요 없음
			N--;
		}
		System.out.print(count);
		br.close();
	}

}
