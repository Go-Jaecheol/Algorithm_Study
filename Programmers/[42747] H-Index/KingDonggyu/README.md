# [42747] H-Index - Python

## :mag: Algorithm

### Sort

## :round_pushpin: Logic

💡 **오름차순 정렬** 후, `논문의 수(n) - 해당 논문의 인덱스(i) <= 해당 논문의 인용 횟수(ci)` 인 경우를 찾으면 된다.

```python
def solution(citations):
    n = len(citations)
    for i, ci in enumerate(sorted(citations)):
        if n-i <= ci: return n-i
    return 0
```

- 조건에 해당되는 경우 바로 `return` 하도록 하여 효율성을 증대시킨다. (정렬의 이점)

## :memo: Review

패턴을 찾으면 쉽게 해결할 수 있는 문제이다.