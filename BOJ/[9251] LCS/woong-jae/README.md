# [14002] 가장 긴 증가하는 부분 수열 4
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

실제 답을 계산하기 위해서 각 부분 문제마다 어떤 선택지를 택했을 때 최적해를 얻는지를 기록해 두고, 각 조각에서 한 선택을 되짚어 가면서 최적해를 생성한다.

```
ret = 1;
int bestNext = -1;
for(int i = start + 1; i < n; i++) {
    if(start == -1 || input[start] < input[i]) {
        int candidate = lis(i) + 1;
        if(candidate > ret) {
            ret = candidate;
            bestNext = i;
        }
    }
}
choices[start + 1] = bestNext;
```

```
void reconstruct(int start, vector<int>& seq) {
    if(start != -1) seq.push_back(input[start]);
    int next = choices[start + 1];
    if(next != -1) reconstruct(next, seq);
}
```

## 💡Review

처음에는 cache를 이용해서 결과를 구하는 코드를 짰는데, 메모리 초과가 났다...

해결 방법은 최적해를 따로 구하는게 아니라, 어떤 선택을 하면 최적해가 되는지 기록해두는 cache를 하나 더 두고 LIS를 구하면서 기록을 하는 것이다.

너무 어렵다... 근데 재밌다.
