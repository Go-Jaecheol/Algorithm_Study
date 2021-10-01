# [20056] 마법사 상어와 파이어볼 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
    private static void moveFireBall(){
        for (FireBall fireBall : fireBalls) {
            int nx = fireBall.r, ny = fireBall.c;
            countMap[nx][ny]--; // leave current (r,c)

            for (int j = 0; j < fireBall.s; j++) {
                nx += dx[fireBall.d];
                ny += dy[fireBall.d];

                if(nx < 1)
                    nx = N;
                else if(nx > N)
                    nx = 1;
                if(ny < 1)
                    ny = N;
                else if(ny > N)
                    ny = 1;
            }
            fireBall.r = nx;
            fireBall.c = ny;
            countMap[nx][ny]++;
        }
    }
```

반복문 처음에 모든 파이어볼을 이동시킨다  
속도만큼 칸을 이동하기 때문에 속도만큼 반복문을 돌려  
nx 와 ny 의 값을 계속 확인하며 범위 내에서 돌리기  
이동하기전의 카운트 맵 수를 줄이고 이동한후 한개 증가

```Java
    private static void sumAndDecompose(){
        while (!over2Queue.isEmpty()){
            ArrayList<Integer> directions = new ArrayList<>();
            Node node = over2Queue.poll();
            FireBall unitedFireBall = new FireBall(node.x, node.y, 0, 0, 0);

            for(int i = 0; i < countMap[node.x][node.y]; i++){
                int index = findIndex(node);
                unitedFireBall.m += fireBalls.get(index).m;
                unitedFireBall.s += fireBalls.get(index).s;
                directions.add(fireBalls.get(index).d);
                fireBalls.remove(index);
            }

            int dividedMass = unitedFireBall.m / 5;
            int dividedSpeed = unitedFireBall.s / countMap[node.x][node.y];

            if(dividedMass > 0){
                countMap[node.x][node.y] = 4;
                int dir = 0;

                if(!checkOddAndEven(directions))
                    dir = 1;

                for(int j = 0; j < 4; j++){
                    fireBalls.add(new FireBall(node.x, node.y, dividedMass, dividedSpeed, dir));
                    dir += 2;
                }
            }
            else
                countMap[node.x][node.y] = 0;
        }
    }
```

모든 파이어볼이 이동한 후 카운트맵에서 2개가 넘는곳이 있다면
그 위치를 저장하는 큐에 넣고 해당하는 위치의 파이어볼들을 하나씩 찾아  
더한 후 파이어볼의 정보를 리스트에서 삭제

만약 나누어진 파이어볼의 질량이 0이 안된다면 리스트에 파이어볼을 추가하지 않고  
해당 위치의 카운트 맵수를 0으로 변경

## :black_circle: Review
- 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.

이 부분을 이해하기가 어려웠지만 이해하고나서는 금방 구현했던 문제  
새로산 아이패드가 필기가 잘된다!