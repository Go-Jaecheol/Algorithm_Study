# [12865] 평범한 배낭 - C++

## :pushpin: **Algorithm**

DP (동적 계획법) + 배낭 문제

## :round_pushpin: **Logic**

```c++
vector<pair<int, int>>vec(N);
```

- 무게와 가치에 쉽게 접근할려고 사용해봤음

```c++
if (vec[i - 1].first <= j)
	dp[i][j] = max(dp[i - 1][j], vec[i - 1].second + dp[i - 1][j - vec[i - 1].first]);
else
	dp[i][j] = dp[i - 1][j];
```

- 배낭 용량에 따라 넣을 수 있는 물건과 아닌 물건을 구분
- 넣을 수 있다면 배낭에 넣어본 값과 그 전 값 중의 최댓값 선택

## :black_nib: **Review**

- 평범한 배낭은 개뿔 찢어버리고 싶은 배낭이었음
- DP 첫 주에 풀었던 문제들처럼 점화식 유도해내어 푸는 문제인 것 같아서 표 그려보면서 생각해봤지만 제대로 된 점화식 도출이 너무 어려웠다
- 결국 대기업의 힘을 빌려 해결했음

