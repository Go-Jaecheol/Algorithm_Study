# [20057] 마법사 상어와 토네이도 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
    public static void tornado(){
        int count = 2, direction = 0;

        for(int i = 1; i < N; i++){
            if(i == N - 1)
                count = 3;
            for(int j = 0; j < count; j++){
                for(int k = 0; k < i; k++){
                    int originSand, alpha;

                    nx += dx[direction];
                    ny += dy[direction];

                    originSand = sand[nx][ny];
                    alpha = originSand;
                    sand[nx][ny] = 0;

                    for(MovingSand movingSand : scattering.get(direction)){
                        int mowedSand = (int)(originSand * movingSand.percent * 0.01);
                        if(nx + movingSand.x >= 0 && ny + movingSand.y >= 0 && nx + movingSand.x < N && ny + movingSand.y < N)
                            sand[nx + movingSand.x][ny + movingSand.y] += mowedSand;
                        else
                            sum += mowedSand;
                        alpha -= mowedSand;
                    }

                    if(nx + dx[direction] >= 0 && ny + dy[direction] >= 0 && nx + dx[direction] < N && ny + dy[direction] < N)
                        sand[nx + dx[direction]][ny + dy[direction]] += alpha;
                    else
                        sum += alpha;
                }
                direction = (direction + 1) % 4;
            }
        }
    }
```

토네이도가 회전하는 규칙이 앞으로 가는 횟수가   
1 1 2 2 3 3 4 4 ... N-1 N-1 N-1 인걸 이용해서 반복문 구현  

조건대로 이동후 격자 밖으로 나간것을 더해주면 됨

## :black_circle: Review
조건에 맞게 구현만 하면 되는 문제  
시뮬레이션 재밌다!