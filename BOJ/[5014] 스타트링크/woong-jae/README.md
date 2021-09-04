# [5014] 스타트링크
## 💡Algorithm
- BFS
## 📚Logic
일차원 배열에서 BFS로 G층까지 도달할 수 있으면 해당 층까지 갈 수 있다.

`visited` 배열을 둬서 방문한 곳인지 아닌지 체크한다. 방문한 곳은 다시 갈 필요가 없다. 다시 방문한다는 것은 현재 층에서 G층까지 도달할 방법이 없다는 뜻이기 때문이다.

`visited` 배열은 -1로 초기화해서, `visited[G]`의 값으로 G층에 도달했는지 안했는지 판별할 수 있다.

`visited` 배열을 둬서 방문한 곳인지 아닌지 체크한다. 방문한 곳은 다시 갈 필요가 없다. 다시 방문한다는 것은 현재 층에서 G층까지 도달할 방법이 없다는 뜻이기 때문이다.

```cpp
int getMinButtonPress() {
    vector<int> visited(F + 1, -1);
    queue<int> q;
    
    q.push(S); visited[S] = 0;
    while(q.size()) {
        int cur = q.front();
        
        if (cur + U <= F && visited[cur + U] == -1) {
            q.push(cur + U);
            visited[cur + U] = visited[cur]+ 1;
        }
        if (cur - D >= 1 && visited[cur - D] == -1) {
            q.push(cur - D);
            visited[cur - D] = visited[cur] + 1;
        }
        
        q.pop();
    }
    
    return visited[G];
}
```
## 📝Review
보자마자 'DP로 풀어도 풀리겠는데?'라고 생각했다가, 알고리즘이 너무 비효율적인 것 같아서 조금만 생각을 더해서 답을 낼 수 있었다. 점점 감을 다시 잡아가는 느낌이다.
