# [2631] 줄세우기
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

처음에는 다 옮겨본 후 가장 짧게 옮긴 것은 찾는건가 싶었지만, 너무 무식해서 다른 방법을 생각해보았다.

예제를 보면, 옮기지 않은 숫자들의 공통된 특징이 있다. 옮기지 않은 나머지 수는 수열을 이루고 있다. 바로 "최장 증가 수열"이다. LIS를 이루지 않는 수들만 한 번씩 옮기면 최소로 옮길 수 있다. 따라서 LIS를 구한 후 전체 배열의 크기 n에서 빼주면 원하는 값을 얻을 수 있다.

## 💡Review

어떻게 최소로 옮길지 생각하는데 시간을 대부분 썼다. 알고리즘 자체는 LIS와 별 다를게 없다.
