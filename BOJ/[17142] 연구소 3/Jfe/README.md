# [17142] 연구소 3 - Python

## :mag: Algorithm
**BFS, Brute-Force**

## :computer: Logic
### `BFS`

> 전체적으로 [[17141]연구소 2](https://www.acmicpc.net/problem/17141) 문제랑 비슷하지만  
> 
> **연구소 3**에서는 **비활성 바이러스**의 경우에는 이동은 하지만 시간에 포함되지 않는다.  
> 
> 그래서 함수 호출 전 **빈칸**이 몇개인지 확인한 다음, **빈칸**인 경우에만 **시간을 업데이트** 하고  
> 
> **빈칸의 개수**랑 **감염 수**가 같으면 **최소 시간을 출력**하도록 구성함

```Python
def spreadVirus(copy_lab):
    global result
    infect = 0
    max_time = 0
    time = [[0 for x in range(N)]for y in range(N)]
    que = deque()

    for i in range(N):
        for j in range(N):
            if copy_lab[i][j] == -1:
                que.append((i, j))
    while que:
        y, x = que.popleft()
        for k in range(4):
            next_x = x + dx[k]
            next_y = y + dy[k]
            if 0 <= next_x < N and 0 <= next_y < N:
                if copy_lab[next_y][next_x] == 0 or copy_lab[next_y][next_x] == 2:
                    time[next_y][next_x] = time[y][x] + 1
                    que.append((next_y, next_x))
                    if copy_lab[next_y][next_x] == 0:
                        infect += 1
                        max_time = time[next_y][next_x]
                    copy_lab[next_y][next_x] = -1
    if infect == blank_cnt:
        result = min(result, max_time)
```
- **BFS로 바이러스를 퍼뜨리는 함수**    
  * `copy_lab` 값이 ***0***이면 `infect`를 카운트 해주고  
  * 현재 시간을 `max_time`에 저장할 수 있도록 코드 추가  
  * 탐색이 끝나면 `infect` 값과 `blank_cnt`가 같은지 확인한 후
  * `result`가 **최소**가 되는 값을 저장  
---

### `Brute-Force`  
```Python
def putVirus(count):
    global blank_cnt
    virus = []
    for i in range(N):
        for j in range(N):
            if lab[i][j] == 2:
                virus.append((i, j))
            elif lab[i][j] == 0:
                blank_cnt += 1
    comb = list(combinations(virus, M))
    for c in comb:
        copy_lab = [lab[i][:] for i in range(N)]
        for i in range(M):
            copy_lab[c[i][0]][c[i][1]] = -1
        spreadVirus(copy_lab)
```
- **바이러스를 놓기 위한 함수**  
  * for문으로 `lab` 값을 확인할 때  
  * `lab` 값이 ***0***인 경우에는 `blank_cnt`를 카운트해서 저장해둔다.

## :memo: Review
[17141] 연구소 2 문제랑 비슷해서 코드를 조금 추가하고 수정한 내용만 적었다.  

코드 추가하기 전 연구소2 문제 풀이는 여기 있음  
[[17141] 연구소 2 (Jfe)](https://github.com/Go-Jaecheol/BOJ/tree/master/BFS/%5B17141%5D%20%EC%97%B0%EA%B5%AC%EC%86%8C%202)

처음에는 연구소 2랑 뭐가 다른지 이해를 잘 못했는데  
이해하고 나니까 코드 몇개 추가로 끝났다,,  
사실상 2나 3이나 난이도는 비슷한듯
