# [2887] 전기가 부족해 - Python

## :mag: Algorithm

**MST**

**Kruskal**

**Disjoint set**

## :round_pushpin: Logic
각 행성의 좌표 x, y, z를 각각의 list로 나누어 좌표 값을 입력 받는다. 그 후 각 list를 sort하고,
graph 형식의 input(u, v, weight)으로 바꾸어 graph에 x, y, z의 graph 정보를 모두 append한다.
graph를 weight 기준으로 sort한 후, Kruskal을 진행한다. 

## :memo: Review
이 문제는 input을 graph 형식으로 변환하는 것이 관건이었다. 행성 사이의 거리가 절댓값이라는 것에 집중하여
금방 해결할 수 있었다.