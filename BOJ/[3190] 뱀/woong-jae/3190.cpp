#include <iostream>
#include <queue>
#include <utility>

using namespace std;
int N, K, L;
queue<pair<int, char>> spin_info;
int board[101][101] = {0, };

int dr[4] = {-1, 0, 1, 0}; // 북 동 남 서
int dc[4] = {0, 1, 0, -1};

typedef struct snake {
    pair<int, int> head;
    int dir;
    queue<pair<int, int>> body;
} snake;

int startGame() {
    int time = 0;
    snake s;
    s.head = make_pair(1, 1);
    s.dir = 1;
    s.body.push(s.head);
    
    board[1][1] = 2;
    while (1) {
        pair<int, int> next = make_pair(s.head.first + dr[s.dir], s.head.second + dc[s.dir]);
        
        if (0 < next.first && next.first <= N && 0 < next.second && next.second <= N) {
            if (board[next.first][next.second] == 0) { // 그냥 이동
                board[s.body.front().first][s.body.front().second] = 0;
                s.body.pop();
            } else if (board[next.first][next.second] == 2) { // 사과 발견
                break;
            }
            s.body.push(next);
            s.head = next;
            board[next.first][next.second] = 2;
            time++;
            if (spin_info.size() && spin_info.front().first == time) {
                if (spin_info.front().second == 'D') s.dir = (s.dir + 1) % 4;
                else s.dir = (s.dir + 3) % 4;
                spin_info.pop();
            }
        }
        else {
            break;
        }
    }
    
    return time + 1;
}

int main() {
    cin >> N >> K;
    for (int i = 0; i < K; i++) {
        int r, c;
        cin >> r >> c;
        board[r][c] = 1;
    }
    cin >> L;
    for (int i = 0; i < L; i++) {
        int x; char c;
        cin >> x >> c;
        spin_info.push(make_pair(x, c));
    }
    cout << startGame() << '\n';
}
