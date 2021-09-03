# [17070] 파이프 옮기기 1 - JAVA

## :black_circle: Algorithm
**Dynamic Programming, DFS**

## :black_circle: Logic

```Java
    private static void DFS(Pipe pipe){
        if(pipe.x == N && pipe.y == N){ // 종료 조건
            result++;
            return;
        }

        switch (pipe.direction){
            case HORIZONTAL :
                if(pipe.y + 1 <= N && house[pipe.x][pipe.y + 1] == 0)
                    DFS(new Pipe(pipe.x, pipe.y + 1, Direction.HORIZONTAL));
                break;
            case VERTICAL :
                if(pipe.x + 1 <= N && house[pipe.x + 1][pipe.y] == 0)
                    DFS(new Pipe(pipe.x + 1, pipe.y, Direction.VERTICAL));
                break;
            case DIAGONAL :
                if(pipe.y + 1 <= N && house[pipe.x][pipe.y + 1] == 0)
                    DFS(new Pipe(pipe.x, pipe.y + 1, Direction.HORIZONTAL));
                if(pipe.x + 1 <= N && house[pipe.x + 1][pipe.y] == 0)
                    DFS(new Pipe(pipe.x + 1, pipe.y, Direction.VERTICAL));
                break;
        }
        if(pipe.y + 1 <= N && pipe.x + 1 <= N && house[pipe.x][pipe.y + 1] == 0 && house[pipe.x + 1][pipe.y] == 0 && house[pipe.x + 1][pipe.y + 1] == 0)
            DFS(new Pipe(pipe.x + 1, pipe.y + 1, Direction.DIAGONAL));
    }
```

DFS 를 활용하여 풀었던 문제  
파이프의 상태를 세가지의 경우로 나눠서  
가로로 놓여있을 때에는 오른쪽과, 대각선 아래로 움직일 수 있고,  
세로로 놓여있을 때에는 아래쪽과, 대각선 아래로 움직일 수 있고,  
대각선으로 놓여있을 때에는 오른쪽, 아래쪽, 대각선 아래로 움직일 수 있다.

## :black_circle: Review
생각해내는데 까지 오래 걸렸다.  
앞으로 문제를 좀더 객체 지향적으로 푸는 법을 연습해봐야겠다.