package ICPC_1;
import java.util.Scanner;

public class DivideEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.print((double)A/(double)B);
		sc.close();
	}

}
//풀이 방법: 정수 A, B를 입력받으라 했으니 scanner을 이용해 int형으로 입력을 받고, 출력은 소수로 해야 하므로 A, B를 double형으로 만들어 준 후 나누었다.