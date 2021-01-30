# [11057] 오르막 수 - C ++

## :pushpin: **Algorithm**

DP (동적 계획법)

## :round_pushpin: **Logic**

```c++
int dp[1000][10];
```

- 각 자릿수마다의 오르막 수의 개수를 저장하는 배열
- dp에서는 앞에서 구했던 값들을 저장할 필요가 있어 사용

```c++
int ascent(int n)
```

- 초기화된 dp[0]의 값을 가지고 나머지 dp배열의 값을 생성하는 함수

```c++
dp[i][j] = dp[i][j+1] + dp[i-1][j]
dp[i][9] = 1
```

- 계단 수는 위와 같은 점화식 사용
- 반복문 또한 점화식에 맞춰 0부터 시작하지 않고 8부터 시작하도록 설정

## :black_nib: **Review**

- (A+B)mod C=((Amod C)+(Bmod C))mod C

- % 연산자의 사용에 있어 헤맸던 문제