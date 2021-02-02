# [14002] 가장 긴 증가하는 부분 수열 4 - C ++

## :pushpin: **Algorithm**

DP (동적 계획법)

## :round_pushpin: **Logic**

```c++
int* nums;
```

- dp 배열의 값을 이용해 출력해야 할 수열들을 저장할 동적 배열

```c++
for (int i = 0; i < N; i++) {
    if (max < dp[i]) {
        max = dp[i];
        max_idx = i;
    }
}
```

- 저번에 푼 11053번의 코드로 완성된 dp 배열의 값 중 가장 큰 값과 그 값의 index를 구함

```c++
nums[idx++] = arr[max_idx];
for (int i = max_idx - 1; i >= 0; i--) {
    if (dp[max_idx] - dp[i] == 1) {
        nums[idx++] = arr[i];
        max_idx = i;
    }
}
```

- 위에서 구한 max_idx부터 dp 배열을 읽으면서 dp값의 차이가 1인 부분을 찾아 해당되는 수를 nums배열에 추가
- dp 배열에 저장된 수열 출력 (거꾸로)

## :black_nib: **Review**

- 진짜 개고생함
- dp 배열의 값 이용해서 원래 수열에 접근하는 아이디어는 금방 찾아서 모든 케이스 다 돌려봤는데도 99퍼에서 자꾸 틀림
- N == 1인 경우에 대한 코드와 그렇지 않은 경우로 나눠 코딩했는데 다시 천천히 보니 굳이 나눌 필요가 없어보여서 해당 코드를 삭제 -> "맞았습니다" ...
- 코드를 이쁘게 잘 짜기엔 아직 이해가 부족한 것 같음

