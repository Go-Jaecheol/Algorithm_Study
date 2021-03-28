#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first)
		return a.second > b.second;
	return a.first < b.first;
}

int N, cupramen = 0;
vector <pair <int, int>> hw;
priority_queue<int, vector<int>, greater<int>> getcup;
int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		hw.push_back(make_pair(a, b));
	}
	sort(hw.begin(), hw.end(), cmp);

	for (int i = 0; i < N; i++) {
		getcup.push(hw[i].second);
		while (hw[i].first < getcup.size())
			getcup.pop();
	}

	while (!getcup.empty()) {
		cupramen += getcup.top();
		getcup.pop();
	}

	cout << cupramen;
	return 0;
}