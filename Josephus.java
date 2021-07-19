package ICPC_1;
//백준 1158번
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
	
		ArrayList<Integer> order = new ArrayList<>();//출력할 순열
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<N; i++)
			q.add(i+1);
		
		while(!q.isEmpty()) {
			for(int i=0; i<K; i++) {
				if((i+1) == K)
					order.add(q.poll());
				else
					q.add(q.poll());
			}
		}
		
		System.out.print("<");
		for(int j=0; j<N-1; j++)
			System.out.print(order.get(j) + ", ");
		System.out.print(order.get(N-1) + ">");
	}

}
