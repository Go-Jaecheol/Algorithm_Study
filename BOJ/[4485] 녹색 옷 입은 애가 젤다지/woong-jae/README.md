# [4485] 녹색 옷 입은 애가 젤다지?
## 💡Algorithm
- Shortest Path
- Dijkstra
## 📚Logic
다익스트라 알고리즘을 구현한 후 결과 값을 출력하면 된다.
```c++
dist[0][0] = map[0][0];
priority_queue<pair<int, pair<int, int>>> pq;
pq.push(make_pair(-dist[0][0], make_pair(0, 0)));
while (!pq.empty()) {
    int cost = -pq.top().first;
    pair<int, int> here = pq.top().second;
    pq.pop();
    if (cost > dist[here.first][here.second]) continue;
    for (int i = 0; i < 4; i++) {
        pair<int, int> there = make_pair(here.first + dr[i], here.second + dc[i]);
        if (0 <= there.first && there.first < n && 0 <= there.second && there.second < n) {
            int nextDist = cost + map[there.first][there.second];
            if (dist[there.first][there.second] > nextDist) {
                dist[there.first][there.second] = nextDist;
                pq.push(make_pair(-nextDist, make_pair(there.first, there.second)));
            }
        }
    }
}
```
## 📝Review
다익스트라를 구현할 수 있으면 쉬운문제.
