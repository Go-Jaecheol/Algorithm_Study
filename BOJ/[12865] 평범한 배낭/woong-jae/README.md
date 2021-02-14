# [12865] 평범한 배낭
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

현재 item을 넣은 것과 안넣은 것의 총 value를 비교해서 더 큰것을 택한다. 

이후 item도 똑같은 선택을 하기 때문에 재귀함수로 구현한다. 기저사례는 모든 아이템을 순회했을때이다.

```c++
int packing(int weight, int item) {
    if(item == n) return 0;
    int& ret = cache[weight][item];
    if(ret != -1) return ret;
    
    int res = 0;
    if(weight - wv[item][0] >= 0) {//이번 item을 넣은 것과 안넣은 것 중 총 value가 큰 것을 택한다.
        res = max(res, packing(weight - wv[item][0], item + 1) + wv[item][1]);
    }
    res = max(res, packing(weight, item + 1));
    ret = res;
    
    return ret;
}
```

## 💡Review

처음에 내부 반복되는 부분을 for문으로 순회를 했다. 백준에 돌리니 2%에서 틀렸다고 떴다.

왜 그런지 보니까 내가 짠 코드에서 cache에 저장하는 순간 그 값이 최적값이 아니였다. 이전 결정에 영향을 받기 때문이다.

최적 부분 구조인지 아닌지 꼭 확인하자잇
