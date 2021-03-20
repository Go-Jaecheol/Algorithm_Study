# [1092] 배 - C ++

## :pushpin: **Algorithm**

그리디 알고리즘, 정렬

## :round_pushpin: **Logic**

```c++
if (crane[0] < box[0])
		ans = -1;
	else {
		while (1) {
			ans++;
			for (int i = 0; i < N; i++) {
				int m = box.size();
				for (int j = 0; j < m; j++) {
					if (crane[i] >= box[j]) {
						box.erase(box.begin() + j);
						break;
					}
				}
			}
			if (box.size() == 0)
				break;
		}
	}
```

- 내림차순으로 정렬된 `box`와 `crane`의 첫 무게를 비교
  - `box`의 첫 무게가 더 큰 경우, 모든 박스를 옮길 수 없는 경우이므로 `ans = -1`
  - 그렇지 않은 경우에 대하여 무게를 비교하면서 크레인으로 옮길 수 있는 박스를 발견하면 해당 박스를 `box`에서 제거

## :black_nib: **Review**

- 처음에는 수식적으로 생각해서 여러 번 제출했지만 모두 1~2%에서 틀렸음
- 하나의 크레인으로 옮길 수 있는 최대 박스 무게를 선택한다면 최소 시간으로 옮기기 가능했음
- 옮긴 박스를 `0`으로 바꾸어 진행하는 방식으로 접근했으나 어떤 이유에서인지 계속 틀려 게시판 참고
  - `0`으로 수정하지 않고 `box.erase()`함수로 아예 해당 박스를 지워버리는 방식 사용