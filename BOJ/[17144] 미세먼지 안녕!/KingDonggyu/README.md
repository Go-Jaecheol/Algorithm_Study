# [17144] 미세먼지 안녕! - Python

## :mag: Algorithm

Simulation

## :round_pushpin: Logic

이번 문제의 핵심은 공기청정기가 작동하여 미세먼지를 밀어내는 부분이다. 

이에 대한 로직은 아래와 같으며, 자세한 설명 없이 주석을 참고하면 이해할 수 있다.

```python
def work_cleanner():
    next_A = [[0 for _ in range(C)] for _ in range(R)]
    # 공기 청정기가 위치한 행 이동
    for i in range(1, C-1): 
        next_A[top][i+1], next_A[bottom][i+1] = A[top][i], A[bottom][i]
    # 마지막 열 이동
    for i in range(top, 0, -1): next_A[i-1][C-1] = A[i][C-1]
    for i in range(bottom, R-1): next_A[i+1][C-1] = A[i][C-1]
    # 첫번째 행 && 마지막 행 이동
    for i in range(C-1, 0, -1):
        next_A[0][i-1], next_A[R-1][i-1] = A[0][i], A[R-1][i]
    # 첫번째 열 이동
    for i in range(0, top): next_A[i+1][0] = A[i][0]
    for i in range(R-1, bottom, -1): next_A[i-1][0] = A[i][0]
    # 공기 청정기로 들어간 미세 먼지 제거
    next_A[top][0], next_A[bottom][0] = -1, -1
    # 공기 청정기가 지나 가지 않은 구역의 미세 먼지의 양 copy
    for i in range(1, R-1):
        if i == top or i == bottom: continue
        for j in range(1, C-1): next_A[i][j] = A[i][j]
    return next_A
```

## :memo: Review

2차원 배열의 리스트를 각각 다른 방향의 인덱스 검색을 여러번 수행하다보니 index 검색 범위로 인해 문제를 여러번 틀렸다. (예제는 전부 맞았지만 채점은 틀렸다고 나와 어떤 반복문의 index 검색 범위가 틀렸는지 찾느라 애먹었다..)

또한, python3 으로 시행하니 시간초과가 발생하자 pypy3 으로 시행하여 성공할 수 있었다.

python3 으로 시행해도 성공하기 위해 시간을 줄이려 여러 시도를 했지만 끝내 성공하지는 못했다..
