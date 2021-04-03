#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321
using namespace std;

int v, e, s_point, e_point;
vector <pair <int, int>>graph[20001];

vector<int> short_dist() {
	vector<int> cost(v + 1, INF);
	cost[s_point] = 0;
	priority_queue<pair <int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, s_point));

	while (!pq.empty()) {
		int cur_cost = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		if (cost[cur] < cur_cost) continue;
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur][i].first;
			int next_cost = cur_cost + graph[cur][i].second;

			if (cost[next] > next_cost) {
				cost[next] = next_cost;
				pq.push(make_pair(next_cost, next));
			}
		}
	}
	return cost;
}

int main() {
	cin >> v >> e;

	for (int i = 0; i < e; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back(make_pair(b, c));
	}
	cin >> s_point >> e_point;

	vector <int> ans = short_dist();

	cout << ans[e_point];

	return 0;
}