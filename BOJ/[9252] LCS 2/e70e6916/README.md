# [9252] LCS 2 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

**[9251] LCS**에서 했던 것처럼 먼저 LCS의 길이를 구한 후 길이를 구하기 위해 사용된 2차원 리스트```dp```를 2중 for문을 이용해 역순으로 조사한다.
```angular2html
lcs = []
temp = {'len': dp[-1][-1], 'row': -1, 'col': -1}
```
이와 같이 선언된 변수들을 이용하여
``` 
if s1[i] == s2[j] and temp['len'] == dp[i][j] and 
    temp['row'] != i and temp['col'] != j:
```
위와 같은 조건에 부합하는 ```s1```과 ```s2```의 중복 문자를 리스트```lcs```에 추가한다.

추가한 문자의 row, col 인덱스를 ```temp```에 저장하여 다음 중복 문자의 row, col 인덱스가 **겹치지 않도록 한다**.

이를 반복하여 완성된 리스트```lcs```를 역순으로 출력한다.

## :memo: Review

LCS의 길이를 구하는 방법을 알고 있다보니 LCS 문자열을 구하는 것이 어렵지 않았다.
이번에도 공책에 끄적이다보니 금방 해결책이 떠올랐다.