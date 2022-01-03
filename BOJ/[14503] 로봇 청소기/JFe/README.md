# [14503] 로봇 청소기 - Python

## :mag: Algorithm
**시뮬레이션**

## :computer: Logic

```Python
cur = [(c, r, d)]
while cur:
    cur_x, cur_y, d = cur.pop()
    if area[cur_y][cur_x] == 0:
        area[cur_y][cur_x] = 2
        result += 1
    for i in range(4):
        if d == 0: d = 3
        else: d -= 1
        next_x = cur_x + dx[d]
        next_y = cur_y + dy[d]
        if area[next_y][next_x] <= 0:
            cur.append((next_x, next_y, d))
            break
    if i == 3 and not cur:
        next_x = cur_x + -dx[d]
        next_y = cur_y + -dy[d]
        if area[next_y][next_x] == 1:
            break
        else:
            cur.append((next_x, next_y, d))
print(result)
```

- 문제에서 제시한 작동 방법에 맞춰 위치 이동  
  - 현재 위치가 청소되지 않았으면 (`area[cur_y][cur_x] == 0`),  
    해당 area 값을 2로 변경하고, result 값 1 증가  
  - 현재 방향 d를 기준으로 왼쪽부터 돌아가며 4번 for문,  
    이 과정에서 청소하지 않은 곳이 있으면 그 곳으로 이동하기 위해 `cur.append((next_x, next_y, d))` 하고, break  
  - for문을 4번 다 돌았지만 cur에 append 된 값이 없으면,  
    뒤로 후진하고 append  
    - 이 때, 후진한 위치의 area 값이 1이면 break 하고 결과 출력  

## :memo: Review
처음에는 재귀함수가 먼저 생각나서 재귀함수로 구현을 하려고 했는데  
그 과정에서 코드가 너무 길어지고, 제대로 결과가 바로 안나와서  
미련없이 바로 원래 익숙한 for문 형태로 바꿔서 풀었다.  

좌표 값을 이상하게 생각해서 쓸데없는 시간을 보내긴 했지만, 그렇게까지 어려운 문제는 아니었던 것 같다.  
역시 난 bottom-up 방식이 훨씬 익숙한 듯 하다,,
