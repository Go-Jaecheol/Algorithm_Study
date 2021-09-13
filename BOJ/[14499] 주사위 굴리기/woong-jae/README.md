# [14499] 주사위 굴리기
## Algorithm
- Simulation
## Logic
주사위의 상태를 관리하는게 핵심이다.

문제에 나와있는 전개도를 그대로 사용하면 주사위의 상태 변화를 쉽게 구현할 수 있다.

위나 아래로 움직일 때는 겹치는 부분의 좌표만 변경해주면 된다.

오른쪽으로 움직일 때는 '좌 - 겹치는 면 - 우 - 아래 면'을 시계 방향으로 한 칸씩 움직여주면 된다.
왼쪽은 반대로 반시계 방향으로 움직이면 된다.
```cpp
void move() {
    int nr = x + dr[instruction.front()], nc = y + dc[instruction.front()];
    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
        x = nr; y = nc;
        int temp;
        switch (instruction.front()) {
            case 0: // 오른쪽
                temp = dice_c[1];
                dice_c[1] = dice_r[cur];
                dice_r[cur] = dice_c[0];
                dice_c[0] = dice_r[(cur + 2) % 4];
                dice_r[(cur + 2) % 4] = temp;
                break;
            case 1: // 왼쪽
                temp = dice_c[0];
                dice_c[0] = dice_r[cur];
                dice_r[cur] = dice_c[1];
                dice_c[1] = dice_r[(cur + 2) % 4];
                dice_r[(cur + 2) % 4] = temp;
                break;
            case 2: // 위
                cur = (cur + 3) % 4;
                break;
            case 3: // 아래
                cur = (cur + 1) % 4;
                break;
        }
        if (map[x][y] == 0) map[x][y] = dice_r[(cur + 2) % 4];
        else {
            dice_r[(cur + 2) % 4] = map[x][y];
            map[x][y] = 0;
        }
        cout << dice_r[cur] << '\n';
    }
}
```
## Review
주사위 상태 관리를 어떻게 구현하느냐에 따라서 쉬워질 수도 있고 어려워 질 수도 있는 문제인 것 같다. 시뮬레이션 뭔가 재밌다.
