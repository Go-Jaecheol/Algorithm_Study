#include <iostream>
#include <set>
#include <queue>
#include <algorithm>

using namespace std;

void assign_room(int idx);

int N, rooms = 0;
pair <int, int> lecture[200000];
multiset <int> finish; // 강의 종료시간을 저장하는 공간
int main() {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> lecture[i].first >> lecture[i].second;

	sort(lecture, lecture + N);

	for (int i = 0; i < N; i++)
		assign_room(i);

	cout << finish.size();
}

void assign_room(int idx) {
	if (finish.size() == 0)
		finish.insert(lecture[idx].second);
	else {
		if (lecture[idx].first < *finish.begin())
			finish.insert(lecture[idx].second);
		else {
			finish.erase(finish.begin());
			finish.insert(lecture[idx].second);
		}
	}
}