package ICPC_1;
//น้มุ 10804น๘
import java.util.Scanner;

public class FlippingCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int card[] = new int[20];
		for(int i=0; i<20; i++)
			card[i] = i+1;
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j=0; j<(b-a+1)/2; j++) {
				int temp = card[a+j-1];
				card[a+j-1] = card[b-j-1];
				card[b-j-1] = temp;
			}
		}
		
		for(int i=0; i<20; i++)
			System.out.print(card[i] + " ");
		sc.close();
	}

}
