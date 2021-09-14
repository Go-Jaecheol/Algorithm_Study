# [1915] 가장 큰 정사각형 - Java

## :pushpin: **Algorithm**

DP (동적 계획법)

## :round_pushpin: **Logic**

```java
if (N == 1 && M == 1) {
  System.out.println("1");
  return;
}
```

- N, M이 1인 경우는 바로 1 출력

```java
for (int i = 1; i <= N; i++) {
  String s = sc.next();
  for (int j = 1; j <= M; j++) {
    temp = s.charAt(j - 1) - '0';
    if (i == 1 && j == 1)
      dp[i][j] = temp;
    else {
      if (temp == 1) {
        dp[i][j] = Math.min(dp[i - 1][j - 1], (Math.min(dp[i - 1][j], dp[i][j - 1]))) + 1;
        if (max < dp[i][j])
          max = dp[i][j];
      }
    }
  }
}
```

- charAt() : String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환
- (1, 1) 좌표부터 시작해서, 배열 값이 1인 점을 기준으로 왼쪽, 위, 왼쪽 대각선의 배열 값 중 최소값에 1을 더한 값을 저장
  - ```
    1 1
    0 1
    ``` 
    의 경우, 정사각형이 될 수 없고 최소값은 0이기에, dp배열에는 1이 저장 -> 가장 큰 정사각형의 넓이가 1*1
- 모든 배열의 값을 입력받고, max에 저장된 값의 제곱이 곧 가장 큰 정사각형의 넓이가 됨

## :black_nib: **Review**

- 풀이방식은 항상 간단했으나, 너무 어렵게 꼬아 생각해버림
- 자바에서도 입출력 방식에 따라 시간과 메모리 사용량이 엄청나게 차이가 난다
