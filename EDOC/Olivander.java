/* 백준 15366번
 * 배열 정렬하기
 */
package TeamGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Olivander {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] X = new int[N];
		int [] Y = new int[N];
		StringTokenizer stx = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			X[i] = Integer.parseInt(stx.nextToken());
		Arrays.sort(X);
		StringTokenizer sty = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			Y[i] = Integer.parseInt(sty.nextToken());
		Arrays.sort(Y);
		int ok = 0;
		for(int i=0; i<N; i++) {
			if(X[i] <= Y[i])
				continue;
			else
				ok++;
		}

		if(ok != 0)
			System.out.print("NE");
		else
			System.out.print("DA");
		br.close();
	}

}
