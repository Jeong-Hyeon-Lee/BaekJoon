package ICPC_1;
//백준 1547번
import java.util.Scanner;

public class CupBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int cup[] = {1, 2, 3};
		int M = sc.nextInt(); //M은 50이하 자연수
		for(int i=0; i<M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			//X, Y는 1 또는 2 또는 3, 둘이 같을 수도 있음
			
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
