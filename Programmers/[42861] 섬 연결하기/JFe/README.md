# [42861] 섬 연결하기 - Python

## 🔍 Algorithm
**Kruskal**

## 💻 Logic

```Python
def find_parent(parent, x):
        if parent[x] != x:
            parent[x] = find_parent(parent, parent[x])
        return parent[x]

def union_parent(parent, a, b):
        a = find_parent(parent, a)
        b = find_parent(parent, b)
        if(a < b):
            parent[b] = a
        else:
            parent[a] = b

def kruskal():
        result = 0
        while h:
            l, (a, b) = heapq.heappop(h)
            if find_parent(parent, a) != find_parent(parent, b):
                union_parent(parent, a, b)
                result += l
        return result
```
- **Kruskal 알고리즘 이용해서 MST 확인하는 함수**  
  우선순위 큐를 이용해서 MST 확인
  모든 노드 방문했는지 확인


## 📝 Review

Minimun Spanning Tree를 만들어야 된다고 생각해서 Kruskal 알고리즘을 떠올렸다.  
얼마 전에 Kruskal 알고리즘으로 문제를 풀었어서 바로 생각해내서 풀 수 있었다.  

