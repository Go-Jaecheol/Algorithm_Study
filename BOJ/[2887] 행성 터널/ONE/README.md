# [2887] 행성 터널 - JAVA

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
처음에는 일반적인 방식으로 2차원 배열을 만들어 일일이 좌표값을 비교해가며  
풀었었는데 N 이 100000일 경우에는 100000 X 100000이 돼버려 메모리 초과가 났다.  
그래서 방식을 바꿔서 각 x, y, z 마다 차의 최솟값으로 정렬하여 N 만큼 우선순위 큐에 넣어서 진행하였다.