package Study_21_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		long count = 0;
		for(int i=0; i<N; i++) {
			if(A[i] > B) {
				if(((A[i]-B)%C) == 0)
					count += (1 + (A[i]-B)/C);
				else
					count += (2 + (A[i]-B)/C);
			}
			else
				count ++;
		}
		System.out.print(count);
		br.close();
	}

}
