#include <iostream>
#include <cstring>
using namespace std;

void quadtree(int x_idx, int y_idx, int size);

int N;
char** arr;
char one = '1';

int main() {
    cin >> N;

    arr = new char* [N];
    for (int i = 0; i < N; i++) {
        arr[i] = new char[N];
        for (int j = 0; j < N; j++)
            cin >> arr[i][j];
    }

    quadtree(0, 0, N);

    for (int i = 0; i < N; i++)
        delete[] arr[i];
    delete[] arr;

    return 0;
}

void quadtree(int x, int y, int size) {
    int cnt0 = 0, cnt1 = 0;
    if (size > 1) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] == one)
                    cnt1++;
                else
                    cnt0++;
            }
        }
        if (cnt1 == size * size) cout << "1";
        else if (cnt0 == size * size) cout << "0";
        else {
            cout << "(";
            for (int i = x; i < x + size; i += size / 2) {
                for (int j = y; j < y + size; j += size / 2) {
                    quadtree(i, j, size / 2);
                }
            }
            cout << ")";
        }
    }
    else if (size == 1) {
        cout << arr[x][y];
    }
}