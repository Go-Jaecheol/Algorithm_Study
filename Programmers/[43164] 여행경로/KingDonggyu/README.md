# [43164] 여행경로 - Python

## :mag: Algorithm

### DFS

## :round_pushpin: Logic

먼저, 주어진 `tickets`를 통해 출발지를 Key로 하고 도착지를 Value로 한 **딕셔너리를 생성한다.**

```python
for key, value in tickets:
    if key in airports: airports[key].append(value)
    else: airports[key] = [value]
for key in airports:
    airports[key].sort()
```

- 생성한 딕셔너리의 각 Key의 Value 리스트를 오름차순 정렬한다.

<br />

**스택을 이용한 DFS를 시행한다.**

```python
after = []
    stack = ["ICN"]
    while len(stack) + len(after) != len(tickets)+1:
        top = stack[-1]
        if top not in airports or not airports[top]:
            after.append(stack.pop())
        else:
            stack.append(airports[top].pop(0))
            
    return stack + after[::-1]
```

- 딕셔너리에 스택의 top에 대한 Value(도착지)가 있으면 스택에 push한다.

- 없으면 `after`에 push한다.

(이때, 딕셔너리의 값을 pop하여 리턴한 값을 push)

- 나올 수 있는 루트의 길이만큼 반복하여 종료된 후, 스택과 역순의 `after`를 합친 값을 리턴한다.

## :memo: Review

오랜만에 시간을 꽤 투자한 문제였다.

처음에 재귀함수를 이용한 코드를 구현하여 해결했지만, 코드가 너무 복잡하여 마음에 들지 않았다.

문제를 맞췄지만 더 효율적인 방법이 없을까 고민하다 스택을 이용한 코드로 변경했다. (여기에 많은 시간을 소요했다..)

왜 항상 처음에 풀 때는 더 효율적인 코드가 바로 떠오르지 않는 것일까.. 😂