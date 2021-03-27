#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	vector<int> w;
	int N, n, ans = 0, sum = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> n;
		w.push_back(n);
	}
	sort(w.begin(), w.end());

	for (int i = 0; i < N; i++) {
		if (sum + 1 < w[i])
			break;
		sum += w[i];
	}
	cout << sum + 1;
	return 0;
}