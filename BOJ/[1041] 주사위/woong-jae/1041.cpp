#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

unsigned long long minimum_dice(unsigned long long n, vector<unsigned long long> d) {
    unsigned long long res = 0;
    
    if (n == 1) {
        sort(d.begin(), d.end());
        for (int i = 0; i < 5; i++) {
            res += d[i];
        }
    } else if (n >= 2){
        unsigned long long point = (unsigned long long)4 * (min(d[2], d[3]) + min(d[0] + d[1], min(d[1] + d[5], min(d[5] + d[4], d[4] + d[0]))));
        unsigned long long min_edge = d[0] + d[1];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i != j && i + j != 5) {
                    min_edge = min(min_edge, d[i] + d[j]);
                }
            }
        }
        unsigned long long edge = (unsigned long long)(4 * (2 * n - 3)) * min_edge;
        sort(d.begin(), d.end());
        unsigned long long face = (unsigned long long)(5 * (n - 2) * (n - 2) + 4 * (n - 2)) * d[0];
        
        res = point + edge + face;
    }
    
    return res;
}

int main() {
    unsigned long long n;
    vector<unsigned long long> dice(6);
    cin >> n;
    for (int i = 0; i < 6; i++) {
        cin >> dice[i];
    }
    cout << minimum_dice(n, dice) << '\n';
}

