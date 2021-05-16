#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
int N;
vector<int> parents;
vector<pair<int, int>> x, y, z;
vector<pair<long long, pair<int, int>>> dist;

int findParent(int a) {
    if (a == parents[a]) 
        return a;
    return parents[a] = findParent(parents[a]);
}

bool unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (a == b) 
        return false;
    if (a > b) 
        parents[a] = b;
    else 
        parents[b] = a;
    return true;
}


int main() {
    int a, b, c;
    cin >> N;

    parents.resize(N);
    for (int i = 0; i < N; i++)
        parents[i] = i;

    for (int i = 0; i < N; i++) {
        cin >> a >> b >> c;
        x.push_back({ a, i });
        y.push_back({ b, i });
        z.push_back({ c, i });
    }

    sort(x.begin(), x.end());
    sort(y.begin(), y.end());
    sort(z.begin(), z.end());

    for (int i = 0; i < N - 1; i++) {
        dist.push_back({ abs(x[i].first - x[i + 1].first), {x[i].second, x[i + 1].second} });
        dist.push_back({ abs(y[i].first - y[i + 1].first), {y[i].second, y[i + 1].second} });
        dist.push_back({ abs(z[i].first - z[i + 1].first), {z[i].second, z[i + 1].second} });
    }

    sort(dist.begin(), dist.end());

    int cnt = 0;
    long long cost = 0;

    for (int i = 0; i < dist.size(); i++) {
        if (cnt == N - 1)
            break;
        if (unionParent(dist[i].second.first, dist[i].second.second)) {
            cnt++;
            cost += dist[i].first;
        }
    }

    cout << cost;


    return 0;
}