# [15685] 드래곤 커브 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
def draw_curve(x, y, d, g):
    # 0세대 드래곤 커브 그리기
    dir_list = [d]
    map[y][x] = 1
    next_x = x + dx[d]
    next_y = y + dy[d]
    map[next_y][next_x] = 1
    cur = [(next_x, next_y)]

    # g세대 드래곤 커브 그리기
    for _ in range(g):
        # 이전 세대 선분 방향 리스트 복사
        temp = dir_list.copy()
        for _ in range(len(dir_list)):
            x, y = cur.pop()
            d = dir_list.pop()
            # 방향 90도 회전 후 다음 위치 계산
            if d == 3: next_d = 0
            else: next_d = d + 1
            next_x = x + dx[next_d]
            next_y = y + dy[next_d]
            temp.append(next_d)
            map[next_y][next_x] = 1
            cur.append((next_x, next_y))
        # 현재 세대 선분 방향 리스트 저장
        dir_list = temp.copy()
```

- 주어진 정보에 맞게 드래곤 커브 그리는 함수  
  - **0세대 드래곤 커브 그리기**  
    시작 위치 `x, y`에 해당하는 `map` 값을 **1**로 변경  
    시작 방향 `d`에 맞게 다음 위치에 해당하는 `map` 값도 **1**로 바꿔주고, `cur` 리스트에 **append**  
  - **g세대 드래곤 커브 그리기**  
    주어진 세대 `g`에 맞게 반복문 진행  
  - **이전 세대 선분 방향 리스트 복사**  
    이전 세대 선분 방향 리스트인 `dir_list`를 `temp` 리스트에 **copy** 한 다음,  
    `dir_list`의 값을 **pop** 하면서 `dir_list`에 있던 만큼 반복문 진행  
  - **방향 90도 회전 후 다음 위치 계산**  
    `dir_list`에서 **pop**한 값 `d`를 **90도 회전**하기 위해 **+1** 해주고 (`d==3`이면 **0**으로), `next_d`는 `temp`에 **append**  
    다음 위치 계산하고 해당하는 `map` 값을 **1**로 바꾼 다음, `cur`에 **append**  
  - **현재 세대 선분 방향 리스트 저장**  
    `temp`에 저장된 현재 세대 선분 방향 리스트를 다시 `dir_list`에 **copy**하고 반복문 진행  

---

```Python
# 주어진 정보에 맞게 드래곤 커브 그리기
for x, y, d, g in curve_info:
    draw_curve(x, y, d, g)

# 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 구한 후, 출력
count = 0
for i in range(100):
        for j in range(100):
            if map[i][j] == 1 and map[i][j+1] == 1 and map[i+1][j] == 1 and map[i+1][j+1] == 1:
                count += 1
print(count)
```

- **주어진 정보에 맞게 드래곤 커브 그리기**  
  `curve_info`에 입력된 정보 `x, y, d, g` 를 이용해서 `draw_curve` 함수 실행  
- **네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 구한 후, 출력**  
  100x100 격자를 이중 for문을 통해 네 꼭짓점이 모두 `map` 값이 **1**이면 `count`를 해주고  
  `count` 값 출력  

## 📝 Review
주어진 방향이 규칙이 있을 것이라고 생각했고, 생각대로 주어진 방향을 이용하니 쉽게 90도 회전할 수 있었다.  
드래곤 커브를 그리는 과정도, 검사하는 과정도 쉬웠지만  
검사하는 과정에서 index를 하나씩 더 많게 계산해서 런타임 에러가 떴었다,,  
시뮬레이션은 주어진 문제대로만 풀면 되니까 문제를 더 열심히 다시 읽자..!  
