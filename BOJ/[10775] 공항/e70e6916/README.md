# [10775] 공항 - Python

## :mag: Algorithm

**Greedy**

**Disjoint Set**

## :round_pushpin: Logic

**Disjoint set** 표현을 위해 **Union-Find** 자료구조를 이용했다.

```python
    def __init__(self, n):
            self.parent = [-1 for _ in range(n)]
            self.count = 0
```
```disjoint_set``` class의 객체를 만듬으로, 게이트 수 + 1의 크기를 가지며 -1로 초기화 된 list ```parent```를 가진다.


```python
    def find(self, i): 
            if self.parent[i] < 0:
                return i
            self.parent[i] = self.find(self.parent[i])
            return self.parent[i]
```
```find``` 메소드를 통해 list ```parent```의 부모를 **recursion**로 찾되, 값이 0보다 작은 경우 return한다. 

```find``` 메소드의 3번째 줄 ```self.parent[i] = self.find(self.parent[i])```을 통해 **path compression**을 함으로써 **불필요한 recursion을 줄인다.** (이를 통해 **시간초과** 해결)
 

```python
    def union(self, i):
            self.parent[i] = i-1
            self.count += 1
```
```find``` 메소드가 종료되면서 return한 값을 parameter로 보내어 **자신의 인덱스의 -1한 값을 부모로 설정**하고, ```count```를 +1한다. 


```python
    gate = disjoint_set(G+1)
    for i in range(P):
        docking = gate.find(g[i])
        if docking == 0: break
        gate.union(docking)
    print(gate.count)    
```
위 과정들을 비행기 수 만큼 반복하며 Disjoint set을 한다. 만약, ```find``` 메소드의 **return한 값이 0**일 경우 (**root node가 0** = 비행기가 어느 게이트에도 도킹할 수 없음) break하여 ```count```를 출력한다. 


## :memo: Review

Disjoint set을 자료구조 수업 때 배웠긴 한데 기억이 가물가물했다. 구글링으로 새로 익히고 Union-Find 자료구조를 이용한 아이디어를 떠올려 구현했지만 Find에서의 **recursion 중복**으로 시간초과가 났다. 그래서 path compression을 이용해 리스트의 값들이 직계 부모가 아닌 root node를 가리키게 했고, 문제를 해결할 수 있었다. 

Disjoint set도 익히고, 함수로 표현해도 되지만 class를 써보고 싶어 처음으로 이용해보기도 하여 꽤 유익했던 문제였다..
