# [19237] 어른 상어 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Shark{
    int x;
    int y;
    int direction;  // 1:up, 2:down, 3:left, 4:right
    boolean isAlive = true;
    int[][] directionPriority = new int[5][4];

    public Shark(int x, int y){
        this.x = x;
        this.y = y;
    }
}
```

상어의 위치 정보와 방향, 생존여부, 방향에 따른 우선순위 정보를 저장한 객체 생성

번호가 낮은 상어가 우선순위가 높기 때문에 번호가 낮은 상어부터 움직임  
반복문의 처음에 전체 냄새의 수를 감소시키고 차례대로 상어들이 움직이는데  
만약 전 반복문의 배열위치에 내번호가 아니면 다른 우선순위가 높은 상어와 마주한 것으로  
죽는처리를 한다

## :black_circle: Review
예시까지 다 통과했지만 제출하면 1퍼센트에서 안되고  
질문들에 있던 반례들도 테스트 했는데 안되가지고  
코드를 싹다 갈아 엎었다...