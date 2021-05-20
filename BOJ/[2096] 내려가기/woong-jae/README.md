# [2096] 내려가기
## 💡Algorithm
- DP
- **Sliding Window**
## 📚Logic
위에서부터 아래로 최소 혹은 최대값을 갱신하며 내려간다. 

이때, 우리가 알아야하는 값은 이전 줄까지 계산한 최소 혹은 최대값이다. 그 값에 현재 줄의 값을 더해서 최소 혹은 최대값을 구하면 되기 때문이다.

따라서 필요한 cache의 크기는 ```cache[3]```이면 충분하다. 이게 ***슬라이딩 윈도우 알고리즘***이다.
```c++
for (int i = 0; i < 3; i++) {
        cache[i] = game[0][i];
    }
    for (int i = 1; i < n; i++) {//최소값 구하기
        int temp[3];
        for (int j = 0; j < 3; j++) {
            int res = game[i][j] + cache[j];
            if (j <= 1) res = min(res, game[i][j] + cache[j + 1]);
            if (j >= 1) res = min(res, game[i][j] + cache[j - 1]);
            temp[j] = res;
        }
        for (int i = 0; i < 3; i++) {
            cache[i] = temp[i];
        }
    }
```
최대값은 위의 구현에서 min만 max로 바꾸면 된다.
## 📝Review
처음에 Top-down으로 짜서 테스트 케이스는 모두 통과했지만, cache의 크기가 너무 커서 메모리 초과에 걸렸다.

이럴경우 Bottom-up으로 짜도 똑같이 메모리 초과에 걸리기 때문에 다른 알고리즘이 필요했는데, 그게 슬라이딩 윈도우 알고리즘이었다.

새로운 알고리즘 기법을 알게된 좋은 문제.
