# [16637] 괄호 추가하기 - Python

## :mag: Algorithm

BruteForce

## :round_pushpin: Logic

### Problem: <u>"괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력한다."</u>

각 괄호에 번호를 매긴 뒤 **조합을 이용하여 모든 경우의 수를 수행한다.**

```python
for i in range(max_bracket+1):
    for brackets in list(combinations(bracket_num, i)):
        new_math = []
        check = -1

        # 중첩 괄호 확인
        for x in range(i):
            if x > 0 and brackets[x] - brackets[x-1] == 1:
                check = -2; break

        if check == -2: continue
        brackets = list(map(lambda x: x*2, brackets))

        # 괄호 수식 계산
        for x in range(N):
            if x <= check: continue
            if x in brackets:
                new_math.append(calculate(math[x+1], math[x], math[x+2]))
                check = x+2
            else:
                new_math.append(math[x])

        # 남은 수식 계산
        num = new_math[0]
        for x in range(0, len(new_math)-2, 2):
            num = calculate(new_math[x+1], num, new_math[x+2])

        result = max(result, num)
```

- 최대로 가질 수 있는 괄호 수를 먼저 계산하여 불필요한 연산을 줄인다.

```python
max_bracket = (N // 2) // 2 + (N // 2) % 2
```

- 연속된 괄호의 번호가 나올 시 (중첩 괄호) 해당 경우 `continue` 한다.

- 괄호 안의 수식을 먼저 계산한다.

  - `N` 에 대한 반복문으로 괄호의 위치가 나오면 괄호 안의 수식을 계산한다.

- 그 후, 남은 수식을 계산한다.

## :memo: Review

아이디어가 금방 떠올리 문제를 쉽게 해결했다.

출력값이 음수가 될 수 있다는 점을 간과하여 `result` 의 초기 값을 0으로 설정해둔 탓에 한번 틀리긴 했다..