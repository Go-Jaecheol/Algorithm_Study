# [3190] 뱀 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
direction_info = {}
for _ in range(L):
    X, C = sys.stdin.readline().split()
    direction_info[int(X)] = C
print(move(1, 1))
```

- **방향 변환 정보 저장 후, move 함수 실행 및 결과 출력**  
  **딕셔너리**를 이용해서 **key-value** 값으로 시간-방향을 저장  
  처음 위치인 **1,1**에서 `move` 함수 실행 후, **return** 값 출력  

---

```Python
def move(r, c):
    time = 0
    cur_dir = 0
    q = deque()
    q.append((r, c))
    while q:
        time += 1
        r, c = q.popleft()
        # 다음 위치 계산
        next_c = c + dx[cur_dir]
        next_r = r + dy[cur_dir]
        q.appendleft((r, c))

        # 벽에 부딪히는지 체크
        if next_r < 1 or next_r > N or next_c < 1 or next_c > N : return time
        # 자기 자신과 부딪히는지 체크
        if (next_r, next_c) in q : return time
        # 이동
        q.appendleft((next_r, next_c))
        if [next_r, next_c] in apple : apple.remove([next_r, next_c])
        else : q.pop()
        # 방향 변환
        if time in direction_info.keys():
            if direction_info[time] == 'D':
                if cur_dir == 3 : cur_dir = 0
                else : cur_dir += 1
            elif direction_info[time] == 'L':
                if cur_dir == 0 : cur_dir = 3
                else : cur_dir -= 1
```

- 제시된 조건에 맞게 뱀 위치를 이동시키고 종료되는 시간을 return하는 함수  
  - **다음 위치 계산**  
    이전에 선언한 `dx = [1, 0, -1, 0]` `dy = [0, 1, 0, -1]` 에서  
    현재 방향인 `cur_dir` 을 기준으로 다음 위치 `next_x` `next_y` 를 계산  
  - **종료 조건 체크**  
    **벽에 부딪히는지** boundary 체크해서 현재 `time` 값을 **return**  
    **자기 자신과 부딪히는지**는 다음 위치가 현재 **deque**에 있는지 확인하고, 있으면 `time` 값 **return**  
  - **이동**  
    다음 위치를 **deque**의 시작 위치에 **appendleft**하고  
    그 위치가 `apple` 리스트에 있으면, 해당 값을 리스트에서 **remove**  
    `apple` 리스트에 없으면, 뱀의 꼬리를 움직이기 위해 **deque**의 끝 위치 값을 **pop**  
  - **방향 변환**  
    딕셔너리 `direction_info` 에 현재 `time`에 해당하는 **key**가 있으면,  
    그 **key**에 해당하는 **value**가 **D**인지 **L**인지에 따라 `cur_dir` 값 변경  


## 📝 Review
방향 변환에 대한 정보를 저장할 때, 리스트로 저장을 하려고 했는데 너무 비효율적인 것 같아서  
딕셔너리를 사용했는데 진짜 편하다,,  

예제 케이스 다 맞았는데 틀렸다고 나오길래 다시 보니까  
사과를 지난 다음에 사과를 없애주지 않아서 그런 거였음ㅜ  
