#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
vector<int> kids;
int n, cache[200];

int move_kid(int start) {
    int& ret = cache[start];
    if(ret != -1) return ret;
    
    ret = 1;
    for(int i = start + 1; i < n; i++) {
        if(kids[start] < kids[i])
            ret = max(ret, move_kid(i) + 1);
    }
    
    return ret;
}

int main() {
    int temp, max_len = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        kids.push_back(temp);
    }
    memset(cache, -1, sizeof(cache));
    for(int i = 0; i < n; i++) {
        max_len = max(max_len, move_kid(i));
    }
    cout << n - max_len << '\n';
}
