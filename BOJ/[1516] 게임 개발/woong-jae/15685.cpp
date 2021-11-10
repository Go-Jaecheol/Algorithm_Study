#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
int n, cache[500];
vector<int> building_delay;
vector<vector<int>> building_priority;

int min_construction_time(int cur) {
    if (building_priority[cur].size() == 0) return building_delay[cur];
    int &ret = cache[cur];
    if (ret != -1) return ret;
    ret = min_construction_time(building_priority[cur][0]);

    for (int i = 1; i < building_priority[cur].size(); i++) {
        ret = max(ret, min_construction_time(building_priority[cur][i]));
    }
    ret += building_delay[cur];
    
    return ret;
}

int main() {
    cin >> n;
    building_delay.resize(n);
    building_priority.resize(n);
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> building_delay[i];
        cin >> temp;
        while (temp != -1) {
            building_priority[i].push_back(temp - 1);
            cin >> temp;
        }
    }
    memset(cache, -1, sizeof(cache));
    for (int i = 0; i < n; i++) {
        cout << min_construction_time(i) << '\n';
    }
}
