/*백준 1448번
어려웠던 점: 가장 처음에는 삼중for 문을 이용했다가 메모리 초과가 났고, 필요한 부분만 정보를 저장하는 것으로 풀이를 바꾸었으나 Scanner 사용으로 또 메모리 초과가 났다.
풀이 방법: 빨대의 길이를 정렬해서 길이의 합이 큰 순서대로 삼각형을 만들 수 있다면 break한다. Scanner를 BufferedReader로 바꾸었더니 풀이가 맞았다.*/
package ICPC_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class triangle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //빨대의 개수
		int [] straw = new int[N];
		for(int i=0; i<N; i++)
			straw[i] = Integer.parseInt(br.readLine()); //빨대의 길이 저장
		br.close();
		Arrays.sort(straw); //길이 작은 순 정렬
		
		int sum = -1; //빨대 길이의 합 (삼각형 없으면 -1 그대로)
		
		for(int i=N-1; i>=2; i--) {
			if(straw[i-2]+straw[i-1] > straw[i]) { //삼각형을 만들 수 있다면
				sum = straw[i-2]+straw[i-1]+straw[i];
				break;
			}
		}
		System.out.print(sum);
			
	}

}
