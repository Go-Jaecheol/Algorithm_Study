# [1781] 컵라면 - Python

## :mag: Algorithm

**Greedy**

**Priority Queue**

## :round_pushpin: Logic

```python
    for deadline, cup_noodle in sorted(problems):
        heapq.heappush(heap, cup_noodle)
        if len(heap) > deadline:
            heapq.heappop(heap)
    print(sum(heap))
```

1. 입력받은 문제들을 데드라인을 기준으로 오름차순 정렬한다.

2. 이를 for 반복문으로 돌며 ```heap```에 컵라면 수를 heappush한다.

3. 만약, heappush 후 ```heap```의 size보다 데드라인이 더 클 경우 ```heap```에
heappop한다.

4. 반복문이 종료된 후 ```heap```의 모든 원소의 합을 출력한다.


## :memo: Review

아이디어 찾는 데 많은 시간을 소요했다... 찾고 나니 생각보다 어려운 문제가 아니여서 당황했다.

우선순위 큐를 접목한 아이디어를 빠르게 생각해 내는 것에 아직 많이 미숙한 듯 하다.
