# [1916] 최소비용 구하기 - JAVA

## :black_circle: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :black_circle: Logic
### `Dijkstra`

```Java
    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];

        queue.add(new Node(start, 0)); // 시작점을 0으로 설정
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int cur = current.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node:list[cur])
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
        }
    }
```

- **우선순위 큐를 이용한 다익스트라 알고리즘 함수**

## :black_circle: Review
1753 최단경로와 거의 유사한 문제  
다만 이 문제에서는 dist 배열을 초기화 할 때 10만정도로 했다가   
오류가 계속나서 20분 정도 헤맸다  
결국에는 Integer.MAX_VALUE로 해결했다.
