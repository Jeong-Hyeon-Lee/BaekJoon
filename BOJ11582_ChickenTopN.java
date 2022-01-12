/* ���� 11582��
 * 
 * Ǯ�� ���: �־��� k�� ���� ������ ���ĵǾ����� �ľ��� �������� ġŲ���� ���� ��ġ�� �����Ѵ�.
 * 
 * ������� ��: ó������ ���� for���� ����Ͽ� ���� �ܰ���� ������� ���� ��ġ�� �����ߴµ�
 * �׷��� �� �ʿ� ���� ���� �ܰ谡 ������ ���ĵ� ���������� �̿��ϸ� �ȴٴ� ����� �ƴ޾Ҵ�.
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
		
		
		/* ó���� �ߴ� ���
		 for(int i=2; i<=N/k; i*=2) {
			for(int j=0; j<N/i; j++)
				Arrays.sort(chicken, i*j, i*j+i);
		}*/
		
		for(int i=0; i<N; i++)
			System.out.print(chicken[i] + " ");
		
		br.close();
	}

}
