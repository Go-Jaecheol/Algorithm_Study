# [14891] 톱니바퀴 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Gear{
    int number;
    int[] cog;
    boolean check;

    public Gear(int number, int[] cog, boolean check){
        this.number = number;
        this.cog = cog;
        this.check = check;
    }
}
```

톱니바퀴의 번호 number, 각 톱니의 N 또는 S인지 저장하는 배열 cog,  
방문한 톱니바퀴인지 확인하기 위한 check 를 가진 Gear 객체 선언

```Java
        switch (gearNum){
            case 1:
                if(gears[0].cog[2] != gears[1].cog[6] && !gears[1].check)
                    rotatingGear(gears[1].number, -direction);
                break;
            case 2:
                if(gears[1].cog[6] != gears[0].cog[2] && !gears[0].check)
                    rotatingGear(gears[0].number, -direction);

                if(gears[1].cog[2] != gears[2].cog[6] && !gears[2].check)
                    rotatingGear(gears[2].number, -direction);
                break;
            case 3:
                if(gears[2].cog[6] != gears[1].cog[2] && !gears[1].check)
                    rotatingGear(gears[1].number, -direction);

                if(gears[2].cog[2] != gears[3].cog[6] && !gears[3].check)
                    rotatingGear(gears[3].number, -direction);
                break;
            case 4:
                if(gears[3].cog[6] != gears[2].cog[2] && !gears[2].check)
                    rotatingGear(gears[2].number, -direction);
                break;
        }
```

각 톱니바퀴의 번호마다 경우를 나누어서  
1번은 2번만을,   
2번은 1번, 3번을,  
3번은 2번, 4번을,  
4번은 3번만을 돌릴 수 있다.  
  
톱니바퀴의 각 맞닿는 부분을 비교하여  
다르고 만약에 아직 방문하지 않은 톱니바퀴라면 재귀함수 호출  
맞물리는 톱니바퀴는 반대 방향으로 돌기에 -direction 을 파라미터로 전달

## :black_circle: Review
원리는 크게 어렵지 않았는데 시계 반대 방향으로 돌리는 부분에서  
i = 0을 해줘야하는데 i = 1을 해줘서 자꾸 틀려서 찾는데 좀 걸렸다...
시뮬레이션 문제는 처음에 어려워 보였는데 나름 재밌는것 같다