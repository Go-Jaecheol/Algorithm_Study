#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}

int N, num = 9, max_size = 0;
int w[26];
vector<string> words;
//가장 길이가 긴 문자열부터 큰 숫자 부여
int main() {
	cin >> N;
	int max_sum = 0;

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		words.push_back(s);
	}
	for (int i = 0; i < N; i++) {
		string s = words[i];
		int p = 1;
		for (int j = s.size() - 1; j >= 0; j--) {
			w[s[j] - 65] += p;
			p *= 10;
		}
	}
	sort(w, w + 26, cmp);
	
	for (int i = 0; i < 26; i++) {
		if (w[i] == 0)
			break;
		max_sum += (w[i] * num--);
	}
	cout << max_sum;
	return 0;
}