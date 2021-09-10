#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, city[21][21];

int calcDiff(int x, int y, int d1, int d2) {
    vector<int> population(5);
    vector<vector<bool>> sector5(21, vector<bool> (21));
    
    for (int r = x, c = y; r <= r + d1 && c >= y - d1; r++, c--) sector5[r][c] = true;
    for (int r = x, c = y; r <= r + d2 && c <= y + d2; r++, c++) sector5[r][c] = true;
    for (int r = x + d1, c = y - d1; r <= x + d1 + d2 && c <= y - d1 + d2; r++, c++) sector5[r][c] = true;
    for (int r = x + d2, c = y + d2; r <= x + d1 + d2 && c >= y - d1 + d2; r++, c--) sector5[r][c] = true;
    
    for (int r = x + 1; r < x + d2 + d1; r++) {
        int c = 1;
        while(!sector5[r][c++]);
        do {
            sector5[r][c++] = true;
        } while(!sector5[r][c]);
    }
    
    for (int r = 1; r <= N; r++) {
        for (int c = 1; c <= N; c++) {
            if (sector5[r][c]) population[4] += city[r][c];
            else if (r < x + d1 && c <= y) population[0] += city[r][c];
            else if (r <= x + d2 && y < c) population[1] += city[r][c];
            else if (x + d1 <= r && c < y - d1 + d2) population[2] += city[r][c];
            else if (x + d2 < r && y - d1 + d2 <= c) population[3] += city[r][c];
        }
    }
    sort(population.begin(), population.end());
    
    return population[4] - population[0];
}

int getMin() {
    int ret = -1;
    
    // 1번 조건
    for (int d1 = 1; d1 <= N ; d1++) {
        for (int d2 = 1; d2 <= N; d2++) {
            for (int x = 1; x + d1 + d2 <= N; x++) {
                for (int y = 1 + d1; y + d2 <= N ; y++) {
                    if (ret == -1) ret = calcDiff(x, y, d1, d2);
                    else ret = min(ret, calcDiff(x, y, d1, d2));
                }
            }
        }
    }
    
    return ret;
}

int main() {
    cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> city[i][j];
        }
    }
    cout << getMin() << '\n';
}
