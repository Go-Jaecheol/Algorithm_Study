# [14891] 톱니바퀴 - Python

## :mag: Algorithm
**시뮬레이션**

## :computer: Logic

```Python
def spin_gear(index, d):
    rotated[index] = True
    if index < 3 and not rotated[index+1] and gear[index][2] != gear[index+1][6]:
        # 오른쪽 확인
        rotated[index+1] = True
        spin_gear(index+1, -d)
        gear[index+1].rotate(-d)
    if index > 0 and not rotated[index-1] and gear[index][6] != gear[index-1][2]:
        # 왼쪽 확인
        rotated[index-1] = True
        spin_gear(index-1, -d)
        gear[index-1].rotate(-d)
```

- 왼쪽 오른쪽 나눠서 확인한 후, 톱니바퀴 회전  
    - index가 3보다 작고 오른쪽 톱니바퀴가 회전하지 않았을 경우,  
        - 해당 톱니바퀴 3시 방향과 오른쪽 톱니바퀴 9시 방향이 다르면 `spin_gear(index+1, -d)` 재귀 후 회전  
    - index가 0보다 크고 왼쪽 톱니바퀴가 회전하지 않았을 경우,  
        - 해당 톱니바퀴 9시 방향과 왼쪽 톱니바퀴 3시 방향이 다르면 `spin_gear(index-1, -d)`재귀 후 회전  


## :memo: Review
전체적인 구현은 쉬웠지만 회전을 어떻게 간단하게 할지 고민했고  
rotate 함수를 찾아서 해결했다.  

재귀와 회전의 순서를 처음에 반대로 구현해서 시간이 걸림,
