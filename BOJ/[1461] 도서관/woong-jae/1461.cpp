#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n, m;

int get_step(vector<int> input, int w) {
    int res = 0, count = 0;
    res += (abs(input[0]) * w);
    for (int i = 0; i < input.size(); i++) {
        if (count == m) {
            count = 0;
            res = res + (abs(input[i]) * 2);
        }
        count++;
    }
    return res;
}

int main() {
    int res = 0;
    vector<int> neg, pos;
    
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int in;
        cin >> in;
        if (in > 0) pos.push_back(in);
        else neg.push_back(in);
    }
    sort(neg.begin(), neg.end());
    sort(pos.begin(), pos.end(), greater<int>());
    
    if (pos.size() == 0) res = get_step(neg, 1);
    else if (neg.size() == 0) res = get_step(pos, 1);
    else if (pos.size() && neg.size() && abs(neg[0]) > pos[0]) res = get_step(neg, 1) + get_step(pos, 2);
    else res = get_step(neg, 2) + get_step(pos, 1);
    cout << res << '\n';
}

