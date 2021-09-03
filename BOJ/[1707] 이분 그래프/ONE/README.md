# [1707] 이분 그래프 - JAVA

## :black_circle: Algorithm
**DFS**

## :black_circle: Logic

```Java
    private static void DFS(int start, Color color){
        vertices[start].color = color;

        for(int adjVertex : vertices[start].adjList){
            if(color == vertices[adjVertex].color){
                isBipartite = false;
                return;
            }

            if(vertices[adjVertex].color == null){
                if(color == Color.RED)
                    DFS(adjVertex, Color.BLUE);
                else
                    DFS(adjVertex, Color.RED);
            }
        }
    }
```

DFS를 사용  
서로 인접한 정점이 같은색이면 이분그래프가 아니다.  
  
- 정점을 탐색하면서 다른색 칠하기
- 인접 그래프가 같은색 -> 이분그래프가 아님
- 연결 그래프와 비연결 그래프를 생각

## :black_circle: Review
비연결 그래프의 경우를 생각하지 못해 헤맸던 문제  
그래프 탐색이 그래도 DP보다는 풀기 쉬운것 같다...