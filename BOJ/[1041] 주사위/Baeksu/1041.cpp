#include <iostream>
#include <algorithm>
using namespace std;

void find_123();

unsigned long long N, max_num = 0, max_idx, min_idx;
unsigned long long one = 51, two = 101, three = 151;
unsigned long long dice[6];
int main() {
	unsigned long long sum = 0;
	cin >> N;

	for (int i = 0; i < 6; i++) {
		cin >> dice[i];
		if (dice[i] > max_num) {
			max_num = dice[i];
			max_idx = i;
		}
		if (dice[i] < one) {
			one = dice[i];
			min_idx = i;
		}
	}

	if (N == 1) {
		for (int i = 0; i < 6; i++) {
			if (i != max_idx)
				sum += dice[i];
		}
	}
	else {
		find_123();
		unsigned long long side1 = one * (N - 2) * (5 * N - 6);
		unsigned long long side2 = two * 4 * (2 * N - 3);
		unsigned long long side3 = three * 4;
		sum = side1 + side2 + side3;
	}

	cout << sum;
	return 0;
}

void find_123() {
	unsigned long long sum3;
	int idx2;
	for (int i = 0; i < 6; i++) {
		long s = dice[min_idx];
		if (i != min_idx && min_idx + i != 5) {
			s += dice[i];
			if (s < two) {
				two = s;
				idx2 = i;
			}
		}
	}
	for (int j = 0; j < 6; j++) {
		sum3 = two;
		if (j != min_idx && j != idx2 && min_idx + j != 5 && idx2 + j != 5) { // 조건 추가 필요
			sum3 += dice[j];
			if (sum3 < three)
				three = sum3;
		}
	}
}