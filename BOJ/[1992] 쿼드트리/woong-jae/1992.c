#include <iostream>
#include <vector>
#include <cstdlib>

#define MAX 64

using namespace std;
char matrix[MAX][MAX];
vector<char> result;

int check(int x, int y, int size) {
    int basis = matrix[y][x];
    for(int i = x; i < x + size; i++) {
        for(int j = y; j < y + size; j++) {
            if(matrix[j][i] != basis) return -1;
        }
    }
    return 0;
}

void quadtree(int x, int y, int size) {
    if(check(x, y, size) == 0) { //기저사례
        result.push_back(matrix[y][x]);
    } else {
        result.push_back('(');
        int half = size / 2;
        quadtree(x, y, half);
        quadtree(x + half, y, half);
        quadtree(x, y + half, half);
        quadtree(x + half, y + half, half);
        result.push_back(')');
    }
}

int main() {
    int n;
    
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }
    quadtree(0, 0, n);
    for(int i = 0; i < result.size(); i++) {
        cout << result[i];
    }
    cout << '\n';
}

