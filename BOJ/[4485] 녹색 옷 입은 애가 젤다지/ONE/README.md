# [1916] 최소비용 구하기 - JAVA

## :black_circle: Algorithm
**Dijkstra Algorithm, Priority Queue**

## :black_circle: Logic
### `Dijkstra`

```Java
    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0,0,cave[0][0]));
        resultCave[0][0] = cave[0][0];

        while (!queue.isEmpty()){

            Node current = queue.poll();

            int x = current.x;
            int y = current.y;
            int weight = current.weight;

            if(check[x][y]) continue;
            check[x][y] = true;

            for(int i = 0; i < 4; i++){ // dx ,dy 의 상하좌우
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < N) // in cave
                    if(resultCave[next_x][next_y] > weight + cave[next_x][next_y]){
                        resultCave[next_x][next_y] = weight + cave[next_x][next_y];
                        queue.add(new Node(next_x, next_y, resultCave[next_x][next_y]));
                    }
            }

        }
    }
```

- **우선순위 큐를 이용한 다익스트라 알고리즘 함수**

## :black_circle: Review
앞에 풀었던 다익스트라 문제에서 상하좌우만 추가해서 2차원배열로 생각해서 푼 문제  
생각보다 금방 풀어서 어렵지 않았다  
파이썬으로도 문제를 풀어봐야하는데 밀린 문제가 많아 일단 자바로만 푸는중...
