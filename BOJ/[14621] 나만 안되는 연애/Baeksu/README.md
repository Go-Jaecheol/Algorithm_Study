# [14621] 나만 안되는 연애 - C ++

## :pushpin: **Algorithm**

- 그래프 이론, 최소 스패닝 트리


## :round_pushpin: **Logic**

```c++
for (int i = 0; i < V; i++) {
    char s;
    cin >> s;
    sch_s.push_back(s);
}
```

- 남초인지 여초인지 저장하는 `vector<char> sch_s` 

```c++
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
```

- **prim algorithm** 과 **우선순위 큐**를 이용하여 최소 스패닝 트리를 구함
- `for문` : 시작 대학과 다른 성별을 가진 학교만을 우선순위 큐에 저장
- `while문` : 우선순위 큐에서부터 하나씩 꺼내서, 방문하지 않았고, 현재 학교와 다른 성별을 가진 학교를 큐에 계속 저장하면서 `cost`저장
- 모든 학교를 방문한 경우에만 `cost` 출력을 위해서 방문여부 저장하는 배열을 마지막에 check

## :black_nib: **Review**

- 지난 주차 문제보단 조금 더 응용한 느낌이 있지만 ... 금방 해결법을 찾아냈음