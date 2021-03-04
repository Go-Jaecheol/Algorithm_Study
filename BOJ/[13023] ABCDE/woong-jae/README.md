# [13023] ABCDE
## 💡Algorithm
그래프, DFS
## 📚Logic
한 노드에서 시작하는 그래프의 깊이가 5 이상 갈 수 있는지 확인하면 된다.

깊이가 5가 되면 1을 반환하고 모든 탐색을 중지한다.

```c++
int find_friend(int cur, int deep) {
    if (deep == 5) return 1;
    int res = 0;
    for (int i = 0; i < graph[cur].size(); i++) {
        if (visited[graph[cur][i]] == 0) {
            visited[graph[cur][i]] = 1;
            res = max(res, find_friend(graph[cur][i], deep + 1));
            if (res > 0) break;
            visited[graph[cur][i]] = 0;
        }
    }
    return res;
}
```
## 📝Review
아이디어는 쉽게 생각했지만 반례 하나를 생각하지 못해서 계속 해맸고, 배열 크기를 2000 * 2000으로 선언해서 틀렸다.

앞으로 그래프를 만들 때 벡터로 만들 수 있다면 무조건 벡터로 만들어야겠다.
