# [2668] 숫자 고르기 - C++

## :pushpin: **Algorithm**

그래프 이론, 그래프 탐색, DFS

## :round_pushpin: **Logic**

```c++
void dfs(int idx, int num);
```

- 배열의 index정보와 index에 해당하는 배열의 값을 가지고 재귀적으로 배열의 값을 index로 하여 탐색하는 함수

```c++
if (i == nums[i]) {
    visited[i] = 1;
    ans[cnt++] = i;
}
else
    visited[i] = -1;
```

- 숫자를 입력받을 때, index와 배열의 값이 같은 경우엔 바로 정답을 저장하는 ans배열에 저장

```c++
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
```

- 방문하지 않은 경우에 대해 index를 저장하는 배열에 함수 인자로 전달된 idx를 저장하고, 배열에 저장된 index값들 중 함수 인자로 전달된 num값과 동일한 경우에 정답을 저장하는 ans배열에 저장
  - 이때, stack처럼 가장 마지막에 들어온 index 값부터 동일한지 확인을 하고 동일한 index를 찾은 경우, 해당 index부터 가장 마지막에 들어온 index까지를 ans배열에 저장
  - 동일한 index를 못 찾은 경우, dfs함수 재귀 호출
- in = 0을 하는 이유는 방문한 경우 또는 ans배열에 저장해야 할 index들을 모두 저장하고 return된 경우에 index_arr배열을 초기화하기 위해 배열 내부를 탐색하는 in변수를 0으로 초기화해줌

## :black_nib: **Review**

- 스택을 사용해서 풀려고 했으나 아직 미숙한 관계로 사용하지 못함 ...
- 코드를 좀 더 깔끔하게 짜는 방법을 연구해야할 듯