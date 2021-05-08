# [1647] 도시 분할 계획 - C ++

## :pushpin: **Algorithm**

- 그래프 이론, 최소 스패닝 트리


## :round_pushpin: **Logic**

```c++
void prim(int s) {
	int maxC = 0;
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

		if (maxC < curCost)
			maxC = curCost;
		cost += curCost;
		for (int i = 0; i < graph[cur].size(); i++)
			pq.push(make_pair(graph[cur][i].second, graph[cur][i].first));
	}
	cout << cost - maxC;
}
```

- **prim algorithm** 과 **우선순위 큐**를 이용하여 최소 스패닝 트리를 구함
- `for문` : 우선순위 큐(오름차순)에 시작점에서 갈 수 있는 모든 노드정보를 저장
- `while문` : 시작점에서 갈 수 있는 노드 중 가장 가중치가 작은 노드를 방문하고 마찬가지로 갈 수 있는 모든 노드정보를 저장, `cost`에는 방문하지 않은 노드로 가는 가중치만을 더함
  - 그리고 마을을 2개로 나누어야 하기 때문에, 유지비가 가장 큰 길을 제외하여 두 마을로 분리

## :black_nib: **Review**

- 역시 **1197 최소 스패닝 트리** 코드 복붙해서 ... 두 마을로 나눠야 하니까 **MST**를 2개 만들면 되겠다고 생각, 그래서 유지비가 제일 큰 길 제외