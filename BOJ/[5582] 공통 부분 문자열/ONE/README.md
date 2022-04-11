# [5582] 공통 부분 문자열 - JAVA

## :black_circle: Algorithm
**DP**

## :black_circle: Logic

- 두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성

> _Key Idea_
> - 문자를 한개씩 비교하여 만약에 같다면 대각선 위에 위치한 개수에 +1 하기
>   - 공통부분문자열일 경우에 그 숫자가 대각선으로 증가함
> - row 와 col 이 0 인 부분에 1인 값이 올 수 있는데 이를 수행하기 위해 배열의 사이즈를 +1 해서 설정

```Java
for(int i = 1; i <= len1; i++)
    for(int j = 1; j <= len2; j++)
        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
            max = Math.max(max, dp[i][j]);
        }
```

## :black_circle: Review
문자열 만으로 해결해보려다가 수많은 시간초과와 메모리초과를 마주쳤던 문제  
4000이하면 어떻게든 풀어볼 수 있을 것 같았고 DP 부분도 생각은 났었는데 혼자 힘으로 못해서 아쉽다