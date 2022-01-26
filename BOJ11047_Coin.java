/*
 ���� 11047��
 Ǯ�� ���: ������ ��ġ�� ū ������ Ž���ϸ� K�� ���� ������ �� ������ �� �� ���� ������ K���� ������ ã�´�.
 �� ���� count�� �����ְ� ���� ��ŭ�� ������ ��ġ�� K���� ���ش�. �� ������ ��� �ݺ��� K�� 0�� �� ������ �ϰ�
 count�� ����Ѵ�.
 ������� ��: ������.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047_Coin {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(K < coin[i])
				continue;
			else {
				int c=0;
				do {
					c++;
					K -= coin[i];
				} while(K >= coin[i]);
				count += c;
			}
		}
		
		System.out.print(count);
		
	}

}
