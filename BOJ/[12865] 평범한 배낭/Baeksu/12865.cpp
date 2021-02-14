#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int N, W;
int dp[101][100001];

int main() {
	cin >> N >> W;

	vector< pair<int, int> > vec(N);
	for (int i = 0; i < N; i++)
		cin >> vec[i].first >> vec[i].second;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= W; j++) {
			if (vec[i - 1].first <= j)
				dp[i][j] = max(dp[i - 1][j], vec[i - 1].second + dp[i - 1][j - vec[i - 1].first]);
			else
				dp[i][j] = dp[i - 1][j];
		}
	}
	cout << dp[N][W];
	return 0;
}