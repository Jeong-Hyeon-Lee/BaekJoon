/*���� 13305��
 * Ǯ�̹��: �⸧ ������ �� �� �����Ұ� ���� ������ ���缭 �����Ѵ�. for���� �̿��� ��� �����ҿ��� ���� ������
 * ArrayList�� ������ �� ����, ����� ������ ������ �Ÿ��� ���ϰ� �ش� �������� �⸧ ���ݿ� ���� ����� ���Ѵ�.
 * ������� ��: ó���� Ǯ�̹����� �°� �߾��µ� �⸧ ���ݰ� �Ÿ��� ���ϸ� ���ڰ� Ŀ���� ���� ��� ���ؼ� int������ ����� ���ߴٰ� Ʋ�ȴ�. ������ ������ �� �������!
 */
package ICPC_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13305 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] distance = new int[N-1];
		int [] price = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) 
			distance[i] = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			price[i] = Integer.parseInt(st2.nextToken());
		
		ArrayList<Integer> stop = new ArrayList<>();
		stop.add(0);
		for(int i=1; i<N; i++) {
			if(price[i] < price[stop.get(stop.size()-1)]) {
				stop.add(i);
			}
		}
		stop.add(N-1);
		
		long cost = 0;
		for(int i=0; i<stop.size()-1; i++) {
			int dis=0;
			for(int j=stop.get(i); j<stop.get(i+1); j++)
				dis += distance[j];
			cost += (long)price[stop.get(i)] * (long)dis;
		}
		System.out.print(cost);
		br.close();
	}

}
