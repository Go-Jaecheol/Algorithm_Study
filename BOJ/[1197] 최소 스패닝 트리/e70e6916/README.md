# [1197] 최소 스패닝 트리 - Python

## :mag: Algorithm

**MST**

**Kruskal**

**Disjoint set**

## :round_pushpin: Logic
weight값으로 정렬 후 disjoint set의 find를 통해 두 vertex의 parent를 return 받아 그 값이 다를 경우, 즉 cycle이 생기지 않았을 때
disjoint set의 union으로 두 vertex를 합친다. (두번째 vertext v의 parent를 첫번째 vertex u로 한다.)

이를 graph 정보만큼 반복하며, wedge 수가 vertex-1과 같게 되면 종료한다.

## :memo: Review
기존에 알고 있던 Disjoint set을 활용하여 Kruskal 알고리즘을 이용했다. MST의 기초가 되는 문제라
쉬웠다.