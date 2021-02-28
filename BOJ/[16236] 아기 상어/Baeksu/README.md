# [16236] 아기 상어 - C++

## :pushpin: **Algorithm**

구현, 그래프 이론, 그래프 탐색, BFS, 시뮬레이션

## :round_pushpin: **Logic**

```c++
int** visited;
```

- 방문 여부를 저장하는 배열, `-1`로 초기화

```c++
void get_fish(int x, int y);
```

- 방문 여부를 저장하는 `visited`와 공간 정보를 저장하는 `space` 를 이용해 먹을 수 있는 물고기까지 이동하는 최단 경로를 BFS로 계산하는 함수

  ```c++
  if (new_x < 0 || new_x > N - 1 || new_y < 0 || new_y > N - 1) continue;
  if (visited[new_x][new_y] != -1 || space[new_x][new_y] > shark_size) continue;
  
  visited[new_x][new_y] = visited[cur_x][cur_y] + 1;
  ```

  - 탐색하는 `space` 범위 안에 있지 않고, 방문한 공간이거나 물고기가 아기 상어보다 큰 경우는 pass
  - 그렇지 않은 모든 경우는 이동할 수 있는 경우이므로 전의 경로 + 1

  ```c++
  if (space[new_x][new_y] != 0 && space[new_x][new_y] < shark_size) {
      if (min_dist > visited[new_x][new_y]) {
          min_x = new_x, min_y = new_y;
          min_dist = visited[new_x][new_y];
      }
      else if (min_dist == visited[new_x][new_y]) {
          if (min_x == new_x) {
              if (min_y > new_y)
                  min_y = new_y;
          }
          else if (min_x > new_x)
              min_x = new_x, min_y = new_y;
      }
  }
  ```

  - 이후 먹을 수 있는 물고기가 있는 경우 최단 경로를 저장하는 `min_dist`를 최신화, 이 때의 좌표를 저장
  - 그리고 먹을 수 있는 물고기가 많은 경우, 우선순위를 지키기 위해 가장 왼쪽, 위쪽의 경우 계산

```c++
int eat = 0;
while (1) {
    min_x = -1, min_y = -1, min_dist = 987654321;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            visited[i][j] = -1;

    get_fish(shark_x, shark_y);
    if (min_x != -1 && min_y != -1) {
        time += visited[min_x][min_y];
        eat++;
        if (eat == shark_size)
            eat = 0, shark_size++;

        space[min_x][min_y] = 0;
        shark_x = min_x, shark_y = min_y;
    }
    else
        break;
```

- `get_fish` 함수 호출 이후 값이 변경됨을 확인하기 위해서 함수 사용하기 전 `min_x`, `min_y`, `min_dist` 와 `visited`를 항상 초기화
- `min_x` 와 `min_y`가 변경되었다면 물고기를 먹은 경우이므로 걸린 시간을 더하고, 물고기 먹은 횟수를 저장하는 `eat` + 1
  - 이때 `eat`가  아기 상어의 크기와 같다면 아기 상어의 크기가 `1` 증가
  - 물고기를 먹었으므로 공간에서 좌표 정보를 `0`으로 수정하고 상어의 위치도 옮겨줌
- `min_x`와 `min_y`가 변경되지 않았다면 먹을 수 있는 물고기가 없다는 의미이므로 반복문 탈출

## :black_nib: **Review**

- 일단 문제 길이보고 쫄아버렸음
- 해결 방법이 생각나지 않아 구글링
- 참고자료: https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4
- 이런 문제일수록 천천히 문제를 읽으면서 정리하는 방법을 추천해줬고 앞으로도 문제가 긴 유형을 만난다면 쫄지말고 천천히 적어보면서 정리해야겠음
- 그리고 흔히 `int A, B;`와 같이 선언을 많이 하는데 이와 비슷하게 동적 할당 배열 해제 시 `delete[] space, visited`로 사용했더니 백준에서는 정답처리는 되었는데 `warning: right operand of comma operator has no effect`라고 떴음
- 그래서 동적 할당 배열 선언과 해제 시 `space = new int* [N], visited = new int* [N];`, `delete[] space, delete[] visited;`와 같은 방법을 사용하니 역시 정답처리는 되었는데 이번엔 `0ms`에서 `4ms` 로 시간이 좀 더 소모되었음
  - 아마 위에서 말한 바대로 오른쪽 연산자인 `visited`에 대한 할당 해제가 이루어지지 않은 것과 이루어진 것의 차이인 것 같음
- 그리고 `delete`가 일종의 **연산자**이므로 위에서 사용했던 것처럼 `delete[] space, visited` 가 되지 않은 것 같음
