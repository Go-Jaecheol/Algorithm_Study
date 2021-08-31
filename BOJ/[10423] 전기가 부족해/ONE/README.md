# [10423] 전기가 부족해 - JAVA

## :black_circle: Algorithm
**Kruskal Algorithm**

## :black_circle: Logic
### `Kruskal`

```Java
    private static int find(int n){
        if(parent[n] == -1)
            return  -1;
        else if(parent[n] == n)
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
이 문제는 특정 노드가 발전소 이기 때문에 다른 노드와 다르게  
초기 부모 노드를 자신이 아닌 -1 로 설정하여  
find 에 -1 일 경우, 즉 발전소 일 경우를 추가하여 푼 최소 스패닝 트리 문제