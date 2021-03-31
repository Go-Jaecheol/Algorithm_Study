# [1753] 최단경로
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
다익스트라 알고리즘을 공부하고, 그냥 알고리즘을 직접 써보는 문제인 것같다. 원래는 알고리즘 공부하고 블로그에 남겼었는데, 글 남기기가 너무 불편해서 Notion에 쓰기 시작했다. 블로그에 쓴것들 다 옮기면 링크 올려야겠다.
