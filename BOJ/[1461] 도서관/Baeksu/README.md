# [1461] 도서관 - C ++

## :pushpin: **Algorithm**

그리디 알고리즘, 정렬

## :round_pushpin: **Logic**

```c++
if (n > 0)
    pos_books.push_back(n);
else
    neg_books.push_back(n * -1);
```

- 책의 위치가 **양수**인 경우와 **음수**인 경우를 나누어 저장

```c++
if (!pos_books.empty()) sort(pos_books.begin(), pos_books.end(), comp);
if (!neg_books.empty()) sort(neg_books.begin(), neg_books.end(), comp);
```

- 각각의 경우에 대해, 비어있지 않으면 **내림차순**으로 정렬

```c++
int idx = 0;
int ans = 0;
while (idx < pos_books.size()) {
    ans += 2 * pos_books[idx];
    idx += M;
}
```

- 가장 먼 곳에 있는 책부터 제자리에 가져다 놓기 위해 이동하므로 **가장 먼 곳의 책 위치 * 2**를 해주고 총 `M`권 옮길 수 있으므로 `idx`를 `M`씩 증가

```c++
if (!pos_books.empty() && !neg_books.empty())
    ans -= max(pos_books[0], abs(neg_books[0]));
else if (pos_books.empty())
	ans -= neg_books[0];
else if (neg_books.empty())
	ans -= pos_books[0];
```

- 마지막 책을 제자리에 두고는 원래의 위치로 돌아올 필요가 없기 때문에, 가장 멀리 있는 책의 위치만큼을 빼줘야 함

## :black_nib: **Review**

- 아이디어를 잡는데 어려움이 많아 구글링했음
  - 생각보다 아이디어가 너무 쉬웠음
- 양수, 음수인 경우가 없을 수도 있으므로 이에 대한 예외 처리가 필요
- 이런 깔끔한 생각은 어케 하노 ..
