# [17136] 색종이 붙이기 - JAVA

## :black_circle: Algorithm
**Brute Force**, **DFS**

## :black_circle: Logic

- 한변의 크기가 1~5인 정사각형 각각 5개
- 10X10 크기의 정사각형 종이에 붙이기
- 1이 적힌 칸은 종이가 덮여져야함
- 0이 적힌 칸은 종이 X
- 붙이는 종이가 범위를 벗어나거나 겹치면 X
- 모든칸을 붙이는데 필요한 종이의 최소 개수 구하기
- 못붙이면 -1


> _Key Idea_
> - (0, 0)부터 움직이면서 만약 칸의 숫자가 1이라면,
> - 크기가 5인 색종이부터 1인 색종이를 차례로 검사하며
> - 붙일 수 있다면 종이를 붙이고 칸의 숫자를 0으로 바꿔준다

- size 크기의 색종이를 붙일 수 있는지 확인하는 함수
- 범위를 벗어나거나 0이 있으면 붙일수 없으므로 false

```Java
    private static boolean canAttach(int x, int y, int size){
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++){
                if(i > 9 || j > 9)
                    return false;
                if(board[i][j] != 1)
                    return false;
            }
        return true;
    }
```

- state = 0 이면 색종이를 board 위에 붙이는 것 
- state = 1 이면 색종이를 board 에서 다시 떼어내는 것

```Java
    private static void attach(int x, int y, int size, int state){
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                board[i][j] = state;
    }
```

## :black_circle: Review
1인 칸을 만나면 BFS를 이용해 해당 크기의 색종이들을 줄여가는 방식으로  
구현하려 했으나 코드가 너무 복잡해져서 갈아엎고 다시 처음부터 구현했다  
나중에 다시 풀어봐야겠다..