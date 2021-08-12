# [1753] 최단경로 - JAVA

## :black_circle: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :black_circle: Logic
### `Dijkstra`

```Java
    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];

        queue.add(new Node(start,0)); // 시작점을 0으로 초기화
        dist[start] = 0;

        while (!queue.isEmpty()){
            Node current = queue.poll();
            int cur = current.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node:list[cur])
                if (dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
        }
    }
```
- **우선순위 큐를 이용한 다익스트라 알고리즘 함수**

## :black_circle: Review
1학기 중간고사 이후 3달만에 풀어본 알고리즘 문제...  
오랜만에 풀어서 그런지 기억이 나지 않아서 알고리즘 수업 때의 강의자료를 봐가면서 했다  
막상 기억나니까 풀렸던 문제이지만 뭔가 알고리즘 쪽으로 뇌가 완전히 굳어버린 느낌  
문제를 많이 풀어봐야겠다...
