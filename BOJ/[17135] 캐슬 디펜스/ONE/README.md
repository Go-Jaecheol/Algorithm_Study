# [17135] 캐슬 디펜스 - JAVA

## :black_circle: Algorithm
**브루트 포스**, **DFS**

## :black_circle: Logic

- 거리가 D 이하인 적중에서 가장 가까운 적을 공격한다
- 만약 위의 경우가 여럿일 경우, 가장 왼쪽의 적을 공격
- _여러명의 궁수에게 공격 당하는 것이 가능_
- 궁수의 자리가 **1 ~ M 중에서 3개를 뽑는 조합** 문제 
- *궁수의 공격으로 제외되는 적* 의 최대수 구하기


- 궁수 3명의 위치를 저장한 객체배열을 이용하여 반복문을 돌린다
- 거리가 가장 가까운 적을 찾아야 하기때문에, 적이 있으면 거리를 비교하여 더 적은 거리라면 최소 거리의 적의 위치를 갱신한다
- 만약 같은거리라면 열의 값을 비교하여 더 왼쪽의 위치를 선택하여 갱신한다
- 가장 가까운 적의 위치를 찾은 후 거리가 D 이하라면 indexToKill 의 배열의 위치를 true로 바꿔준다
```Java
            for(Node archer : archers){
                Node enemy = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
                int enemyD = Integer.MAX_VALUE;

                for(int i = 1; i <= N; i++)
                    for(int j = 1; j <= M; j++)
                        if(copiedGame[i][j] == 1){
                            if(enemyD > enemyDistance(archer, i, j)){
                                enemy.r = i;
                                enemy.c = j;
                                enemyD = enemyDistance(archer, i, j);
                            }
                            if(enemyD == enemyDistance(archer, i, j))
                                if(enemy.c > j){
                                    enemy.r = i;
                                    enemy.c = j;
                                }
                        }
                if(enemyD <= D)
                    indexToKill[enemy.r][enemy.c] = true;
            }
```

- 위에서 적을 공격하고 바로 0으로 안바꾸는 것은 **한 적을 여러 궁수가 공격할 수 있기 때문에**
- 먼저 indexToKill 배열에서 위치만 지정하고 이후에 배열의 값을 0으로 바꿔주고 궁수에게 공격당한 적의 수를 카운트 해준다
```Java
            for(int i = 1; i <= N; i++)
                for(int j = 1; j <= M; j++)
                    if(indexToKill[i][j]){
                        copiedGame[i][j] = 0;
                        killByArcher++;
                    }
            moveEnemies(copiedGame);
```

- 조합을 이용하여 M개의 자리중에서 3자리를 뽑는 것을 재귀로 구현
- 인덱스 3개를 뽑은 후 game 배열을 복사하여 N + 1 줄에 궁수를 -1의 값으로 넣어준다

```Java
    private static void DFS(int depth){
        if(depth == 3){
            int[][] tmpGame = copyGame();
            for(int index : order)
                tmpGame[N + 1][index] = -1;
            play(tmpGame);
            return;
        }
        for(int i = 1; i <= M; i++)
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
    }
```

## :black_circle: Review
처음에는 배열이 아니라 객체로 적들과 궁수를 배열로 하려고 했는데,  
하다보니까 도저히 객체배열로는 막히는 부분이 있고 아무래도 그냥 배열이 더 편한 것 같아서  
코드를 갈아엎고 다시 작성했고, 최소의 거리의 적을 찾는 원리를 생각하는데 시간이 걸린것 같다