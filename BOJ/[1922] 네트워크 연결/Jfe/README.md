# [1922] 네트워크 연결 - Python

## :mag: Algorithm
**Kruskal Algorithm**

## :computer: Logic
### `Kruskal`

```Python
def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]
```
- **해당 x의 루트 노드를 구하는 함수**  
---

```Python
def union(a, b):
    a = find(a)
    b = find(b)
    if(a < b):
        parent[b] = a
    else:
        parent[a] = b
```
- **두 분리 집합을 합치는 함수**  
---

```Python
while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        union(A, B)
        result += C
print(result)
```
- **우선순위 큐를 이용한 kruskal 구현**  
  * 사이클인 경우는 포함하지 않기 때문에  
  * A, B의 parent가 다르면 union  
  * result에 값들 저장 후 마지막에 출력  

---

## :memo: Review
> [[1197] 최소 스패닝 트리](https://github.com/Go-Jaecheol/Algorithm_Study/tree/main/BOJ/%5B1197%5D%20%EC%B5%9C%EC%86%8C%20%EC%8A%A4%ED%8C%A8%EB%8B%9D%20%ED%8A%B8%EB%A6%AC/Jfe) 와 같은 알고리즘 사용  
