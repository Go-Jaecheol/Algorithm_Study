#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    int n, res = 0;
    priority_queue<int, vector<int>, greater<int>> card;
    
    cin >> n;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        card.push(temp);
    }
    
    while (card.size() > 1) {
        int c1, c2;
        c1 = card.top();
        card.pop();
        c2 = card.top();
        card.pop();
        res += c1 + c2;
        card.push(c1 + c2);
    }
    cout << res << '\n';
}

