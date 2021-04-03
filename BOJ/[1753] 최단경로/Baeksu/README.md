# [1753] 최단 경로 - C++

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
```

- 다익스트라 알고리즘
  - 항상 현재 점에서 갈 수 있는 최단 거리로 이동 ... 갱신

## :black_nib: **Review**

- **다익스트라 알고리즘**에 대한 공부를 하고 해당 코드를 적용시켜본 문제...
- `알고리즘 1` 시간에 이와 매우 비슷한 문제를 다루어서 그와 비슷하게 접근하였으나 사실은 좀 달랐다는 거
-  **우선순위 큐를 사용하는 방법**과 **2차원 배열을 사용하는 방법**, 총 2가지 방법이 가능하다

