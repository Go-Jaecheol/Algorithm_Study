#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, sum = 1;
    vector<int> w;
    cin >> n;
    w.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> w[i];
    }
    sort(w.begin(), w.end(), less<int>());
    for (int i = 0; i < n; i++) {
            if (w[i] > sum) break;
            sum += w[i];
    }
    cout << sum << '\n';
}
