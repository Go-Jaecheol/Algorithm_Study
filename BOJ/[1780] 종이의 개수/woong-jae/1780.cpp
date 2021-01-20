#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;
int matrix[2187][2187];
int counter[3] = {0, };

int check(int x, int y, int size) { //행렬안의 숫자가 모두 같은지 확인하는 함수
    if(size == 1) return 0;
    int basis = matrix[y][x];
    for(int i = y; i < y + size; i++) {
        for(int j = x; j < x + size; j++) {
            if(matrix[i][j] != basis) return -1;
        }
    }
    return 0;
}

void divide_recursive(int x, int y, int size) {
    if (check(x, y, size) == 0) { //행렬안의 숫자가 모두 같을 때
        counter[matrix[y][x] + 1]++;
    }
    else {//다를 때 -> 분할
        int divide = size / 3;
        divide_recursive(x, y, divide);
        divide_recursive(x + divide, y, divide);
        divide_recursive(x + divide * 2, y, divide);
        divide_recursive(x, y + divide, divide);
        divide_recursive(x, y + divide * 2, divide);
        divide_recursive(x + divide, y + divide, divide);
        divide_recursive(x + divide * 2, y + divide, divide);
        divide_recursive(x + divide, y + divide * 2, divide);
        divide_recursive(x + divide * 2, y + divide * 2, divide);
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
    divide_recursive(0, 0, n);
    for(int i = 0; i < 3; i++) {
        cout << counter[i] << '\n';
    }
    return 0;
}

