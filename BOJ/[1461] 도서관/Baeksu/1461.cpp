#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool comp(int a, int b) {
	return a > b;
}

int N, M;
vector<int> pos_books;
vector<int> neg_books;
int main() {
	cin >> N >> M;

	while (N--) {
		int n;
		cin >> n;
		if (n > 0)
			pos_books.push_back(n);
		else
			neg_books.push_back(n * -1);
	}

	if (!pos_books.empty()) sort(pos_books.begin(), pos_books.end(), comp);
	if (!neg_books.empty()) sort(neg_books.begin(), neg_books.end(), comp);

	int idx = 0;
 	int ans = 0;
	while (idx < pos_books.size()) {
		ans += 2 * pos_books[idx];
		idx += M;
	}
	idx = 0;
	while (idx < neg_books.size()) {
		ans += 2 * neg_books[idx];
		idx += M;
	}

	if (!pos_books.empty() && !neg_books.empty())
		ans -= max(pos_books[0], abs(neg_books[0]));
	else if (pos_books.empty())
		ans -= neg_books[0];
	else if (neg_books.empty())
		ans -= pos_books[0];
	cout << ans;
	return 0;
}