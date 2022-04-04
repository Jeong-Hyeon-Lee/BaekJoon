/*﻿
for문을 이름의 길이만큼 반복하며 vector에 획수를 A, B 한 글자씩 차례로 저장한다.
임시 vector을 이용해 궁합을 계산하고 원래 vector인 name을 vector temp의 내용으로 대체하는 것을 숫자가 두개만 남을 때까지 반복한다. 남은 숫자 두개를 차례로 출력한다.﻿
*/
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	string A, B;
	vector<int> name;
	int stroke [26] = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1,
		2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
	int i;

	cin >> A >> B;

	for (i = 0; i < A.size(); i++) {
		name.push_back(stroke[A[i] - 'A']); //몇번째 알파벳인지 찾아 획수 저장
		name.push_back(stroke[B[i] - 'A']);
	}

	while (name.size() > 2) {
		vector<int> temp;
		for (int i = 0; i < name.size() - 1; i++) {
			temp.push_back((name[i] + name[i + 1]) % 10);
		}
		name = temp;
	}
	cout << name[0] << name[1] << endl;
	return 0;
}