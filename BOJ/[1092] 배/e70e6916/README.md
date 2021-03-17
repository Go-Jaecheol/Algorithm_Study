# [1092] 배 - Python

## :mag: Algorithm

**Greedy**


**priority queue**


## :round_pushpin: Logic

1. 입력 받은 ```cranes```는 오름차순 정렬, ```boxes```는 내림차순 정렬을 한다.


2. ```cranes[-1]```보다 ```boxes[0]```이 크다면 -1을 출력하고, 그렇지 않을 경우
```move_box()```를 호출한다.


3. 
```python
    def move_box():
        crane_heap = []
        for i in range(M):
            while cranes and cranes[-1] >= boxes[i]:
                heapq.heappush(crane_heap, (0, cranes.pop()))
            time, crane = heapq.heappop(crane_heap)
            heapq.heappush(crane_heap, (time+1, crane))
        return max(crane_heap)[0]
```
**heap** ```crane_heap```을 만든 후, ```cranes```와 ```boxes```의 원소들을 비교한다.

```cranes```의 원소가 ```boxes```의 원소보다 크거나 같을 경우 ```cranes```의 해당 원소를 **time을 나타내는 0과 함께 튜플로 묶어** ```crane_heap```에 **heappush**한다. 

```boxes```의 원소 하나와 ```cranes```의 모든 원소의 비교가 끝나면, ```crane_heap```에 **heappop하여 time을 +1 해주고 다시 heappush한다.**

이 과정을 ```boxes```의 모든 원소와 비교하는 for문이 종료될 떄까지 반복한 후, ```crane_heap```의 원소들의
**가장 큰 time**을 출력한다.


## :memo: Review

처음에는 크레인과 박스를 모두 내림차순 정렬하여 while과 2중 for문을 이용하는 방법으로 구현했다. 그러자 python3에서는 시간초과가
나고 pypy3에서만 맞았다.


그래서 시간을 줄이기 위해 고민을 하다 **queue를 이용하는 방법**이 떠올라 도전했지만 코드를 작성할수록 신경 써야 할 부분이 너무 많아졌다.
그러다 지난번에 써먹었던 **heapq**가 생각났고 이를 사용하여 새 방법으로 시도하니 python3에서도 맞을 수 있었다.


정렬을 이용하는 문제는 heapq가 많이 유용한거 같다. 아이디어에 접목하여 자주 써먹어야겠다. 
