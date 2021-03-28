# [1781] 컵라면 - Python

## :mag: Algorithm
**Greedy Algorithm, Priority Queue**

## :computer: Logic
### `Greedy`

```Python
hw.sort()
for deadline, ramen in hw:
    if len(h) < deadline:
        heapq.heappush(h, ramen)
    else:
        temp = heapq.heappop(h)
        heapq.heappush(h, max(temp, ramen))
print(sum(h))
```
- **정렬 후 계산**  
  * **heapq**에 들어가 있는 크기보다 `deadline`이 **크면** **컵라면 값**(`ramen`)을 **heappush**  
  * **작거나 같으면** **heappop**을 한 후 그 값과 현재 **컵라면 값**(`ramen`) 중 **max**를 다시 **heappush**  
---

## :memo: Review
> 우선순위 큐를 사용할 때  
> 필요한 값만 push 하면 되는데  
> 계속 리스트나 튜플 형식으로 한번에 다 push 하려고 하는게 문제였다,,  
> 
> 다른 문제 풀때도 그렇고 아직 우선순위에 대한 감각이 부족한거 같다.
