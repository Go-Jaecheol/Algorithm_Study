# [1926] 그림 - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS, DFS

## :round_pushpin: **Logic**

```c++
int picture(int x, int y, int area);
```

- 해당 좌표의 상하좌우의 방문 여부와 0 또는 1인지에 따라 재귀적으로 그림을 탐색하는 함수

```c++
int** visited;
```

- 방문 여부를 저장하는 배열, -1로 초기화

```c++
area = 0;
if (map[i][j] == 1 && visited[i][j] == -1) {
    area = picture(i, j, area);
    cnt++;
}
if (max_area < area)
	max_area = area;
```

- 이차원 배열을 이용하여 그림을 탐색하는데 해당 좌표가 1이면서 방문하지 않은 경우에만 picture함수 호출
- 하나의 좌표를 이용하여 picture함수를 호출한 경우 계속 1인 좌표를 찾아다니며 재귀호출하기에 위의 함수가 한번 호출되고 끝나면 하나의 그림을 다 찾은 경우이므로 그림의 개수 + 1
- 그리고 해당 그림의 넓이를 저장하는 area값을 리턴 받아 max_area값 변경

```c++
int picture(int x, int y, int area) {
    if (visited[x][y] == -1) {
        area++;
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int new_x = x + x_ar[i];
            int new_y = y + y_ar[i];

            if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col)
                if (map[new_x][new_y] == 1) {
                    area = picture(new_x, new_y, area);
                }
        }
    }
    return area;
}
```

- 해당 좌표를 방문하지 않은 경우 방문 시 area가 증가, visited 값 변경 후 상하좌우에 대하여 다음의 좌표가 그림 안에 있으며 1인 경우에 대해 재귀 호출
  - area값을 계속 리턴 받으며 최신화

## :black_nib: **Review**

- 문제 읽어보자마자 저번주차 **내리막 길** 풀때 그래프 탐색했던 거 생각나서 그 코드 이용

- 처음에는 void picture함수로 리턴값 없이 작성했는데

  ```
  4 5
  1 1 1 0 1
  1 0 1 0 1
  1 0 1 0 1
  1 0 1 1 1
  ```

  과 같이 시작지점 (0,0) 에서 출발한 후 다시 시작지점으로 돌아와서 아래 있는 3개의 1을 탐색할 때 처음 시작지점을 가지고 호출된 picture(0, 0, 0) 값에 area가 더해지는 문제가 발생하여 리턴값을 받는 int형 함수로 작성
