# [1781] 컵라면
## 💡Algorithm
- 그리디
- 우선순위 큐
## 📚Logic
문제들을 데드라인이 빠른 순서로 정렬한다.

정렬된 배열에서 우선순위 큐에 넣을것을 고른다. 큐의 우선순위는 컵라면 수가 작은 것이다. 큐에 넣는 조건은
1. 지금 일 수보다 문제의 데드라인이 뒤라면 큐에 넣는다.
2. 데드라인이 더 앞이라면, 큐의 ```top```의 컵라면 수보다 크면 ```pop```후 넣어준다.

```c++
for (int i = 0; i < n; i++) {
        if (input[i].first > picked.size()) {
            picked.push(input[i]);
        } else if (picked.top().second < input[i].second) {
            picked.pop();
            picked.push(input[i]);
        }
    }
```
## 📝Review
그리디는 아이디어가 끝인데, 아이디어를 생각하기 너무 어렵다. 일단 아이디어를 생각하고 그게 맞는지 증명을 해야 맞는 아이디어여서 생각을 쌓아올리는게 불가능하다.
