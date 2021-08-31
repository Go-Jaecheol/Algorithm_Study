# [1197] 최소 스패닝 트리 - JAVA

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
MST 문제를 기억이 안나 알고리즘 강의자료를 찾아보고,  
기억을 되살려서 풀었던 문제  
Kruskal 알고리즘을 이용해서 풀었는데 크게 어렵지는 않았던 것 같다