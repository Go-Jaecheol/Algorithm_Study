# [1041] 주사위
## 💡Algorithm
- 그리디 알고리즘
## 📚Logic
두가지 경우의 수가 있다

- n = 1일때
```c++
    sort(d.begin(), d.end());
    for (int i = 0; i < 5; i++) {
        res += d[i];
}
```
- n >=2 일때
```c++
    unsigned long long point = (unsigned long long)4 * (min(d[2], d[3]) + min(d[0] + d[1], min(d[1] + d[5], min(d[5] + d[4], d[4] + d[0])))); //꼭짓점
    unsigned long long min_edge = d[0] + d[1];
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            if (i != j && i + j != 5) {
                min_edge = min(min_edge, d[i] + d[j]);
            }
        }
    }
    unsigned long long edge = (unsigned long long)(4 * (2 * n - 3)) * min_edge;//모서리
    sort(d.begin(), d.end());
    unsigned long long face = (unsigned long long)(5 * (n - 2) * (n - 2) + 4 * (n - 2)) * d[0];//면

    res = point + edge + face;
}
```
## 📝Review
제일 싫어하는 단순 노가다 문제.
