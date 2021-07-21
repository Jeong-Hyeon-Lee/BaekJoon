/*���� 10825��
������� ��: �迭�� �л����� ������ �����ϰ� ���� sort�� �̿��� �迭�� index ������ ���� Ǯ���� ������ �����ߴ�.
Ǯ�� ���: class�� ���� ������ �л����� ������ ������ �� �ְ� �߰�, Arrays.sort �Լ��� �̿��� ������ �����ߴ�.*/
package ICPC_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student{
	String name;
	int Korean;
	int English;
	int Math;
	
	public Student(String name, int Korean, int English, int Math) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.Korean = Korean;
		this.English = English;
		this.Math = Math;
	}
}

public class StudentGrades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Student s[] = new Student[N];
		
		for(int i=0; i<N; i++) {
			String name = sc.next();
			int Korean = sc.nextInt();
			int English = sc.nextInt();
			int Math = sc.nextInt();
			
			s[i] = new Student(name, Korean, English, Math);
		}
		
		Arrays.sort(s, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.Korean==o2.Korean) {
					if(o1.English==o2.English) {
						if(o1.Math==o2.Math) {
							return o1.name.compareTo(o2.name);
						}
						return Integer.compare(o2.Math, o1.Math);
					}
					return Integer.compare(o1.English, o2.English);
				}
				return Integer.compare(o2.Korean, o1.Korean);
			}
		});
		
		
		
		for(int i=0; i<N; i++)
			System.out.println(s[i].name);
		sc.close();

	}

}
