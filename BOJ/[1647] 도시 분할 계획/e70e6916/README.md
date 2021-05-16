# [1647] 도시 분할 계획 - Python

## :mag: Algorithm

**MST**

**Kruskal**

**Disjoint set**

## :round_pushpin: Logic
weight값으로 정렬 후 disjoint set의 find를 통해 두 vertex의 parent를 return 받아 그 값이 다를 경우, 즉 cycle이 생기지 않았을 때
disjoint set의 union으로 두 vertex를 합친다. (두번째 vertext v의 parent를 첫번째 vertex u로 한다.)

이를 graph 정보만큼 반복하며 , wedge 수가 vertex-1과 같게 되면 종료한다.

그리고 마지막으로 총 MST cost에서 가장 큰 cost를 뺀 값을 출력한다.

## :memo: Review
전에 풀었던 MST문제에서 총 const에서 가장 큰 cost를 뺀 값을 출력하는 것을 제외하고는 똑같은 양상이었다.