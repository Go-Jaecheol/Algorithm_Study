#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n;

bool compare(pair<int, int>a, pair<int, int> b) {
    if (a.first == b.first) return a.second > b.second;
    return a.first < b.first;
}

struct cmp{
    bool operator()(pair<int, int> a, pair<int, int> b){
        if (a.second == b.second) return a.first < b.first;
        return a.second > b.second;
    }
};

int main() {
    int res = 0;
    cin >> n;
    priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> picked;
    vector<pair<int, int>> input;
    
    for (int i = 0; i < n; i++) {
        int deadline, cup_noodle;
        cin >> deadline >> cup_noodle;
        input.push_back(make_pair(deadline, cup_noodle));
    }
    sort(input.begin(), input.end(), compare);
    
    for (int i = 0; i < n; i++) {
        if (input[i].first > picked.size()) {
            picked.push(input[i]);
        } else if (picked.top().second < input[i].second) {
            picked.pop();
            picked.push(input[i]);
        }
    }
    
    
    while (picked.size()) {
        res += picked.top().second;
        picked.pop();
    }
    
    cout << res << '\n';
}


