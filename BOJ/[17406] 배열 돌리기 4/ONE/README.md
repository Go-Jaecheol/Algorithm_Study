# [17406] 배열 돌리기 4 - JAVA

## :black_circle: Algorithm
**브루트 포스**, **DFS**

## :black_circle: Logic
- 회전 연산이 두 개 이상이면, 연산을 수행한 순서에 따라 최종 배열이 다름
- 회전연산(r,c,s)들의 순서에 따른 최솟값을 찾기
- 회전연산의 순열을 **DFS** 로 구현  

> int[][] A : 배열의 정보를 저장   
> int[] order : 순열에 따른 순서를 저장할 배열  
> boolean[] visited : 순열의 방문 여부를 저장할 배열  
> Node[] spins : 입력된 회전연산들을 저장할 객체 배열    
> 
> int[][] copyArray() : A 배열을 복사하는 함수  
> int minArray(int [][] ary) : 배열의 행들의 합들을 비교하여 최솟값을 구하는 함수  
> void spinArray(int[][] ary, Node node) : 회전 연산 객체의 정보를 이용하여 배열을 돌리는 함수  
> void DFS(int depth) : 순열을 DFS 로 구현한 함수

- 회전 연산의 (r,c,s) 정보를 담는 객체
```Java
class Node{
    int r;
    int c;
    int s;
    public Node(int r, int c, int s){
        this.r = r;
        this.c = c;
        this.s = s;
    }
}
```

- s 크기 만큼 반복문을 돌며 정사각형의 2차원 배열을 시계 방향으로 돌린다
- 왼쪽 제일 위의 값을 temp 에 저장한 후, 
- 반시계 방향으로 값을 넣어간다

```Java
    private static void spinArray(int[][] ary, Node node){
        for(int i = 1; i <= node.s; i++){
            int temp = ary[node.r - i][node.c - i];

            for(int j = node.r - i; j < node.r + i; j++)
                ary[j][node.c - i] = ary[j + 1][node.c - i];

            for(int j = node.c - i; j < node.c + i; j++)
                ary[node.r + i][j] = ary[node.r + i][j + 1];

            for(int j = node.r + i; j > node.r - i; j--)
                ary[j][node.c + i] = ary[j - 1][node.c + i];

            for(int j = node.c + i; j > node.c - i + 1; j--)
                ary[node.r - i][j] = ary[node.r - i][j - 1];

            ary[node.r - i][node.c - i + 1] = temp;
        }
    }
```

- DFS를 수행하다 depth = K 가 되면, 해당하는 순서로 배열을 돌리고  
- 전역변수로 선언되어 있는 min 과 tmpArray의 최솟값을 비교하여 최솟값을 구한다

```Java
    private static void DFS(int depth){
        if(depth == K){
            int[][] tmpArray = copyArray();
            for(int i = 0; i < K; i++)
                spinArray(tmpArray, spins[order[i]]);
            min = Math.min(min, minArray(tmpArray));
            return;
        }
        for(int i = 0; i < K; i++){
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
```

## :black_circle: Review
순열을 이용해 구현하는 어렵지 않았던 문제