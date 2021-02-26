#include <iostream>
#include <algorithm>

using namespace std;

int N, cnt = 0, in = 0;
int* nums;
int* visited;
int ans[100];
int index_arr[100];

void dfs(int idx, int num);

int main() {
	cin >> N;

	nums = new int[N + 1];
	visited = new int[N + 1];
	nums[0] = visited[0] = 1;
	for (int i = 1; i <= N; i++) {
		cin >> nums[i];
		if (i == nums[i]) {
			visited[i] = 1;
			ans[cnt++] = i;
		}
		else
			visited[i] = -1;
	}
		
	for (int i = 1; i <= N; i++)
		if (visited[i] == -1)
			dfs(i, nums[i]);

	sort(ans, ans + cnt);
	cout << cnt << endl;
	for (int i = 0; i < cnt; i++)
		cout << ans[i] << endl;
	delete[] nums, visited;
	return 0;
}

void dfs(int idx, int num) {
	if (visited[idx] == -1) {
		index_arr[in++] = idx;
		visited[idx] = 1;
		for (int i = in - 1; i >= 0; i--) {
			int cur = index_arr[i];
			if (cur == num) {
				for (int j = i; j < in; j++)
					ans[cnt++] = index_arr[j];
				return;
			}
		}
		dfs(num, nums[num]);
	}
	in = 0;
}