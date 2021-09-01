# [2146] 다리 만들기 - JAVA

## :black_circle: Algorithm
**BFS**

## :black_circle: Logic

```Java
class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Island{
    ArrayList<Point> points;

    public Island(ArrayList<Point> points){
        this.points = points;
    }
}
```
위치를 저장하는 Point 객체와  
섬의 가장자리 Point들을 가지는 Island 객체
```Java
    private static void BFS(int x, int y, ArrayList<Point> temp){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(x, y);

        queue.add(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()){
            Point current = queue.poll();
            boolean check = false; // 해당 Point 가 가장자리인지 확인하기 위한 check

            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= N && ny <= N && !visited[nx][ny]){ // N X N 범위에 있고 방문하지 않았지만
                    if(country[nx][ny] == 1){ // 1인 경우 -> 옮겨갈 수 있는 블록
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                    else // 하나라도 0인 경우 -> 가장자리 블록이라는 뜻
                        check = true;
                }
            }
            if(check){ // 가장자리 블록을 Point 배열에 넣음
                temp.add(current);
            }
        }
    }
```
BFS를 이용하여 섬의 가장자리 Point를 찾아서 각 Island 객체에 삽입한다.
```Java
    private static void bridge(){
        for(int i = 0; i < islands.size() - 1; i++)   // 섬끼리 비교
            for(int j = i + 1; j < islands.size();j ++)
                for(Point a : islands.get(i).points) // 섬의 가장자리 Point 를 각각 비교하여 최솟값 도출
                    for(Point b : islands.get(j).points){
                        int distance = Math.abs(a.x - b.x) + Math.abs(a.y - b. y) - 1;
                        if(distance < result)
                            result = distance;
                    }
    }
```
각 Island 의 Point 들을 비교하면서 최솟값 찾기
## :black_circle: Review
풀이를 생각해서 생각한대로 풀이해서 한방에 풀려서 기분이 좋았다!  
앞으로는 이런 문제가 많아지면 좋겠다