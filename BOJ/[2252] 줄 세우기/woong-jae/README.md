# [2252] 줄 세우기
## Algorithm
- Topology sort
## Logic
순서가 정해져 있는 시퀀스를 정렬하는 문제이기 때문에 **위상 정렬(topology sort)** 을 사용하면 문제를 효율적으로 해결할 수 있다.

위상 정렬을 queue 자료구조를 사용해서 수행했다.

1. 진입차수(in_degree)가 0인 노드를 큐에 삽입한다.
2. 큐에서 원소를 꺼내 인접하는 노드와 연결된 간선을 제거한다(진입차수 - 1).
3. 간선을 제거한 후 진입차수가 0이 된 노드를 큐에 삽입한다.
4. 큐가 빌 때까지 2~3 반복

> 모든 노드를 방문하지 않는다면 사이클이 존재한다는 의미이다.

```cpp
void make_sequence() {
    queue<int> q;
    for (int i = 1; i <= N; i++) {
        if (in_degree[i] == 0) q.push(i);
    }
    
    while (q.size()) {
        int cur = q.front();
        q.pop();
        res.push_back(cur);
        for (int j = 0; j < adj_list[cur].size(); j++) {
            int next = adj_list[cur][j];
            if (--in_degree[next] == 0) {
                q.push(next);
            }
        }
    }
}
```
## Review
위상정렬이 뭔지도 모르고 무지성으로 linked list를 사용해서 풀었다가 시간초과가 났다.  
알고리즘을 풀때, 이제는 푸는 것 자체에 목적을 두는 것보다 어떤 알고리즘을 적용하면 효율적으로 풀 수 있겠다는 것을 빠르게 인지할 수 있게 노력해야겠다.  
물론 위상정렬이 뭔지 몰랐긴 했지만, 시간이 증발했다...
