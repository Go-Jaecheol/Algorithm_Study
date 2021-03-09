#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <queue>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.first == b.first) return a.second < b.second;
    else return a.first < b.first;
}

struct cmp {
    bool operator()(pair<int, int> a, pair<int, int> b) {
        if (a.second == b.second) return a.first > b.first;
        else return a.second > b.second;
    }
};

int main() {
    int n;
    int res = 1;
    vector<pair<int, int>> time;
    priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> q;
    
    cin >> n;
    for (int i = 0; i < n; i++) {
        int t, s;
        cin >> s >> t;
        time.push_back(make_pair(s, t));
    }
    sort(time.begin(), time.end(), compare);
    
    q.push(time[0]);
    for (int i = 1; i < n; i++) {
        if (q.top().second > time[i].first) q.push(time[i]);
        else {
            res = max(res, (int)q.size());
            while (q.size() && q.top().second <= time[i].first) {
                q.pop();
            }
            q.push(time[i]);
        }
    }
    cout << res << '\n';
}

