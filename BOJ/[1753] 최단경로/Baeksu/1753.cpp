#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321
using namespace std;

int v, e, s;
vector <pair <int, int>>graph[20001];

vector<int> short_dist() {
	vector<int> cost(v + 1, INF);
	cost[s] = 0;
	priority_queue<pair <int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, s));

	while (!pq.empty()) {
		int cur_cost = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		if (cost[cur] < cur_cost) continue;
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur][i].first;
			int next_cost = cur_cost + graph[cur][i].second;

			if (cost[next] > next_cost) {
				//현재 next에 저장된 cost의 값보다 현재의 점을 거쳐서 갈 경우의 거리가
				//더 짧으면 갱신, 큐에 push
				cost[next] = next_cost;
				pq.push(make_pair(next_cost, next));
			}
		}
	}
	return cost;
}

int main() {
	cin >> v >> e >> s;

	for (int i = 0; i < e; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back(make_pair(b, c));
	}

	vector <int> ans = short_dist();

	for (int i = 1; i < ans.size(); i++) {
		if (ans[i] == INF)
			cout << "INF" << "\n";
		else
			cout << ans[i] << "\n";
	}

	return 0;
}