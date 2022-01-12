/*백준 13305번
 * 풀이방법: 기름 가격이 더 싼 주유소가 나올 때마다 멈춰서 주유한다. for문을 이용해 어느 주유소에서 멈출 것인지
 * ArrayList에 저장을 한 다음, 저장된 주유소 사이의 거리를 구하고 해당 주유소의 기름 가격에 곱해 비용을 구한다.
 * 어려웠던 점: 처음에 풀이방향은 맞게 했었는데 기름 가격과 거리를 곱하면 숫자가 커지는 것을 고려 못해서 int형으로 비용을 구했다가 틀렸다. 숫자의 범위를 잘 고려하자!
 */
package ICPC_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13305 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] distance = new int[N-1];
		int [] price = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) 
			distance[i] = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			price[i] = Integer.parseInt(st2.nextToken());
		
		ArrayList<Integer> stop = new ArrayList<>();
		stop.add(0);
		for(int i=1; i<N; i++) {
			if(price[i] < price[stop.get(stop.size()-1)]) {
				stop.add(i);
			}
		}
		stop.add(N-1);
		
		long cost = 0;
		for(int i=0; i<stop.size()-1; i++) {
			int dis=0;
			for(int j=stop.get(i); j<stop.get(i+1); j++)
				dis += distance[j];
			cost += (long)price[stop.get(i)] * (long)dis;
		}
		System.out.print(cost);
		br.close();
	}

}
