# [11000] 강의실 배정 - Python

## :mag: Algorithm

**Greedy**


**sort**


**priority queue**


## :round_pushpin: Logic

**우선순위 큐**를 위해 ```heapq``` 모듈을 사용했다. 


먼저, 입력 받은 수업 시간들을 **시작 시간을 기준으로 오름차순 정렬**한다.


```python
heapq.heappush(room, lecture[0][1])
for i in range(1, N):
    if room[0] <= lecture[i][0]:
        heapq.heappop(room)
    heapq.heappush(room, lecture[i][1])
print(len(room))
```
위 코드와 같이 ```heapq```를 이용하여 ```room[0]```(수업이 끝나는 시간이 가장 
작은 값)과 ```lecture[i][0]```(아직 강의실을 배정 받지 못한 수업의 시작하는 시간)을 비교한 후,
기존 강의실에 배정할 수 있다면 ```heapq.heappop()```으로 ```room[0]```을 제거한다. 그리고
```heapq.heappush()```로 ```lecture[i][0]```을 ```room```에 추가한다.


(기존 강의실에 배정할 수 있다면 수업이 끝나는 시간이 가장 작은 수업과 추가하는 수업을 heap에서 교체,
새 강의실이 필요하다면 heap에 수업을 추가.)


N에 대한 for문이 종료되면 최종 업데이트 된 ```room```의 길이를 출력한다.


## :memo: Review

처음엔 2중 for문으로 접근했는데 너무 생각보다 잘풀려서 의아했다. 역시 예상대로 시간초과가 났고,
2중 for문을 사용하지 않기 위해 우선순위 큐가 무엇인지 구글링을 하다 python의 **heapq**에 대해 알게 되었다.


이를 이용하여 한번의 for문으로 해결할 수 있었지만 그럼에도 또 시간초과가 났고, 더이상 여기서 최적화할 수 
없다고 확신을 가질 정도로 방법이 없었다.


python의 시간복잡도에 대해 구글링해보다 반복문을 이용한 입력을 받을 때에는 꼭 ```sys.stdin.readline()```을
이용하라는 것을 보았고, 이를 적용하니 시간초과를 해결할 수 있었다.


**heapq**, **sys.stdin.readline()** 확인...
