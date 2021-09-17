# [17140] 이차원 배열과 연산
## Algorithm
- Sort
- Simulation
## Logic
정렬하는 부분이 중요하다.

정렬을 해도 원래 수를 기억해야 하기 때문이다.
```cpp
bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second)
        return a.first < b.first;
    else
        if (a.second == 0 || b.second == 0) // 빈도 수가 0이면 뒤로 보내야함
            return a.second > b.second;
        else
            return a.second < b.second;
}
```
나머지는 시키는 대로 구하면 된다.
## Review
생각보다 좀 복잡했던 문제. 오랜만에 `sort`를 쓰는 문제여서 파바박 안풀렸다.
