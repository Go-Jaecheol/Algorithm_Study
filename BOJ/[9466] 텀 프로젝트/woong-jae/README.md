# [9466] 텀 프로젝트
## 💡Algorithm
- DFS
- Cycle
## 📚Logic
이 문제의 핵심은 cycle을 탐지하는 것이다. 아직 가지 않은 노드들을 방문하면서 cycle을 탐지하고, cylce에 해당되지 않는 학생의 수를 세면 된다.
### Cycle 탐지
시작 노드부터 dfs로 다음 노드들을 타고 들어가다가, `done`이 `true`인 노드를 발견하면 cylce이 없는 것이고, `visited`가 `true`인 노드를 발견하면 cylce을 발견한 것이다.
```cpp
void dfs(int cur) {
    visited[cur] = true;
    
    int next = choice[cur];
    if(!visited[next]) dfs(next);
    else if (!done[next]) {
        for (int i = next; i != cur; i = choice[i]) {
            cnt++;
        }
        cnt++;
    }
    done[cur] = true;
}
```
## 📝Review
오랜만에 푸니까 머리가 안돌아가서 못풀겠다... Cycle을 탐지하는 문제인 줄은 알고 있었지만, 구현하는데서 막혔다. 다시 부지런히 풀어야겠다.
