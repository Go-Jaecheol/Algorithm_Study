# [11559] Puyo Puyo - Python

## :mag: Algorithm
**BFS, 시뮬레이션**

## :computer: Logic

```Python
def bfs(x, y):
    q = deque()
    visited[y][x] = True
    temp = [(x, y)]
    q.append((x, y, field[y][x]))
    count = 1

    while q:
        x, y, color = q.popleft()
        for i in range(4):
            cur_x = x + dx[i]
            cur_y = y + dy[i]
            if 0 <= cur_x < 6 and 0 <= cur_y < 12 and not visited[cur_y][cur_x]:
                if field[cur_y][cur_x] == color:
                    count += 1
                    visited[cur_y][cur_x] = True
                    q.append((cur_x, cur_y, field[cur_y][cur_x]))
                    temp.append((cur_x, cur_y))
    if count >= 4:
        for x, y in temp:
            field[y][x] = '.'
        return 1
    return 0
```

- BFS로 탐색하면서 뿌요가 4개 이상 있는지 확인하는 함수  
  - 현재 좌표를 기준으로 상하좌우 확인하면서  
  - color가 같으면 카운트 해주고 append  
  - 중복된 뿌요가 4개 이상이면 터뜨려서 '.'으로 바꾸기 위해 해당 좌표를 따로 temp에 append   
  - count가 4이상이면 temp에 있는 좌표에 해당하는 값들을 '.'으로 바꿔주고 1을 return  

---

```Python
def update():
    for x in range(6):
        cnt = 0
        for y in range(11, -1, -1):
            if field[y][x] != '.' and cnt > 0:
                field[y+cnt][x] = field[y][x]
                field[y][x] = '.'
            elif field[y][x] == '.':
                cnt += 1
```

- 뿌요를 터뜨린 후, 뿌요들을 내려오게 하는 함수  

---

```Python
while is_pop != -1:
    is_pop = 0
    for i in range(11, 0, -1):
        for j in range(6):
            if field[i][j] != '.':
                visited = [[False for _ in range(6)]for _ in range(12)]
                is_pop += bfs(j, i)
                
    if is_pop > 0:
        result += 1
        update()
    else:
        is_pop = -1
print(result)
```

- 전체 코드 진행하는 부분
  - 아래에서부터 순서대로 field 값이 '.'이 아니면 visited를 False로 초기화하고 bfs함수 실행  
  - 이 때, bfs return 값은 is_pop에 저장하고  
  - is_pop이 0보다 크면(뿌요가 한번이라도 터지면) result +1 해주고, update함수 실행  
  - is_pop이 0이면 종료  

## :memo: Review
오랜만에 해보는 시뮬레이션 문제  
전체적으로는 BFS로 진행하면 돼서 최근에 풀었던 BFS 문제들이랑 크게 다른게 없었지만  
배열을 거꾸로 접근하는 과정에서 0 인덱스를 빼먹은걸 몰라서 시간이 조금 오래 걸림 ㅎㅎ;;  
실수하지 말자
