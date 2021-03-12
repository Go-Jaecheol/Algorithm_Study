# [11000] 강의실 배정 - Python

## :mag: Algorithm
**Greedy Algorithm, Priority Queue**

## :computer: Logic
### `Greedy`

```Python
def allocateRoom():
    lecture.sort()
    heapq.heappush(h, lecture[0][1])
    for i in range(1, N):
        if h[0] > lecture[i][0]:
            heapq.heappush(h, lecture[i][1])
        else:
            heapq.heappop(h)
            heapq.heappush(h, lecture[i][1])
```
- **시간이 안겹치게 강의실 배정하는 함수**  
  * 입력받은 `lecture`를 **오름차순 정렬**  
  * 기존 수업의 **끝나는 시간**이 새로운 수업의 **시작 시간**보다 **크면** **새로운 강의실**을 써야 함  
  * 기존 강의실들은 **끝나는 시간**을 기준으로 **오름차순 정렬**해서 **제일 처음 값**만 보면 됨 (-> **우선순위 큐** 사용)  
  * **우선순위 큐** `heapq`를 사용해서 `h`에 제일 **첫 수업의 끝나는 시간**(`lecture[0][1]`) **push**  
  * for문을 돌면서 `h[0]`이 `lecture[i][0]`보다 **크면** `lecture[i][1]`을 **heappush**  
  * 아니면 **heappop**하고 다시 `lecture[i][1]`을 **heappush**  
---

## :memo: Review
> 회의실 배정 문제를 했어서 어떻게 해야 강의실을 배정할 수 있는지는 쉽게 알았지만  
> 그렇게 짜니까 시간초과가 났다,,
> 
> 아기 상어 문제를 하면서 우선순위 큐를 사용했었기 때문에  
> 익숙하다고 생각했는데  
> 아직 제대로 쓰는 방법을 모르고 있었던 것 같다.  
> 계속 lecture 값 두개 다 heap에 저장하고 있었는데  
> 끝나는 시간만 저장해서 정렬된 상태로 사용하기만 하면 된다는걸  
> 나중에 알게 되어서 코드를 수정하니까 통과했다
> 
> 아이디어 자체를 효율적으로 생각 못해서 계속 시간초과가 나는 듯ㅠ
