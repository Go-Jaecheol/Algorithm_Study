#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n, m;
vector<int> crain, box;

int minimum_time() {
    int time = 0;
    while(box.size()) {
        int size = (int)box.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < box.size(); j++) {
                if (box[j] <= crain[i]) {
                    box.erase(box.begin() + j);
                    break;
                }
            }
        }
        if (size == box.size()) return -1;
        time++;
    }
    
    return time;
}

int main() {
    cin >> n;
    crain.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> crain[i];
    }
    cin >> m;
    box.resize(m);
    for (int i = 0; i < m; i++) {
        cin >> box[i];
    }
    sort(crain.begin(), crain.end(), greater<int> ());
    sort(box.begin(), box.end(), greater<int> ());
    
    cout << minimum_time() << '\n';
}
