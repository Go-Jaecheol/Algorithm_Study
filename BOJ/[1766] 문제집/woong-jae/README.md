# [1766] 문제집
## Algorithm
- Topology sort
## Logic
순서가 정해져 있는 시퀀스를 정렬하는 문제이기 때문에 **위상 정렬(topology sort)** 을 사용하면 문제를 효율적으로 해결할 수 있다.

단순한 위상 정렬과는 다르게, 문제에서는 가능하면 쉬운 문제부터 풀어야 되는, 즉, 작은 수부터 처리해줘야 한다.
따라서 위상 정렬을 queue 자료구조가 아닌 priority queue를 사용해서 수행했다.

1. 진입차수(in_degree)가 0인 노드를 큐에 삽입한다.
2. 큐에서 원소를 꺼내 인접하는 노드와 연결된 간선을 제거한다(진입차수 - 1).
3. 간선을 제거한 후 진입차수가 0이 된 노드를 큐에 삽입한다.
4. 큐가 빌 때까지 2~3 반복

```cpp
vector<int> create_seq() {
    vector<int> res;
    priority_queue<int, vector<int>, greater<int>> q;
    
    for (int i = 1; i <= N; i++) {
        if (degree[i] == 0) q.push(i);
    }
    
    while (q.size()) {
        int cur = q.top();
        q.pop();
        res.push_back(cur);
        
        for (int i = 0; i < adj_list[cur].size(); i++) {
            int next = adj_list[cur][i];
            if (--degree[next] == 0) q.push(next);
        }
    }
    
    return res;
}
```
## Review
위상 정렬이 뭔지 안다면 어렵지 않게 풀 수 있는 문제인 것 같다.
