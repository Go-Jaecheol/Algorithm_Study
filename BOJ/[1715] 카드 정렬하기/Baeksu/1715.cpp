#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

priority_queue <int, vector<int>, greater<int>> cards;
int main() {
	int N = 0;
	cin >> N;

	int n = 0, cmp = 0;
	for (int i = 0; i < N; i++) {
		cin >> n;
		cards.push(n);
	}

	if (N > 1) {
		while (1) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				int cur = cards.top();
				cards.pop();
				sum += cur;
			}
			cmp += sum;
			cards.push(sum);
			if (cards.size() == 1)
				break;
		}
	}
	
	cout << cmp;
	return 0;
}