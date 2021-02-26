# [10026] 적록색약 - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, BFS, DFS

## :round_pushpin: **Logic**

```c++
void normal(int x, int y);
void weak(int x, int y);
```

- 적록색약이 아닌 사람과 적록색약인 사람이 보는 구역을 DFS를 이용해 재귀적으로 구하는 탐색하는 함수

```c++
int** visited;
```

- 방문 여부를 저장하는 배열, -1로 초기화

```c++
if (visited[new_x][new_y] == -1 && picture[new_x][new_y] == color)
    normal(new_x, new_y);
```

- 적록색약이 아닌 사람의 경우 다음 영역이 현재 영역과 같고 방문하지 않은 경우이면 같은 구역이므로 추가 탐색

```c++
if (visited[new_x][new_y] == 1) {
    if (color == picture[new_x][new_y])
        weak(new_x, new_y);
    else if (color == 'R' && picture[new_x][new_y] == 'G')
        weak(new_x, new_y);
    else if (color == 'G' && picture[new_x][new_y] == 'R')
        weak(new_x, new_y);
}
```

- 적록색약인 사람의 경우 다음 영역이 방문하지 않은 영역이면서 현재 영역과 같거나, 적또는 록이면 같은 구역으로 인식하기에 추가 탐색

## :black_nib: **Review**

- 쉬워보인 문제였으나 너무 쉽게 생각해서 오히려 막혔던 문제
- 좀더 깔끔하게 짜는 방법이 없을까를 고민하다가 그냥 답이 나오기만 하는 코드로 작성했음 다른 사람들 코드 중 아예 영역을 저장하는 배열을 색약인 사람이 보는 영역과 정상인 사람이 보는 영역 2가지로 나누어 저장한 코드도 있어서 신기했다
- 색약이면 참 힘들겠다는 생각이 들었음