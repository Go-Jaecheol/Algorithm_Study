# [1707] 이분 그래프
## 💡Algorithm
- BFS
## 📚Logic
인접한 정점끼리 서로 다른 색으로 칠해서, 모든 정점을 두 가지 색으로만 칠할 수 있다면 이분 그래프이다.

BFS로 그래프를 탐색하면서, 방문한 노드인데 현재 노드와 같은 그룹인 노드가 발견되면 이분 그래프가 아니다.
```c++
for (int vert = 1; vert <= V; vert++) {
        if (visited[vert] == -1) {
            q.push(vert);
            visited[vert] = 0;
            while(q.size()) {
                int size = (int)q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.front();
                    int cur_group = visited[cur];
                    for (int j = 0; j < adj_list[cur].size(); j++) {
                        int next = adj_list[cur][j];
                        if (visited[next] == -1) {
                            q.push(next);
                            visited[next] = (cur_group + 1) % 2;
                        }
                        else if (visited[next] == cur_group) return 1;
                    }
                    q.pop();
                }
            }
        }
    }
```
## 📝Review
이분 그래프가 뭔지 몰라서 검색해서 풀었다. 문제는 금방 풀었는데, 그래프가 연결 그래프가 아닐 수도 있는 것을 간과해서 첫 제출에서 실패했다. 쩝...
