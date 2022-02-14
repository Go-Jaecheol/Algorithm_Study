# [43165] 타겟 넘버 - Python

## :mag: Algorithm

### DFS

## :round_pushpin: Logic

**Problem: "정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다."**

💡 **DFS**를 이용하여 모든 경우의 결과값을 도출하여 타겟 넘버와 비교한다.

```python
def solution(numbers, target):
    if numbers:
        return solution(numbers[1:], target+numbers[0]) + solution(numbers[1:], target-numbers[0])
    else:
        if target == 0: return 1
        return 0
```

- **재귀**를 수행하다 `numbers`에 더이상 원소가 없을 때, `target`이 주어진 타겟 넘버와 같을 시 카운팅한다.

## :memo: Review

문제를 읽고 바로 재귀를 이용한 DFS를 수행하면 되겠다 생각했지만, **모든 경우의 수를 전부 탐색**하는 것에서 비효율적이지 않을까 고민을 조금 했다.

결국 모든 경우의 수를 탐색하는 코드를 구현하여 해결했지만, 이 방법 외에 다른 효율적인 방법이 있을거 같아 찜찜하다..