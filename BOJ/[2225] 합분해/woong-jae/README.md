# [2225] 합분해
## 💡Algorithm
- DP
## 📚Logic
n을 k로 합분해 한 값은 0부터 n까지 k-1로 합분해한 값을을 모두 더한 값이다.
```c++
int decomposition(int n, int k) {
    if (k == 1) return 1;
    int &ret = cache[n][k];
    if (ret != -1) return ret;

    ret = 0;
    for (int i = 0; i <= n; i++) {
        ret += decomposition(n - i, k - 1);
        ret %= 1000000000;
    }

    return ret;
}
```
## 📝Review
DP 기초문제. 쉽게 풀었다.
