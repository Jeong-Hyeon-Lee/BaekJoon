package ICPC_1;
//���� 1547��
import java.util.Scanner;

public class CupBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int cup[] = {1, 2, 3};
		int M = sc.nextInt(); //M�� 50���� �ڿ���
		for(int i=0; i<M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			//X, Y�� 1 �Ǵ� 2 �Ǵ� 3, ���� ���� ���� ����
			
			int temp = cup[X-1];
			cup[X-1] = cup[Y-1];
			cup[Y-1] = temp;
		}
		for(int i=0; i<cup.length; i++) {
			if(cup[i]==1)
				System.out.print(i+1);
		}
		sc.close();
	}

}
