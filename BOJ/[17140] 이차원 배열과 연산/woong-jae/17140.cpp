#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;
int R, C, K;
vector<vector<int>> A(101, vector<int> (101));

bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second)
        return a.first < b.first;
    else
        if (a.second == 0 || b.second == 0)
            return a.second > b.second;
        else
            return a.second < b.second;
}

char whichOperation() {
    int r_max = 1, c_max = 1;
    for (int r = 1 ; r <= 100; r++) {
        bool found = false;
        for (int c = 1; c <= 100; c++) {
            if (A[r][c] > 0) {
                r_max = r;
                found = true;
                break;
            }
        }
        if (!found) break;
    }
    for (int c = 1 ; c <= 100; c++) {
        bool found = false;
        for (int r = 1; r <= 100; r++) {
            if (A[r][c] > 0) {
                c_max = c;
                found = true;
                break;
            }
        }
        if (!found) break;
    }
    if (r_max >= c_max) return 'R';
    else return 'C';
}

void arrayOperation() {
    char operation = whichOperation();
    vector<vector<int>> newA(101, vector<int> (101));
    if (operation == 'R') {
        for (int r = 1 ; r <= 100; r++) {
            vector<pair<int, int>> count(101);
            for (int i = 1; i <= 100; i++) {
                count[i].first = i;
            }
            for (int c = 1; c <= 100; c++) {
                if (A[r][c] > 0) {
                    count[A[r][c]].second++;
                }
            }
            sort(count.begin(), count.end(), compare);
            int cur = 0;
            for (int c = 1; c <= 100; c+=2) {
                if (count[cur].second > 0) {
                    newA[r][c] = count[cur].first;
                    newA[r][c + 1] = count[cur++].second;
                }
                else break;
            }
        }
    } else {
        for (int c = 1 ; c <= 100; c++) {
            vector<pair<int, int>> count(101);
            for (int i = 1; i <= 100; i++) {
                count[i].first = i;
            }
            for (int r = 1; r <= 100; r++) {
                if (A[r][c] > 0) {
                    count[A[r][c]].second++;
                }
            }
            sort(count.begin(), count.end(), compare);
            int cur = 0;
            for (int r = 1; r <= 100; r+=2) {
                if (count[cur].second > 0) {
                    newA[r][c] = count[cur].first;
                    newA[r + 1][c] = count[cur++].second;
                }
                else break;
            }
        }
    }
    A = newA;
}

int main() {
    cin >> R >> C >> K;
    for (int r = 1 ; r <= 3; r++) {
        for (int c = 1; c <= 3; c++) {
            cin >> A[r][c];
        }
    }
    int time = 0;
    while (1) {
        if (time > 100) {
            cout << -1 << '\n';
            break;
        }
        if (A[R][C] == K) {
            cout << time << '\n';
            break;
        }
        arrayOperation();
        time++;
    }
}
