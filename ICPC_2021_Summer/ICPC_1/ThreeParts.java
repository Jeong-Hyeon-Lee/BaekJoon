//백준 2993번
/*풀이방법: 단어를 scanner을 이용해 string으로 입력받은 후 char 배열에 글자를 하나씩 저장해 배열의 순서를 바꾸어 글자를 뒤집을 수 있게 했다.
 글자를 뒤집는 부분을 reverse 함수로 따로 정의해서 반복되는 부분을 간단하게 만들었고,
 만들 수 있는 글자를 전부 ArrayList에 저장해 그 중 사전순으로 가장 앞서는 단어를 출력했다.
 */
package ICPC_1;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeParts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String word = sc.next(); //알파벳 소문자, 길이는 3이상 50이하
		int N = word.length();
		char[] arrWord = new char[N];
		sc.close();
		
		ArrayList<String> newword = new ArrayList<>();
		
		int a, b;
		for(a=0; a<N-2; a++) {
			for(b=a+1; b<N-1; b++) {
				
				for(int i=0; i<N; i++)
					arrWord[i] = word.charAt(i);
				//이 부분을 (a, b 반복하는)for문 바깥에 둬서 반복 매회 할 때마다 arrWord가 원래로 초기화가 안 된 상태로 다시 reverse 되어서 계속 틀렸다!
				//다음부터는 주의하기
				reverse(0,a, arrWord);
				reverse(a+1, b, arrWord);
				reverse(b+1, N-1, arrWord);
				
				
				String nw = new String(arrWord);
				newword.add(nw);
			}
		}
		
		String minword = newword.get(0);
		for(int i=1; i<newword.size(); i++) {
			if(newword.get(i).compareTo(minword) < 0)
				minword = newword.get(i);
		}

		System.out.println(minword);
	}
	
	static void reverse(int a, int b, char[] arr) {
		for(int i=0; i<(b-a+1)/2; i++) {
			char temp = arr[a+i];
			arr[a+i] = arr[b-i];
			arr[b-i] = temp;
		}
	}
}