#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int find(int i);
void unite(int i, int j);

int G, P, ans = 0;
vector<int> parent;
int main() {
	cin >> G >> P;

	parent.resize(G + 1);
	for (int i = 1; i < G + 1; i++) {
		parent[i] = i;
	}

	for (int i = 0; i < P; i++) {
		int x;
		cin >> x;
		int gate = find(x);
		if (gate == 0)
			break;
		unite(gate, gate - 1);
		ans++;
	}

	cout << ans;
	return 0;
}

int find(int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = find(parent[i]);
}

void unite(int i, int j) {
	i = find(i);
	j = find(j);
	parent[i] = j;
}