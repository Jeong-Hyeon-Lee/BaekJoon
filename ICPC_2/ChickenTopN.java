package ICPC_2;

import java.util.Arrays;
import java.util.Scanner;

public class ChickenTopN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //ġŲ�� ����
		int [] tastescore = new int[N];
		for(int i=0; i<N; i++)
			tastescore[i] = sc.nextInt(); //ġŲ�� ����
		int k = sc.nextInt(); //���� �ܰ� �����ϰ� �ִ� ȸ����
		for(int i=2; i<=N/k; i*=2)
			for(int j=0; j<N/i; j++)
				Arrays.sort(tastescore, i*j, i*(j+1));
		/*ó������ i<=N ������ �ϰ� for�� �ȿ� if(N/i==k) break;
		 * �� �־����µ� �����ϴٰ� �̰� ���԰� if ���� ����� �ʿ���� �̰� �����̶� �� ���� ��
		 * ���Ƽ� �̰ɷ� �ߴ�. ���� �� ������ �ϰ� �ʹٸ� Scanner ��� BufferedReader�� ����Ѵ�.
		 */
		for(int i=0; i<N; i++)
			System.out.print(tastescore[i] + " ");
		sc.close();
	}

}
