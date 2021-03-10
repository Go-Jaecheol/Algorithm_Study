# [11000] 강의실 배정
## 💡Algorithm
- 그리디 알고리즘
- 정렬
- 우선순위 큐
## 📚Logic
입력을 받은 후 시작하는 시간을 기준으로 정렬한다.

정렬된 입력을 우선순위 큐(끝나는 시간이 빠른 것이 가장 위)에 하나씩 넣으면서, 최상단의 끝나는 시간보다 지금 입력의 시작시간이 크다면 ```pop()```을 하고 현재 사이즈를 저장한다.

사이즈가 가장 클 때가 필요한 강의실의 수다.
```c++
q.push(time[0]);
for (int i = 1; i < n; i++) {
    if (q.top().second > time[i].first) q.push(time[i]);
    else {
        res = max(res, (int)q.size());
        while (q.size() && q.top().second <= time[i].first) {
            q.pop();
        }
        q.push(time[i]);
    }
}
```
## 📝Review
우선순위 큐가 생각이 안나서 조금 해맸다. <queue> 헤더에 priority_queue가 정의되어 있어서 편하게 풀었다.
