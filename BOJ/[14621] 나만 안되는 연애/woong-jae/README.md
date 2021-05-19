# [14621] 나만 안되는 연애
## 💡Algorithm
- Graph
- Kruskal
- Disjoint Set
## 📚Logic
Edge를 입력받을 때, 동일한 성별끼리 이어지는 edge를 무시한다.

나머지 edge로 kruskal algorithm을 실행한 후 '선택된 간선의 수'가 '정점의 수 - 1'와 같다면 길이 존재하므로 길이를 출력하고, 아니라면 -1을 출력한다.

```c++
int kruskal(vector<pair<int, int>> &selected) {
    int ret = 0;
    vector<pair<int, pair<int, int>>> edges;
    for (int u = 0; u < N; u++) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, cost = adj[u][i].second;
            edges.push_back(make_pair(cost, make_pair(u, v)));
        }
    }
    sort(edges.begin(), edges.end());
    DisjointSet sets(N);
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges[i].first;
        int u = edges[i].second.first, v = edges[i].second.second;
        if (sets.find(u) == sets.find(v)) continue;
        sets.merge(u, v);
        selected.push_back(make_pair(u, v));
        ret += cost;
    }
    return ret;
}
```
## 📝Review
쉬운 문제
