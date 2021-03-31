# [4485] 녹색 옷 입은 애가 젤다지? - Python

## :mag: Algorithm

**Dijkstra**


## :round_pushpin: Logic

**priority queue**를 이용한 **dijkstra 알고리즘**으로 **Shortest Path**```SP```를 구하여 목적지까지의 최단비용```SP[-1][-1]``` 출력.

(이때, SP는 2차원 배열이며 Graph 또한 2차원 배열로 구현했으므로 ```direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]```을 통해 상하좌우로 이동한다.)


## :memo: Review

이전 Dijkstra 문제와 다른 점은 입력 받은 Graph가 2차원 배열이며 상하좌우로 이동할 수 있다는 것 뿐, 거의 비슷하다.
