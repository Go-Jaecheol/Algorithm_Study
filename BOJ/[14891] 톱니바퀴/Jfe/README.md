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



## :memo: Review

