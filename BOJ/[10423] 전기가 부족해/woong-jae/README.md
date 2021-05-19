# [10423] 전기가 부족해
## 💡Algorithm
- Graph
- Prim
## 📚Logic
발전소 node를 초기화해서 prim 알고리즘에 발전소들에서 시작되는 트리 중 가장 짧은 edge를 선택하게 한다.

```c++
int prim() {
    vector<bool> added(N, false);
    vector<int> minWeigtht(N, INF), parent(N, -1);
    
    int ret = 0;
    for (int i = 0; i < K; i++) {
        minWeigtht[powerplant[i]] = parent[powerplant[i]] = 0;
    }
    for (int iter = 0; iter < N; iter++) {
        int u = -1;
        for (int v = 0; v < N; v++) {
            if (!added[v] && (u == -1 || minWeigtht[u] > minWeigtht[v]))
                u = v;
        }
        ret += minWeigtht[u];
        added[u] = true;
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i].first, weight = adj[u][i].second;
            if (!added[v] && minWeigtht[v] > weight) {
                parent[v] = u;
                minWeigtht[v] = weight;
            }
        }
    }
    return ret;
}
```
## 📝Review
크루스칼으로 풀라고 했지만, 너무 비효율적이여서 프림으로 생각했더니 바로 풀렸다.
