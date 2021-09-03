# [11559] Puyo Puyo - JAVA

## :black_circle: Algorithm
**BFS**

## :black_circle: Logic

```Java
    private static void puyo_BFS(int x, int y, char color){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()){
            Point current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || field[nx][ny] != color)
                    continue;

                // 이전에 개수를 셀때 방문했고, 색상이 같으면 . 으로 변환
                if(visited[nx][ny] && field[nx][ny] == color){
                    field[nx][ny] = '.';
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
```

먼저 BFS로 탐색을 하는데 같은 색이 4개 이상일경우  
연쇄 수를 증가시키고 색을 제거 한뒤 세로로 제거한자리를 위에서 아래로 채운다

## :black_circle: Review
비슷한 원리로 문제를 풀었으나, 시간초과가 계속나서 힌트를 얻었던 문제  
생각을 코드로 구현하기가 어려운것 같다