# [1197] 최소 스패닝 트리
## 💡Algorithm
- Graph
- Kruskal
- Disjoint Set
## 📚Logic
Kruskal's algorithm을 이용해서 MST를 구했다.

인접 리스트를 받아서 가중치를 기준으로 정렬 후 greedy를 사용하면 된다. 이때 union-find를 사용해서 사이클이 발생하는지 검사한다.

```c++
int kruskal() {
    int ret = 0;
    vector<pair<int, pair<int, int>>> edges;
    for (int u = 1; u < V + 1; u++) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, cost = adj[u][i].second;
            edges.push_back(make_pair(cost, make_pair(u, v)));
        }
    }
    sort(edges.begin(), edges.end());
    DisjointSet sets(V + 1);
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges[i].first;
        int u = edges[i].second.first, v = edges[i].second.second;
        if (sets.find(u) == sets.find(v)) continue;
        sets.merge(u, v);
        ret += cost;
    }
    return ret;
}
```
## 📝Review
Union-Find 알고리즘과 kruskal에 대해 자세히 공부할 수 있어서 좋았다.
