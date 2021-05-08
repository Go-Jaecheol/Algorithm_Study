#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int V, E, cost = 0;
int* visited;
vector <pair<int,int>> graph[100001];

void prim(int s) {
	visited[s] = 1;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	for (int i = 0; i < graph[s].size(); i++)
		pq.push(make_pair(graph[s][i].second, graph[s][i].first));

	while (!pq.empty()) {
		int cur = pq.top().second;
		int curCost = pq.top().first;
		pq.pop();

		if (visited[cur] == 1) continue;
		visited[cur] = 1;

		cost += curCost;
		for (int i = 0; i < graph[cur].size(); i++)
			pq.push(make_pair(graph[cur][i].second, graph[cur][i].first));
	}
	cout << cost;
}

int main() {
	cin >> V >> E;
	visited = new int[E + 1];

	for (int i = 1; i < E + 1; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back(make_pair(b, c));
		graph[b].push_back(make_pair(a, c));
		visited[i] = 0;
	}

	prim(1);

	delete[] visited;
	return 0;
}