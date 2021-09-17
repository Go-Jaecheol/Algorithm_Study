# [17144] 미세먼지 안녕! - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
    private static void spreading(){
        int[][] tmp = new int[R][C];
        Queue<Dust> dusts = new LinkedList<>();

        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if(room[i][j] != 0) {
                    if(room[i][j] == -1)
                        tmp[i][j] = -1;
                    else
                        dusts.add(new Dust(i, j, room[i][j]));
                }
        while(!dusts.isEmpty()){
            Dust dust = dusts.poll();

            int count = 0;
            for(int i = 0; i < 4; i++){
                int nx = dust.row + dx[i];
                int ny = dust.col + dy[i];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C && room[nx][ny] != -1){
                    tmp[nx][ny] += dust.amount / 5;
                    count++;
                }
            }
            tmp[dust.row][dust.col] += dust.amount - (dust.amount / 5) * count;
        }
        room = tmp;
    }
```
먼지의 위치와 먼지의 양을 가진 객체를 저장하는 큐 생성  
빈 2차원 배열에 각 조건을 검사하여 각 먼지의 먼지양을 덧셈
계산이 끝난 2차원 배열을 원래 2차원 배열에 복사

```Java
    private static void purification(){
        // 위의 경우와 아래의 경우로 나누어 생각
        for(int i = airCleaner.get(0) - 1; i > 0; i--)
            room[i][0] = room[i - 1][0];
        for(int i = 0; i < C - 1; i++)
            room[0][i] = room[0][i + 1];
        for(int i = 0; i < airCleaner.get(0); i++)
            room[i][C - 1] = room[i + 1][C - 1];
        for(int i = C - 1; i > 1; i--)
            room[airCleaner.get(0)][i] = room[airCleaner.get(0)][i - 1];
        room[airCleaner.get(0)][1] = 0;

        for(int i = airCleaner.get(1) + 1; i < R - 1; i++)
            room[i][0] = room[i + 1][0];
        for(int i = 0; i < C - 1; i++)
            room[R - 1][i] = room[R - 1][i + 1];
        for(int i = R - 1; i > airCleaner.get(1); i--)
            room[i][C - 1] = room[i - 1][C - 1];
        for(int i = C - 1; i > 1; i--)
            room[airCleaner.get(1)][i] = room[airCleaner.get(1)][i - 1];
        room[airCleaner.get(1)][1] = 0;
    }
```

시계방향, 반시계방향의 두가지 경우로 나누어  
거꾸로 따라가며 한칸씩 앞으로 당기기

## :black_circle: Review
시계 반시계 방향에서 따라가보면서 구현 자체는 어렵지 않았다.  
크게 어렵지 않은 문제