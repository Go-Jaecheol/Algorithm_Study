# [1647] 도시 분할 계획 - JAVA

## :black_circle: Algorithm
**Kruskal Algorithm**

## :black_circle: Logic
### `Kruskal`

```Java
    private static int find(int n){
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int a, int b){
        int parent_a = find(a), parent_b = find(b);

        if(parent_a < parent_b)
            parent[parent_b] = parent_a;
        else
            parent[parent_a] = parent_b;
    }
```

- **find : 부모 노드를 찾는 함수, union : 노드를 집합으로 합치는 함수**

## :black_circle: Review
앞서 풀었던 MST 문제와 유사했고,  
최댓값만 빼주면 되는 아이디어가 금방 생각나서 쉽게 풀었던 문제