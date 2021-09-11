# [14499] 주사위 굴리기 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Dice{
    int x;
    int y;
    int top;    // 1
    int back;   // 2
    int right;  // 3
    int left;   // 4
    int front;  // 5
    int bottom; // 6

    public Dice(int x, int y, int top, int back, int right, int left, int front, int bottom){
        // 주사위의 위치
        this.x = x;
        this.y = y;
        // 주사위의 각면에 적힌 수
        this.top = top;
        this.back = back;
        this.right = right;
        this.left = left;
        this.front = front;
        this.bottom = bottom;
    }

    public void moveEast() {
        int temp = top;
        top = left;
        left = bottom;
        bottom = right;
        right = temp;
    }
}
```

주사위의 위치와 각 면의 숫자를 저장하는 변수를 가지고,  
각 방향으로 이동시킬때의 면을 움직이는 함수를 가진 Dice 객체 생성


좌표를 검사하여 지도 안이라면 방향에 따라 면을 바꾸고 윗면 출력

## :black_circle: Review
주사위를 굴린다는 생각이 아닌, 면을 바꾼다고 생각하면 쉬운 문제  
시키는 조건에 맞춰 구현만 하면 되는 문제