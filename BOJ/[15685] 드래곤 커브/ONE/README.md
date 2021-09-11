# [15685] 드래곤 커브 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션**

## :black_circle: Logic

```Java
private static void drangonCurve(int x, int y, int d, int g){
        ArrayList<Integer> list = new ArrayList<>(); // 각 이동방향을 담을 리스트

        //0: x 좌표가 증가하는 방향 (→)
        //1: y 좌표가 감소하는 방향 (↑)
        //2: x 좌표가 감소하는 방향 (←)
        //3: y 좌표가 증가하는 방향 (↓)

        int direction = d;
        list.add(direction); // 처음 방향 담기

        for(int i = 0; i < g; i++)
            for(int j = list.size() - 1; j >= 0; j--){  // 리스트의 뒤에서 부터 검사
                direction = (list.get(j) + 1) % 4;  // 0 1 2 1 -> 2 3 2 1 이 되도록, 4가 되면 -> 0
                list.add(direction);
            }

        map[x][y] = true;
        for(int dir : list){  // 리스트를 반복문 돌면서 방향을 토대로 점찍기
            switch (dir){
                case 0: // Right
                    map[x][++y] = true;
                    break;
                case 1: // Up
                    map[--x][y] = true;
                    break;
                case 2: // Left
                    map[x][--y] = true;
                    break;
                case 3: // Down
                    map[++x][y] = true;
                    break;
            }
        }
```

방향을 리스트에 삽입하여 푸는 문제

0 -> 0 / 1 -> 0 1 / 2 1 -> 0 1 2 1 / 2 3 2 1  

리스트를 뒤에서 부터 검사하여 1씩 더한것을 리스트에 다시 추가해주는 규칙이다  
그리고 리스트에서 방향을 하나씩 검사하여 좌표를 이동하며 map 배열에 점찍기


```Java
    private static void countSquare(){
        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) // 꼭짓점 4개가 ture 일 때
                    result++;
    }
```

완전 탐색으로 현재 좌표를 기준으로 오른쪽, 아래쪽, 대각선 아래쪽을 검사하여  
모두 true 라면 사각형이 되기 때문에 result++

## :black_circle: Review
이번 문제는 문제 자체를 이해하는 데 되게 오래걸렸다  
직접 그림을 따라 그려가보면서 규칙을 깨달았고 구현을 하는건 얼마 걸리지 않았는데,  
입력 받는 x, y 좌표가 내가 구현하면서 사용한 것과 반대인 것을 확인 안해서 찾느라 오래걸렸다..