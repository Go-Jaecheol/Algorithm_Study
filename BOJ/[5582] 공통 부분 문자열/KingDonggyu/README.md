# [5582] 공통 부분 문자열 - JS

## :mag: Algorithm

### Dynamic Programming

## :round_pushpin: Logic

```js
const dp = new Array(rowSize).fill(null).map(
     _ => new Array(colSize).fill(0));
```

`(첫번째 문자의 길이 + 1) * (두번째 문자의 길이 + 1)` 크기의 `0`으로 초기화 된 2차원 배열(`dp`)을 선언한다.

```js
for (let x = 1; x < rowSize; x++) {
    for (let y = 1; y < colSize; y++) {
        if (str1[x - 1] !== str2[y - 1]) continue;
        dp[x][y] = dp[x -1][y - 1] + 1;
        answer = Math.max(answer, dp[x][y]);
    }
}
```

이중 반복문을 통해 두 문자열의 각 문자를 비교하고, **만약 같다면 `dp[x-1][y-1]` 위치의 값에 1을 더한 값을 `dp[x][y]`에 넣는다.**

반복문이 종료된 후 2차원 배열의 가장 큰 값을 출력한다.

## :memo: Review

곧바로 DP를 이용한 아이디어를 떠올려 쉽게 해결할 수 있었다.