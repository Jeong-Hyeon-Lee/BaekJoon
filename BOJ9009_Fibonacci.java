/* ���� 9009��
 * 
 * Ǯ�� ���: �Ǻ���ġ ������ ���� ArrayList�� ����� �Էµ� ������ ���� �� �� ���� ū ������
 * ���� ����� ���� �� �ּҼ��� �Ǻ���ġ ���� ������ �Էµ� ���� ���� �� �ְ� �Ѵ�.
 * ���� �ϳ� ���ϸ� �Էµ� ������ ���� �� ���� �Ǻ���ġ ���� ���� ���� ���� ���Ѵ�.
 * ���� ����� ���� addList��� ArrayList�� �־��ٰ� �����ؼ� ����Ѵ�.
 * 
 * ������� ��: ó���� �� ���� ��°��� 0���� ��µǰ� �߾���. �ּҼ��� �Ǻ���ġ ���� ���� ���ϴ� ���̹Ƿ�
 * addList�� ���� �� 0�� ���� �ȴ�.
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
