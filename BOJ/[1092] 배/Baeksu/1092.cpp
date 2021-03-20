#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool desc(int a, int b) { return a > b; }

int N, M, ans = 0;
vector <int> crane, box;
int main() {
	int n;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> n;
		crane.push_back(n);
	}
	sort(crane.begin(), crane.end(), desc);

	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> n;
		box.push_back(n);
	}
	sort(box.begin(), box.end(), desc);

	if (crane[0] < box[0])
		ans = -1;
	else {
		while (1) {
			ans++;
			for (int i = 0; i < N; i++) {
				int m = box.size();
				for (int j = 0; j < m; j++) {
					if (crane[i] >= box[j]) {
						box.erase(box.begin() + j);
						break;
					}
				}
			}
			if (box.size() == 0)
				break;
		}
	}
	cout << ans;
	return 0;
}