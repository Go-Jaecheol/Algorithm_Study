#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int V, E;
int* visited;
vector <pair<int, int>> graph[100001];
vector <char> sch_s;

int prim(int s) {
	visited[s] = 1;
	int cost = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	for (int i = 0; i < graph[s].size(); i++) {
		if (sch_s[s - 1] != sch_s[graph[s][i].first-1])
			pq.push(make_pair(graph[s][i].second, graph[s][i].first));
	}
	while (!pq.empty()) {
		int cur = pq.top().second;
		int curCost = pq.top().first;
		char cur_s = sch_s[cur - 1];
		pq.pop();

		if (visited[cur] == 1) continue;
		visited[cur] = 1;
	
		cost += curCost;
		for (int i = 0; i < graph[cur].size(); i++)
			if (cur_s != sch_s[graph[cur][i].first - 1])
				pq.push(make_pair(graph[cur][i].second, graph[cur][i].first));
	}
	for (int i = 1; i < V + 1; i++)
		if (visited[i] == 0)
			return -1;
	return cost;
}

int main() {
	cin >> V >> E;
	visited = new int[E + 1];
	for (int i = 0; i < V; i++) {
		char s;
		cin >> s;
		sch_s.push_back(s);
	}

	for (int i = 1; i < E + 1; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back(make_pair(b, c));
		graph[b].push_back(make_pair(a, c));
		visited[i] = 0;
	}

	cout << prim(1);

	delete[] visited;
	return 0;
}