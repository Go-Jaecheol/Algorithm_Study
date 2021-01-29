# [11053] 가장 긴 증가하는 부분 수열(LIS)
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

시작점의 수보다 뒤에 있는 수 중에서 시작점의 수보다 큰 수들을 찾는다. 그 수들의 LIS + 1 한 값이 시작점의 LIS가 된다.

겹치는 부분문제를 cache와 비교해서 다시 계산하지 않도록 한다.

```
int lis(int start) {
    int& ret = cache[start];
    if(ret != -1) return ret;
    
    ret = 1;
    for(int i = start + 1; i < n; i++) {
        if(input[start] < input[i])
            ret = max(ret, lis(i) + 1);
    }
    
    return ret;
}
```

수열을 순회하면서 가장 큰 lis 값을 찾으면 된다.

## 💡Review

DP의 대표적인 문제라고 한다. 종만북에 lis가 소개되어 있어서 참고했다.

다들 종만북 사세요.
