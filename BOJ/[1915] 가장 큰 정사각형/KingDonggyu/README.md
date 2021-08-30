# [1915] 가장 큰 정사각형 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

- 모든 원소가 0의 값을 가진 n * m 크기의 배열 'dp'를 생성한다.

<br />

- 다음 코드와 같이 해당 원소의 위(i-1, j), 왼쪽(i, j-1), 대각선(i-1, j-1)에 위치한 세 원소 중 최소값과 주어진 배열 'arr' 를 더한 값을 dp에 선언한다. 이를 2중 반복문을 통해 n * m 횟수만큼 반복한다.
    ```python
    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + arr[i][j]
    ```
    만약 arr 값이 0이거나 i 또는 j 값이 0일 경우 수행하지 않는다.

<br />

- 다음 코드와 같이 배열 dp 중 가장 큰 값(정사각형 변의 길이)을 찾아, 
    ```python
    size = max(map(max, dp))
    ```
    찾은 값의 제곱을 출력한다.


## :memo: Review

알고리즘 스터디를 정말 오랜만에 한 것과 더불어 DP 문제였음에 불구하고 이번 문제를 해결하기 위한 아이디어를 떠올리는 데 큰 어려움을 겪지 않았다.
