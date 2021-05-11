# [1647] 도시 분할 계획 - Python

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
last_value = 0
while h:
    C, A, B = heapq.heappop(h)
    if find(A) != find(B):
        union(A, B)
        result += C
        last_value = C
print(result - last_value)
```
- **우선순위 큐를 이용한 kruskal 구현**  
  * 사이클인 경우는 포함하지 않기 때문에  
  * A, B의 parent가 다르면 union  
  * 마을을 2개로 분리해야 하기 때문에  
  * 유지비를 최소로 하면서 분리하는 방법은 MST에서 마지막 길을 없애서 2개로 분리하면 됨  
  * result에 값들 저장 후 마지막에 last_value 뺀 값 출력  

---

## :memo: Review
> 마을을 2개로 나누는 최적의 방법을 찾는 문제  
> 
> 마을은 집이 하나만 존재해도 되기 때문에  
> MST의 특성상 마지막 길을 없애서 마을을 2개로 분할하는 방법이  
> 최적의 방법이 된다.  
