#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int N, M, x, y, K;
int map[20][20];
queue<int> instruction;

// 주사위
int cur = 1;
vector<int> dice_r(4);
vector<int> dice_c(2);

int dr[4] = {0, 0, -1, 1};
int dc[4] = {1, -1, 0, 0};

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

int main() {
    cin >> N >> M >> x >> y >> K;
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
            cin >> map[r][c];
        }
    }
    for (int i = 0; i < K; i++) {
        int inst;
        cin >> inst;
        instruction.push(inst - 1);
    }
    
    while (instruction.size()) {
        move();
        instruction.pop();
    }
}
