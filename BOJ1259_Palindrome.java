package Study_21_09;

import java.util.Scanner;

public class BOJ1259_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(true) {
			String num = sc.next();
			int check = 0;
			
			if(num.equals("0"))
				break;
			
			int len = num.length();
			for(int i=0; i<len/2; i++) {
				if(num.charAt(i) != num.charAt(len-1-i)) {
					check++;
					break;
				}
			}
			if(check == 0)
				System.out.println("yes");
			else
				System.out.println("no");
		}
		sc.close();
	}

}
