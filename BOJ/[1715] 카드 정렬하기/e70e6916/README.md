# [1715] 카드 정렬하기 - Python

## :mag: Algorithm

**Greedy**


**priority queue**


## :round_pushpin: Logic

```heapq.heapify(cards)``` **heaqp.heapify**로 입력받은 카드 묶음의 크기들 ```cards```를 **Min Heap**으로 변환한다.

 
```python
    while len(cards) > 1:
        card_sum = heapq.heappop(cards) + heapq.heappop(cards)
        heapq.heappush(cards, card_sum)
        final_sum += card_sum
    print(final_sum)
```
```heapq.heappop(cards)```을 두번하여 나온 최소값 두개의 합 ```card_sum```을 다시
```cards```에 **heappush**한다.


그리고 ```fianl_sum```에  ```card_sum```을 더해주며 업데이트 해준다.


```cards```의 **원소가 1개**일 때까지 이를 반복하고 종료되면 최종 업데이트 된 ```fianl_sum```을 출력한다.


## :memo: Review

**배** 문제를 풀 때 이용했던 ***heapq***를 이용했더니 금방 해결할 수 있었다.
아이디어 떠올리는 것도 쉬웠고, 코드로 구현하는 것 또한 너무 쉬웠다.
