#include <iostream>
#include <cstring>

using namespace std;
int n, game[100000][3];
int cache[3];

int main() {
    int minval, maxval;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> game[i][0] >> game[i][1] >> game[i][2];
    }
    
    for (int i = 0; i < 3; i++) {
        cache[i] = game[0][i];
    }
    for (int i = 1; i < n; i++) {
        int temp[3];
        for (int j = 0; j < 3; j++) {
            int res = game[i][j] + cache[j];
            if (j <= 1) res = min(res, game[i][j] + cache[j + 1]);
            if (j >= 1) res = min(res, game[i][j] + cache[j - 1]);
            temp[j] = res;
        }
        for (int i = 0; i < 3; i++) {
            cache[i] = temp[i];
        }
    }
    minval = min(cache[0], min(cache[1], cache[2]));
    
    for (int i = 0; i < 3; i++) {
        cache[i] = game[0][i];
    }
    for (int i = 1; i < n; i++) {
        int temp[3];
        for (int j = 0; j < 3; j++) {
            int res = game[i][j] + cache[j];
            if (j <= 1) res = max(res, game[i][j] + cache[j + 1]);
            if (j >= 1) res = max(res, game[i][j] + cache[j - 1]);
            temp[j] = res;
        }
        for (int i = 0; i < 3; i++) {
            cache[i] = temp[i];
        }
    }
    maxval = max(cache[0], max(cache[1], cache[2]));
    cout << maxval << ' ' << minval << '\n';
}


