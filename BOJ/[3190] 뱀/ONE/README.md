# [3190] 뱀 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
class Snake{
    int row;
    int col;
    Direction direction;

    public Snake(int row, int col, Direction direction){
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}
```

뱀의 몸을 구성하는 Snake 객체 생성

```Java
private static Direction changeDirection(int second, Direction direction){
    if(!changes.isEmpty()){
        Change current = changes.pollFirst();
        if(second == current.X)
            switch (direction)
```

현재 머리의 위치에서 X초가 끝난뒤의 상황에 머리를 돌려야하는지  
확인한 후, 돌려야 한다면 각 방향마다 조건에 맞게 돌려서 리턴한다  
돌리지 않아도 된다면 그냥 현재 방향 그대로 리턴한다.

```Java
private static void dummy(){
    Deque<Snake> deque = new ArrayDeque<>();
    deque.addLast(new Snake(1,1,Direction.EAST));

    while(true){
        Snake head = deque.getFirst(); // 큐의 제일 앞의 머리를 가져옴

        switch (head.direction)
```

Deque를 이용하여 뱀 몸통 구현  
머리는 Snake 객체를 큐의 앞으로 삽입한다.  
조건을 확인한후 사과의 유무를 확인하여 큐의 뒷편의 꼬리를 처리한다.  
머리가 이동한 후에 changeDirection 함수로 방향이동을 검사한다.

## :black_circle: Review
이번 문제에서 처음으로 Deque 라는 자료구조를 써봤다  
큐를 앞 뒤 자유롭게 넣고 빼는게 가능해서 이번문제에서 유용하게 썼다  
근데 실컷 벽에 안닿는건 검사하고 몸통에 닿는 걸 검사 안해서  
시간 낭비를 했다.. 문제를 똑바로 읽자..!