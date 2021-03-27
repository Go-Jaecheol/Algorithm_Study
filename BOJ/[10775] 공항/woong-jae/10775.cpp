#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
int g, p;
vector<int> parent;

int find(int x) {
    if (x == parent[x]) return x;
    else return parent[x] = find(parent[x]);
}

void unite(int x, int y) {
    x = find(x);
    y = find(y);
    parent[x] = y;
}

int main() {
    int cnt = 0;
    cin >> g >> p;
    parent.resize(g + 1);
    for (int i = 1; i <= g; i++) {
        parent[i] = i;
    }
    for (int i = 0; i < p; i++) {
        int gi, gate;
        cin >> gi;
        gate = find(gi);
        if (gate == 0) break;
        unite(gate, gate - 1);
        cnt++;
    }
    cout << cnt << '\n';
}

