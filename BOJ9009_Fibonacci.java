/* 백준 9009번
 * 
 * 풀이 방법: 피보나치 수들을 담은 ArrayList를 만들고 입력된 값보다 작은 값 중 가장 큰 값부터
 * 합을 만드는 수로 해 최소수의 피보나치 수의 합으로 입력된 값을 만들 수 있게 한다.
 * 수를 하나 구하면 입력된 값에서 수를 뺀 값과 피보나치 수를 비교해 다음 수를 구한다.
 * 합을 만드는 수는 addList라는 ArrayList에 넣었다가 정렬해서 출력한다.
 * 
 * 어려웠던 점: 처음에 할 때는 출력값에 0까지 출력되게 했었다. 최소수의 피보나치 수의 합을 구하는 것이므로
 * addList를 구할 때 0은 빼도 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ9009_Fibonacci {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int [] n = new int[T];
		for(int i=0; i<T; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		
		ArrayList<Integer> fibonacci = new ArrayList<>();
		fibonacci.add(0);
		fibonacci.add(1);
		int k = 2;
		while(true){
			fibonacci.add(fibonacci.get(k-2) + fibonacci.get(k-1));
			if(fibonacci.get(k)>1000000000)
				break;
			k++;
		}
		
		for(int i=0; i<T; i++) {
			int f = n[i];
			ArrayList<Integer> addList = new ArrayList<>();
			for(int j=fibonacci.size()-1; j>0; j--) {
				if(fibonacci.get(j) > f)
					continue;
				else {
					addList.add(fibonacci.get(j));
					f -= fibonacci.get(j);
				}
			}
			addList.sort(null);
			for(int j=0; j<addList.size(); j++)
				System.out.print(addList.get(j) + " ");
			System.out.println();
		}
		
		
	}

}
