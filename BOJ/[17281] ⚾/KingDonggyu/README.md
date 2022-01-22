# [17281] ⚾ - Python

## :mag: Algorithm

BruteForce

## :round_pushpin: Logic

### Problem: <u>"가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자."</u>

파이썬 모듈의 `permutations` 을 사용하여, **순열**을 통해 2번 ~ 9번 선수까지의 순서 경우의 수를 만든다.

그리고 4번타자인 1번 선수를 순열 리스트의 4번째 인덱스에 삽입한다.

```python
# 타순 정하기
for order in list(permutations([1, 2, 3, 4, 5, 6, 7, 8], 8)):

    # 4번타자 설정
    order = list(order)
    order.insert(3, 0)

    # 경기 시작
    score, player = 0, 0
    for inning in innings:
        
        # 이닝 시작
        out = 0
        b1, b2, b3 = 0, 0, 0
        while out < 3:
            if inning[order[player]] != 0:
                hit(inning[order[player]])
            else: out += 1
            
            if player+1 == 9: player = 0
            else: player += 1

    max_score = max(max_score, score)
```

### Problem: <u>시간초과</u>

**1. 리스트 ➡️ 변수**

```python
""" 이전 코드
base = [0, 0, 0] 
"""

b1, b2, b3 = 0, 0, 0
```

**2. 불필요한 변수 선언 ❌**

```python
""" 이전 코드
result = inning[order[player]]
if inning[order[player]] != 0:
    hit(inning[order[player]])
"""

if inning[order[player]] != 0:
    hit(inning[order[player]])
```

## :memo: Review

순열을 이용하는 방법을 바로 떠올려 금방 구현했지만 시간초과가 발생했다.

아무리 고민해봐도 구현한 방법에 흠이 없었고 결국 다른 사람이 푼 코드를 봤다.

리스트를 변수로 바꾸고 불필요한 변수 선언을 줄이니 시간초과를 해결할 수 있었다. (솔직히 당황스러웠다..)

리스트를 이용한 코드가 훨씬 깔끔하고 좋은 코드 같기에 해결 방법이 딱히 맘에 들지 않는다.