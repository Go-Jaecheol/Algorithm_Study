# [17472] 다리 만들기 2 - JAVA

## :black_circle: Algorithm
**BFS**, **Kruskal**

## :black_circle: Logic

- N X M 크기의 지도에 섬이 여러개 있다
- 섬끼리 연결하는 다리는 **직선으로 가로 또는 세로**만 만들 수 있고 길이는 2 이상이어야 한다
- 모든 섬을 연결하는 다리 길이의 최솟값


> _Key Idea_
> - 지도에 있는 섬을 파악하기 위해 **BFS**를 사용해서 섬의 가장자리 _Point_ 들을 _Island_ 객체 하나에 저장
> - _Island_ 객체들 간의 _Point_ 를 비교하여 수직 수평에 있는 점들 사이의 거리를 구하여 2 이상인 것들을 추려내어
> - _Island_ 2개의 인덱스와 둘간의 거리를 저장한 Edge 객체를 생성하여 **우선순위 큐**에 삽입한다
> - 이후 _union_ , _find_ 를 이용하여 섬간 연결 거리의 최솟값을 구한다
> - 모든 섬을 연결하는 다리들이 최소거리 일 때, 이 다리들의 개수는 `섬의 개수보다 하나 작은 값`이 된다
> - 따라서, 모든 섬을 연결하는 것이 불가능 한 경우는 다리의 개수가 `섬의 개수 - 1`가 아닐 때가 된다

- *map* 을 반복문 돌면서 만약 1인 부분을 만나게 되면,
- 그 지점부터 **BFS**를 수행하여 해당 _Point_ 가 섬의 가장자리인지를 판단한다
- 가장자리는 map의 값이 1이면서 상하좌우중 0의 값이 한개라도 있는 _Point_ 이다

```Java
    private static void BFS(int x, int y, ArrayList<Point> tempPoints){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(x, y);

        queue.add(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()){
            Point current = queue.poll();
            boolean check = false;

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                    else
                        check = true;
                }
            }
            if(check)
                tempPoints.add(current);
        }
    }
```

- 가장자리 _Point_ 들로 이루어진 _Island_ 객체들의 _Point_ 들을 비교하여
- 만약 _Point_ 끼리 서로 같은 행 또는 열에 있고,
- 거리가 2가 넘으면서 사이에 섬이 있는지를 검사한다
- 만약 조건에 해당된다면 _Island_ 객체의 각각의 인덱스와 다리의 길이를 우선순위 큐에 저장한다

```Java
    private static void bridge(){
        for(int i = 0; i < islands.size() - 1; i++)
            for (int j = i + 1; j < islands.size(); j++)
                for(Point a : islands.get(i).points)
                    for(Point b : islands.get(j).points)
                        if(a.x == b.x || a.y == b.y){
                            int distance = Math.abs(a.x - b.x) + Math.abs(a.y - b. y) - 1;
                            if(distance >= 2 && !isIsland(a, b))
                                priorityQueue.add(new Edge(i, j, distance));
                        }
```

- 우선순위 큐에서 하나씩 _Edge_ 를 꺼내서
- 만약 _Island_ 객체간의 부모 노드가 다르다면
- 서로 _union_ 해주며 결과값에 가중치를 더해준다
- 그리고 _union_ 할때마다 cnt++ 해주어 만들어 지는 다리의 개수를 센다
- 만약 _result_ 가 `islands.size() - 1`가 아니라면 모든 섬을 연결할 수 없는 경우이므로 값을 -1로 바꿔준다

```Java
        while(!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();

            if(find(current.u) != find(current.v)){
                union(current.u, current.v);
                result += current.w;
                cnt++;
            }
        }

        if(cnt != islands.size() - 1)
            result = -1;
```


## :black_circle: Review
이전에 풀어봤던 `다리만들기` 문제와 `최소스패닝트리`의 응용문제 였다  
문제 자체는 이전에 풀어본것을 합치는 느낌이라 어렵지 않았던 것 같다