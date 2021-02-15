#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

typedef struct {
    int r, c;
} position;

int n, m;
char maze[101][101];
int visited[101][101];
int x[4] = {1, 0, -1, 0};
int y[4] = {0, 1, 0, -1};
queue<position> q;


int minPass(int r, int c) {
    position cur, temp;
    cur.r = r; cur.c = c;
    
    q.push(cur);
    visited[r][c] = 1;
    while(1) {
        cur = q.front();
        q.pop();
        for(int i = 0; i < 4; i++) {
                int nc = cur.c + x[i], nr = cur.r + y[i];
                if(0 <= nc && nc < m && 0 <= nr && nr < n && maze[nr][nc] == '1' && !visited[nr][nc]) {
                    temp.r = nr; temp.c = nc;
                    visited[nr][nc] = visited[cur.r][cur.c] + 1;
                    if(nr == n - 1 && nc == m - 1) {
                        return visited[n - 1][m - 1];
                    };
                    q.push(temp);
                }
            }
    }
}

int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> maze[i];
    }
    memset(visited, 0, sizeof(visited));
    cout << minPass(0, 0) << '\n';
}
