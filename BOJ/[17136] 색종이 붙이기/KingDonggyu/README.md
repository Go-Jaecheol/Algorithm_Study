# [17136] 색종이 붙이기 - Python

## :mag: Algorithm

BruteForce

Backtracking

## :round_pushpin: Logic

### Problem: <u>색종이의 크기와 관계없이 순서를 정해야 한다.</u>

**➡️ 재귀를 통해 모든 경우를 탐색한다.**

아래는 DFS로 구현한 재귀함수의 일부이다.

```python
for size in range(1, 6):
    # 색종이를 전부 사용한 경우
    if cnt[size] == 5:
        continue
    # 색종이를 붙일 수 있는 경우
    if check_attach(paper, x, y, size):
        temp = []
        # 1을 0으로 변경
        for i in range(x, x+size):
            for j in range(y, y+size):
                paper[i][j] = 0
                temp.append((i, j))
        # 다음 색종이 붙이기 시행
        cnt[size] += 1
        attach_colored_paper(paper, cnt, one-size**2)
        # 원상 복귀
        cnt[size] -= 1
        for i, j in temp:
            paper[i][j] = 1
```

- 1의 개수 `one` 이 0이 될 경우 결과값을 `sum(cnt)` (사용한 색종이의 수) 로 업데이트한 후 리턴한다.

- 만약 1의 개수가 0이 되지 않았는데 결과값보다 `sum(cnt)` 가 클 경우 리턴하여 불필요한 연산을 줄인다.

## :memo: Review

처음에 색종이를 크기가 큰 순서대로 붙이면 될 것이라 생각하여 구현하다 원하는 결과값이 나오지 않아 **색종이의 크기와 관계없이 순서를 정해야 한다는 것**을 깨달았다.

최근 풀어본 브루트포스 문제에서 전부 수열 또는 조합을 이용했기에 습관이 되었는지, 순서를 수열을 통해 정하여 로직을 구현했더니 또 원하는 결과값이 나오지 않았다..

그렇게 많은 시간이 소요되자 과감히 전체 코드를 삭제하고 재귀함수를 통한 백트래킹으로 구현하여 해결할 수 있었다.

생각보다 많은 시간이 소요되어 아쉬웠고, 아직 재귀함수를 이용한 아이디어를 떠올리는데 익숙하지 않은 것 같다 😂