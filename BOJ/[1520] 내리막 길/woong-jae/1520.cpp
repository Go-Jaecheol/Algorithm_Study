#include <iostream>
#include <cstring>

using namespace std;

int m, n;
int map[500][500];
int cache[500][500];

int move(int row, int col) {
    if(row == m - 1 && col == n - 1) return 1;
    int& ret = cache[row][col];
    if(ret != -1) return ret;
    
    int res = 0, cur = map[row][col];
    if(col < n - 1 && cur > map[row][col + 1]) res += move(row, col + 1);//오른쪽
    if(row < m - 1 && cur > map[row + 1][col]) res += move(row + 1, col);//밑
    if(col > 0 && cur > map[row][col - 1]) res += move(row, col - 1);//왼쪽
    if(row > 0 && cur > map[row - 1][col]) res += move(row - 1, col);//위
    ret = res;
    
    return ret;
}

int main() {
    cin >> m >> n;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }
    memset(cache, -1, sizeof(cache));
    cout << move(0, 0) << '\n';
}
