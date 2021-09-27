# [19236] 청소년 상어 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Fish{
    int x;
    int y;
    int num;
    int direction;

    public Fish(int x, int y, int num, int direction){
        this.x = x;
        this.y = y;
        this.num = num;
        this.direction = direction;
    }
}
```

물고기(상어 포함)의 좌표(x, y), 번호, 방향 정보를 담은 객체 생성
번호는 3가지의 경우로 나누어짐  
-1 : 상어가 위치  
0 : 물고기도 상어도 없는 위치  
1~16: 각 번호에 해당하는 물고기들의 위치

```Java
    private static void teenShark(Fish[][] fish, Fish shark, int sum){
        max = Math.max(max, sum);
        moveFish(fish);

        Queue<Fish> queue = new LinkedList<>();

        int nx = shark.x;
        int ny = shark.y;
        for(int i = 0; i < 4; i++){
            nx += dx[shark.direction];
            ny += dy[shark.direction];
            if(nx >= 0 && ny >= 0 && nx < 4 && ny <4 && fish[nx][ny].num != 0)
                queue.add(new Fish(nx, ny, fish[nx][ny].num, fish[nx][ny].direction));
        }

        while(!queue.isEmpty()){
            Fish current = queue.poll();
            Fish tempShark = new Fish(shark.x, shark.y, shark.num, shark.direction);
            Fish[][] tempFish = copyMatrix(fish);

            tempFish[tempShark.x][tempShark.y].num = 0;

            tempShark.x = current.x;
            tempShark.y = current.y;
            tempShark.direction = current.direction;
            int tempSum = sum + tempFish[current.x][current.y].num;

            tempFish[tempShark.x][tempShark.y].num = -1;

            teenShark(tempFish, tempShark, tempSum);
        }
    }
```

물고기들 이동시킨 후,  
상어의 방향쪽에 있는 물고기들을 검사하여 큐에 삽입  
큐에서 하나씩 물고기를 가져와 상어와 물고기들의 정보를 복사하여  
상어의 이동 실행 후 함수를 재귀

## :black_circle: Review
처음에 DFS를 구현할 때 복원 또는 복사를 하지않고  
재귀만 해서 답이 계속해서 다르게 나왔었다  
이번에 확실히 깨달아서 다음번에 같은유형이 나온다면 안틀려야지..