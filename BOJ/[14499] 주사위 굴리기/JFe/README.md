# [14499] 주사위 굴리기 - Python

## 🔍 Algorithm
**시뮬레이션**

## 💻 Logic

```Python
class Dice:
    top, front, right, left, back, bottom = 0, 1, 2, 3, 4, 5
    value = [0 for _ in range(6)]
    def move_dice(self, d):
        if d == 1:
            temp = self.top
            self.top = self.left
            self.left = self.bottom
            self.bottom = self.right
            self.right = temp
        elif d == 2:
            temp = self.top
            self.top = self.right
            self.right = self.bottom
            self.bottom = self.left
            self.left = temp
        elif d == 3:
            temp = self.top
            self.top = self.back
            self.back = self.bottom
            self.bottom = self.front
            self.front = temp
        elif d == 4:
            temp = self.top
            self.top = self.front
            self.front = self.bottom
            self.bottom = self.back
            self.back = temp
```

- **Dice 클래스**  
  - **주사위 상태 저장**  
    전개도에 맞게 `top, front, right, left, back, bottom` 에 초기 값 저장  
  - **주사위에 쓰여지는 수 저장**  
    주사위의 각 면에 쓰여지는 수를 저장하기 위해 `value` 리스트 생성  
  - **주사위 이동시키는 메소드**  
    명령 `d`에 맞게 주사위를 이동시키는 메소드 작성  

---

```Python
dice = Dice()
cur = [(y, x)]
while order:
    d = order[0]
    del order[0]
    cur_x, cur_y = cur.pop()
    # 다음 좌표 계산
    next_x = cur_x + dx[d-1]
    next_y = cur_y + dy[d-1]
    # boundary 체크
    if 0 <= next_x < M and 0 <= next_y < N:
        dice.move_dice(d)
        print(dice.value[dice.top])
        # 주사위 바닥면의 수를 복사할지, 칸에 쓰여 있는 수를 복사할지
        if map[next_y][next_x] == 0:
            map[next_y][next_x] = dice.value[dice.bottom]
        else:
            dice.value[dice.bottom] = map[next_y][next_x]
            map[next_y][next_x] = 0
        cur.append((next_x, next_y))
    else:
        cur.append((cur_x, cur_y))
```

- 입력된 명령에 맞게 주사위 이동시키며 주사위 윗 면에 적힌 수 출력  
  - **다음 좌표 계산**  
    `order`에서 받은 명령 `d`와 현재 위치 `cur`에서 **pop**한 값으로  
    다음 위치인 `next_x` , `next_y` 계산  
  - **boundary 체크**  
    **boundary 안에 속할 때**만 주사위를 이동하고 `dice.value[dice.top]` 값을 출력함  
    **아닐 때**는 현재 `cur_x` , `cur_y` 를 다시 `cur`에 **append**  
  - **주사위 바닥면의 수를 복사할지, 칸에 쓰여 있는 수를 복사할지**  
    다음 위치 칸의 값이 **0이면** `dice.value[dice.bottom]` 값을 복사  
    **0이 아니면** `dice.value[dice.bottom]`에 다음 위치 칸의 값을 복사하고 `map[next_y][next_x] = 0`  

## 📝 Review
주사위를 이동시키고 출력하는 방법은 전체적으로 어렵지 않았다.  
현재 주사위 상태와 각 면에 적히는 수와 명령에 따라 이동시키는 함수까지 있어야 해서 Class로 정의하면 편하겠다고 생각했고, 그래서 평소에는 안쓰던 Class를 사용했다.  

문제를 똑바로 정독해서 실수를 줄이자..!
