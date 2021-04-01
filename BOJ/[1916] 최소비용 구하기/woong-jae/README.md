# [1916] 최소비용 구하기
## 💡Algorithm
- Shortest Path
- Dijkstra
## 📚Logic
다익스트라 알고리즘을 구현한 후 결과 값을 출력하면 된다.
```c++
vector<int> dijkstra(int src) {
    vector<int> dist(v + 1, INF);
    dist[src] = 0;
    priority_queue<pair<int, int>> pq;
    pq.push(make_pair(0, src));
    while (!pq.empty()) {
        int cost = -pq.top().first;
        int here = pq.top().second;
        pq.pop();
        // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다.
        if(dist[here] < cost) continue;
        for (int i = 0; i < adj[here].size(); i++) {
            int there = adj[here][i].first;
            int nextDist = cost + adj[here][i].second;
            // 더 짧은 경로를 발견하면, dist[]를 갱신하고 우선순위 큐에 넣는다.
            if (dist[there] > nextDist) {
                dist[there] = nextDist;
                pq.push(make_pair(-nextDist, there));
            }
        }
    }
    return dist;
    }
}
```
## 📝Review
앞선 문제와 다를게 없는 문제다. 다익스트라 문제는 문제 변형에 한계가 있는듯?
