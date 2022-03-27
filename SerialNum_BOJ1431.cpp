/*
���� 1431��
Ǯ�� ���: ������ ���ǿ� ���� compare �Լ��� ������ sort�� �������� ��Ҵ�.
������� ��: ������.
*/
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool compare(string a, string b) {
	if (a.size() != b.size())
		return a.size() < b.size();

	int sumA = 0, sumB = 0;
	for (int i = 0; i < a.size(); i++) {
		if ('0' <= a[i] && a[i] <= '9')
			sumA += a[i] - '0';
		if ('0' <= b[i] && b[i] <= '9')
			sumB += b[i] - '0';
	}
	if (sumA != sumB)
		return sumA < sumB;

	return a < b;
}

int main() {
	int N, i;
	string serial[50];
	cin >> N;

	for (i = 0; i < N; i++) {
		cin >> serial[i];
	}
	sort(serial, serial + N, compare);
	
	for (i = 0; i < N; i++) {
		cout << serial[i] << endl;
	}
	return 0;
}