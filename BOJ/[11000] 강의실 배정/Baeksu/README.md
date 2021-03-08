# [11000] 강의실 배정 - C ++

## :pushpin: **Algorithm**

자료구조, 그리디 알고리즘, 정렬, 우선순위 큐

## :round_pushpin: **Logic**

```c++
multiset <int> finish;
```

- 강의 종료 시간을 저장할 공간

```c++
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
```

- 강의 시작시간과 `finish`에 저장된 종료시간을 비교하며 `finish`에 종료시간을 저장하는 함수
  - `finish`가 비어있다면 전달받은 `idx`의 강의 종료시간을 저장
  - `finish`에 저장된 종료시간보다 전달받은 강의 시작시간이 더 작은 경우 (**즉 종료되기 전 강의가 시작되는 경우**) `finish`에 저장된 강의와 다른 강의실을 사용해야 하므로 `finish`에 저장
  - 그렇지 않은 경우 (**즉 저장된 종료시간과 전달된 시작시간이 같거나 나중인 경우**) `finish`에 저장된 강의와 같은 강의실을 사용할 수 있으므로 현재 저장된 종료시간을 지우고 새로운 종료시간을 저장

## :black_nib: **Review**

- **ABCDE** 문제처럼 그래프와 방문 여부 등을 사용해서 푸는 방법밖에 생각나지 않아서 시간이 걸림
- **회의실 배정** 문제와 큰 틀은 비슷
- 강의 시작 시간보다는 종료 시간에 더 초점을 두어야하므로 종료시간을 저장하여 해결
  - 이 과정에서 게시판 글들을 보다가 `multiset`이라는 새로운 자료형이 보여서 구글링해보고 사용
- `c++`에는 진짜 많은 자료형들이 존재하는 것 같음
