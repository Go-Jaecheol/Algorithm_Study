# [2437] 저울
## 💡Algorithm
- 그리디 알고리즘
## 📚Logic
무게를 오름차순으로 정렬한다.

0부터 시작해서 이때까지 더한 값보다 지금 더할 값이 크다면 "이때까지 더한 값 + 1"이 만들 수 없는 최소 양수가 된다.
```c++
sort(w.begin(), w.end(), less<int>());
for (int i = 0; i < n; i++) {
        if (w[i] > sum) break;
        sum += w[i];
}
```
## 📝Review
예전에 풀었던 문제. 아직도 아이디어 이해가 잘 안된다.
