#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
int n;
int cache[1001], input[1001], choices[1001];

int lis(int start) {
    int& ret = cache[start];
    if(ret != -1) return ret;
    
    ret = 1;
    int bestNext = -1;
    for(int i = start + 1; i < n; i++) {
        if(start == -1 || input[start] < input[i]) {
            int candidate = lis(i) + 1;
            if(candidate > ret) {
                ret = candidate;
                bestNext = i;
            }
        }
    }
    choices[start + 1] = bestNext;
    return ret;
}

void reconstruct(int start, vector<int>& seq) {
    if(start != -1) seq.push_back(input[start]);
    int next = choices[start + 1];
    if(next != -1) reconstruct(next, seq);
}

int main() {
    int maxlen = 0, startpoint = 0;
    vector<int> res;
    cin >> n;
    memset(cache, -1, sizeof(cache));
    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }
    
    for(int i = 0; i < n; i++) {
        int temp = lis(i);
        if(maxlen < temp) {
            maxlen = temp;
            startpoint = i;
        }
    }
    reconstruct(startpoint, res);
    
    cout << maxlen << '\n';
    for(int i = 0; i < res.size(); i++) {
        cout << res[i] << ' ';
    }
    cout << '\n';
    return 0;
}

