# [14503] 로봇 청소기 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Robot{
    int row;
    int col;
    int direction; // 0:북, 1:동, 2:남, 3:서

    public Robot(int row, int col, int direction){
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}
```

로봇 청소기의 위치와 방향을 저장하는 Robot 객체 선언

```Java
        switch (robot.direction){ // 현재 방향을 기준으로 왼쪽부터 탐색
            case 0: // 현재 방향이 북쪽 -> 서쪽부터 탐색 (r, c-1)
                if(robot.col - 1 >= 0 && room[robot.row][robot.col - 1] == 0 && !visited[robot.row][robot.col - 1]){
                    count = 1;
                    cleaning(new Robot(robot.row, robot.col - 1, 3));
                }
                else {
                    count++;
                    cleaning(new Robot(robot.row, robot.col, 3));
                }
                break;
```

현재 보고있는 방향의 경우를 4가지로 나누어서  
각각 해당하는 조건으로 검사하여 이동 가능할경우 이동하고 재귀호출  
이동할 수 없다면 제자리에서 방향만 바꾸고  
이동하지 못하는 횟수를 세는 count 변수를 ++

```Java
        if(count > 4){ // 네 방향 모두 청소할 수 없을 때, 보고 있는 방향을 유지하면서 뒤로 한칸
            switch (robot.direction){
                case 0: // 남쪽으로 한칸 후진 (r+1, c)
                    if(robot.row + 1 < N && room[robot.row + 1][robot.col] == 0){
                        count = 1;
                        cleaning(new Robot(robot.row + 1, robot.col, robot.direction));
                    }
                    break;
```

count 가 4보다 클 때, 즉 네 방향 모두 이동할 수 없을 때,  
현재 보고 있는 방향을 기준으로 후진하는 방향에 있는 곳이 벽이 아니면  
count 를 1로 초기화 한후 방향을 유지한채 이동  
만약에 벽이라서 후진할 수 없다면 그대로 종료

## :black_circle: Review
이번에도 톱니바퀴 문제와 비슷하게 엉뚱한 틀려서  
계속 오버플로우가 났다.. count 조건을 4를 포함시키면 안되는데  
자꾸 포함시켰어서 시간을 허비했다... 앞으로 좀 더 조건을 꼼꼼히 봐야할 것 같다