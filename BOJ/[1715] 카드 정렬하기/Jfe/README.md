# [1715] 카드 정렬하기 - Python

## :mag: Algorithm
**Greedy Algorithm, Priority Queue**

## :computer: Logic
### `Greedy`

```Python
def combineCard():
    sum = heapq.heappop(card) + heapq.heappop(card)
    heapq.heappush(card, sum)
    return sum
```
- **우선순위 큐에서 작은 값 두개씩 더해서 다시 저장**  
  * `card`에서 **작은 값 두 개**를 **heappop** 해서 더한 것을 `sum`에 저장  
  * `sum`을 다시 `card`에 **heappush**  
  * `sum` 값 **반환**  
---
```Python
heapq.heapify(card)
while len(card) > 1:
    result += combineCard()
print(result)
```
- **비교 횟수를 result에 저장해서 출력**  
  * **우선순위 큐**를 이용하기 위해 `card` 리스트를 **heapify**  
  * `card` 리스트에 값이 ***하나*** 남을 때까지 `combineCard()` 함수 호출하고  
  * **반환 값**을 `result`에 더해서 저장  
  * 비교 횟수를 더해놓은 `result` 값 출력  
---

## :memo: Review
> 난 아직도 그리디 문제들은 문제를 이해하는 것부터가 어려운거 같다
> 제일 처음 이해한 내용이 항상 아니고ㅠ
> 
> 그래도 문제를 이해하고 나니까  
> 우선순위 큐도 몇 번 해봐서 그런지 쉬운 문제였음
> 아 그래서 더 빡치네,,,,,,,
> 
> 뭐가 됐든지 그냥 많이 풀어보는게 맞는듯..
