# [10775] 공항 - Python

## :mag: Algorithm
**Greedy Algorithm, Disjoint Set**

## :computer: Logic
### `Greedy`

```Python
def find(num):
    if num == parent[num]:
        return num
    parent[num] = find(parent[num])
    return parent[num]
```
- **해당 num의 루트 노드를 구하는 함수**  
  * `parent[num]`이 `num`과 같다면 그냥 `num`을 **return**  
  * 아니면 **루트 노드**를 찾을 때까지 **재귀**  
  * **루트 노드**를 반환  
---

```Python
def union(n1, n2):
    p1 = find(n1)
    p2 = find(n2)
    if p1 < p2:
        parent[p2] = p1
    else:
        parent[p1] = p2
```
- **두 분리 집합을 합치는 함수**  
  * `n1, n2`에 해당하는 **루트 노드**를 `find()` 함수를 이용해 찾고 `p1, p2`에 저장  
  * `p1, p2`를 비교해서 **작은 노드**를 기준으로 연결  
---

```Python
for i in range(P):
    num = find(gi[i])
    if not num:
        break
    union(num, num-1)
    count += 1
print(count)
```
- **두 분리 집합을 합치는 함수**  
  * 비행기가 갈 수 있는 **gi**를 기준으로  
  * `find(gi[i])`가 ***0***이 아니면 **1 작은 값**과 `union()`한 뒤 `count++`  
  * (이 때 비행기는 `find(gi[i])` **게이트**에 **도킹** 됨)  
  * `find(gi[i])`가 ***0***이면 더이상 도킹을 할 수 없으므로 **break**  
---

## :memo: Review
> 분리 집합에 대해서 몰랐어서  
> 개념을 이해하는데 시간이 걸렸던 것 같다.  
> 
> 사실상 내가 풀었다기보다는 분리 집합이라는 알고리즘에 대해  
> 이해하게 되는 문제였음..
