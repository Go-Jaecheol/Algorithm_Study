# [2096] 내려가기 - Java

## :pushpin: **Algorithm**

DP (동적 계획법)

## :round_pushpin: **Logic**

```java
for (int i = 0;i<N;i++) {
    String s = sc.nextLine();
    s = s.replace(" ", "");
    for (int j = 0;j<3;j++) {
        ary[i][j] = s.charAt(j) - '0';
        if (i == 0)
            dp1[j] = dp2[j] = ary[0][j];
    }
}
```

- 2차원 배열 ```ary``` 에 숫자 저장 및 최대, 최소값을 저장할 ```dp1, dp2``` 배열 초기화

```java
for (int i=1;i<N;i++) {
    for (int j=0;j<3;j++) {
        if (j == 0) {
            temp[0] = Math.max(dp1[0], dp1[1]) + ary[i][j];
            temp[3] = Math.min(dp2[0], dp2[1]) + ary[i][j];
        } else if (j == 1) {
            temp[1] = Math.max(dp1[0], Math.max(dp1[1], dp1[2])) + ary[i][j];
            temp[4] = Math.min(dp2[0], Math.min(dp2[1], dp2[2])) + ary[i][j];
        } else {
            temp[2] = Math.max(dp1[1], dp1[2]) + ary[i][j];
            temp[5] = Math.min(dp2[1], dp2[2]) + ary[i][j];
        }
    }
    dp1[0] = temp[0];
    dp1[1] = temp[1];
    dp1[2] = temp[2];
    dp2[0] = temp[3];
    dp2[1] = temp[4];
    dp2[2] = temp[5];
}
```

- 1번째, 2번째, 3번째 자리마다 내려갈 수 있는 다음 줄의 범위가 다르기 때문에 서로 다른 ```dp ``` 배열 값을 이용

## :black_nib: **Review**

- 아이디어는 금방 떠올랐지만 ```Java``` 를 이용한 구현에서 애를 좀 먹었다
- 한번에 다 입력 받고 처리하지 않고 입력받으면서 처리한다면 1차원 배열만으로도 가능했을텐데 풀어내는데에만 급급해 메모리, 시간 모두 효율적이지 못했다