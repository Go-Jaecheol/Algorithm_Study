# [42862] 체육복 - Python

## :mag: Algorithm

### Greedy

## :round_pushpin: Logic

**Problem: <u>"여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다."</u>**

💡 `lost`에 없는 번호를 가진 `reserve` 리스트와 `reserve`에 없는 번호를 가진 `lost` 리스트를 새로 정의한다.

```python
two = [r for r in reserve if r not in lost]
zero = [l for l in lost if l not in reserve]
```

<br />

**Problem: <u>테스트 케이스 두개 실패</u>**

💡 그리디를 수행하기 위해 **정렬된 리스트**를 사용해야 하는데, 주어진 입력 `reserve` 리스트가 정렬되어 있지 않을 수도 있다.

```python
for t in sorted(two):
    if t-1 in zero:
        zero.remove(t-1)
    elif t+1 in zero:
        zero.remove(t+1)
```

## :memo: Review

IDE를 사용하지 않고 프로그래머스 코드 에디터에서 코드를 구현했다.

IDE를 사용하지 않으니 평소 자동완성으로 쉽게 표현했던 문법들을 일일히 타이핑하니 기억이 나지 않는 문법이 있었다. (ex. `remove`)

당분간 프로그래머스 문제를 풀며 자주 사용하는 파이썬 문법들이 손에 익도록 연습해야겠다.