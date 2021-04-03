# [1916] 최소비용 구하기 - C++

## :pushpin: **Algorithm**

그래프 이론, 다익스트라

## :round_pushpin: **Logic**

```c++
vector <pair <int, int>>graph[20001];
```

- 인덱스는 출발점, `pair` 값은 각각 도착점과 가중치

```c++
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
```

- 다익스트라 알고리즘
  - 항상 현재 점에서 갈 수 있는 최단 거리로 이동 ... 갱신

## :black_nib: **Review**

- **[1753] 최단 경로**문제와 동일, 그저 출발점과 도착점이 정해져있다는 것 외에는 다른 것이 없었음

