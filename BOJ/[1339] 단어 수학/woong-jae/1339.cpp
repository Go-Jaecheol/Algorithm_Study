#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;
vector<string> wordlist;
int assigned[26];

int w_to_i(string bf) {
    int res = 0, digit = 1;
    
    for (int i = (int)bf.length() - 1; i >= 0; i--) {
            res += assigned[bf.at(i) - 65] * digit;
            digit *= 10;
    }
    
    return res;
}

bool compare(pair<int, int> a, pair<int, int> b) {
    return a.second > b.second;
}

int main() {
    int n, res = 0;
    string word;
    vector<pair<int, int>> word_value(26);
    for (int i = 0; i < word_value.size(); i++) {
        word_value[i].first = i;
    }
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        int digit = 1;
        cin >> word;
        for (int i = (int)word.length() - 1; i >= 0; i--) {
            word_value[word.at(i) - 65].second += digit;
            digit *= 10;
        }
        wordlist.push_back(word);
    }
    sort(word_value.begin(), word_value.end(), compare);
    
    int num = 9;
    for (int i = 0; i < 10; i++) {
        assigned[word_value[i].first] = num--;
    }
    
    for (int i = 0; i < (int)wordlist.size(); i++) {
        res += w_to_i(wordlist[i]);
    }
    cout << res << '\n';
}

