#include <iostream>
#include <string>
#include <cstring>

using namespace std;
string str1, str2;
int cache[1001][1001];

int lcs(int index1, int index2) {
    if(index1 == str1.size() || index2 == str2.size()) return 0;
    int&ret = cache[index1][index2];
    if(ret != -1) return ret;
    
    ret = 0;
    if(str1[index1] == str2[index2]) {
        ret = max(ret, lcs(index1 + 1, index2 + 1) + 1);
    } else {
        ret = max(lcs(index1 + 1, index2), lcs(index1, index2 + 1));
    }
    
    return ret;
}

void reconstruct(int index1, int index2, string& seq) {
    if(index1 < str1.size() && index2 < str2.size()) {
        if(str1[index1] == str2[index2]) {
            seq.push_back(str1[index1]);
            reconstruct(index1 + 1, index2 + 1, seq);
        } else {
            if(cache[index1][index2 + 1] > cache[index1 + 1][index2])
                reconstruct(index1, index2 + 1, seq);
            else reconstruct(index1 + 1, index2, seq);
        }
    }
}

int main() {
    string res;
    cin >> str1 >> str2;
    memset(cache, -1, sizeof(cache));
    
    cout << lcs(0, 0) << '\n';
    reconstruct(0, 0, res);
    if(res.size() != 0) cout << res << '\n';
}

