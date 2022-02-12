# [42587] 프린터 - Python

## :mag: Algorithm

### Queue

## :round_pushpin: Logic

```
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
```

💡 **큐**를 이용한다.

```python
q = [(i, v) for i, v in enumerate(priorities)]
```

- 먼저, 큐로 이용할 리스트를 생성한다.

  후에 `location`과의 비교를 위해 `enumerate`를 이용한 **튜플**을 원소로 한다.

```python
 while True:
    i, v = q.pop(0)
    if q and max(q, key=lambda x: x[1])[1] > v:
        q.append((i, v))
    else:
        answer += 1
        if i == location: break
```

- 큐에서 pop한 튜플의 값(`v`)보다 높은 값을 가진 튜플이 큐에 존재한다면, pop한 튜플을 다시 push한다.

- 그렇지 않다면, `answer` 을 +1 한 후, pop한 튜플의 번호(`i`)가 `location`과 같으면 `break`한다.

## :memo: Review

주어진 조건 1, 2, 3을 큐를 이용하여 그대로 구현하면 된다.
