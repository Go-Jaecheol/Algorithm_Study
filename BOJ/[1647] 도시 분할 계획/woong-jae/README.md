# [1647] 도시 분할 계획
## 💡Algorithm
- Graph
- Kruskal
- Disjoint Set
## 📚Logic
Kruskal's algorithm을 이용해서 MST를 구했다.

인접 리스트를 받아서 가중치를 기준으로 정렬 후 greedy를 사용하면 된다. 이때 union-find를 사용해서 사이클이 발생하는지 검사한다.

마을을 두개로 분할하기 위해 MST를 이루는 간선 중 가장 큰 weight를 가진 간선을 구한 후, 그 간선을 끊는다.

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
딱히 응용이라고 하기도 뭣한 문제. Prim 알고리즘도 공부해야 겠다.
