# [17406] 배열 돌리기 4 - Python

## :mag: Algorithm

BruteForce

## :round_pushpin: Logic

### Problem: <u>"회전 연산이 두 개 이상이면, 연산을 수행한 순서에 따라 최종 배열이 다르다."</u>

**연산에 대한 수열을 통해 모든 경우의 수를 수행한다.**

```python
result = sys.maxsize
for order in list(permutations([i for i in range(0, K)], K)):
    copy_A = copy.deepcopy(A)
    for i in order:
        rotate(rot[i][0], rot[i][1], rot[i][2])
    for i in range(1, N+1):
        result = min(result, sum(copy_A[i]))
```

<br />

### Problem: <u>시간 줄이기</u>

- **`deepcopy` 를 통한 배열을 따로 생성하지 않고** 오른쪽 위, 오른쪽 아래, 왼쪽 아래 꼭짓점의 값들을 따로 저장한다.

- 저장한 값을 후에 회전 이동한 인덱스에 넣는다.

```python
def rotate(r, c, s):
    for cnt in range(((r+s) - (r-s)) // 2):
        t1 = copy_A[r-s+cnt][c+s-cnt]
        t2 = copy_A[r+s-cnt][c+s-cnt]
        t3 = copy_A[r+s-cnt][c-s+cnt]
        # right
        for i in reversed(range(c-s+cnt, c+s-cnt)):   
            copy_A[r-s+cnt][i+1] = copy_A[r-s+cnt][i]
        # down
        for i in reversed(range(r-s+cnt, r+s-cnt)):
            copy_A[i+1][c+s-cnt] = copy_A[i][c+s-cnt]
        copy_A[r-s+cnt+1][c+s-cnt] = t1
        # left
        for i in range(c-s+cnt, c+s-cnt):
            copy_A[r+s-cnt][i] = copy_A[r+s-cnt][i+1]
        copy_A[r+s-cnt][c+s-cnt-1] = t2
        # up
        for i in range(r-s+cnt, r+s-cnt):
            copy_A[i][c-s+cnt] = copy_A[i+1][c-s+cnt]
        copy_A[r+s-cnt-1][c-s+cnt] = t3
```

## :memo: Review

수열을 통한 방법을 금방 떠올려 쉽게 해결했다. 

문제는 pypy3 에서만 통과하고 python3 에서는 시간초과가 발생하여 시간을 줄이기 위해 시도하는데 더 오래 걸렸던거 같다.

`deepcopy` 의 효율이 좋지 않다는 것을 알고 있었기에 이를 줄여 python3 에서도 통과할 수 있었다.