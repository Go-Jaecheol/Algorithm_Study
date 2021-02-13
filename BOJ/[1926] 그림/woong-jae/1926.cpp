#include <iostream>
#include <cstring>

using namespace std;
int n, m;
int paper[500][500], visited[500][500];
int x[4] = {1, 0, -1, 0};
int y[4] = {0, 1, 0, -1};

int getDimension(int r, int c) {
    int d = 1;
    visited[r][c] = 1;
    for(int i = 0; i < 4; i++) {
        int nc = c + x[i], nr = r + y[i];
        if(0 <= nc && nc < m && 0 <= nr && nr < n && paper[nr][nc] && !visited[nr][nc]) {
            d = d + getDimension(nr, nc);
        }
    }
    
    return d;
}

void count_picture() {
    int maxD = 0, count = 0;
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(paper[i][j] && !visited[i][j]) {
                maxD = max(maxD, getDimension(i, j));
                count++;
            }
        }
    }
    
    cout << count << '\n' << maxD << '\n';
}

int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> paper[i][j];
        }
    }
    memset(visited, 0, sizeof(visited));
    count_picture();
}
