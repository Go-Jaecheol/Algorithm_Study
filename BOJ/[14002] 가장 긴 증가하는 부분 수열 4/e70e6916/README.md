# [14002] 가장 긴 증가하는 부분 수열 4 - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

```angular2html
for i in range(N):
    for j in reversed(range(i)):
        if A[i] > A[j] and len_data[i] <= len_data[j]:
            len_data[i] = len_data[j] + 1
            seq_data[i] = seq_data[j].copy()
    seq_data[i][i] = 1
```
증가하는 부분 수열의 길이를 나타내는 ```len_data```를 구함과 동시에 수열을 **2차원 배열**로 나타낸 ```seq_data```를 업데이트한다.
```
6
10 20 10 30 20 50
```
예를 들어 입력이 위와 같을 경우,
```angular2html
[[1, 0, 0, 0, 0, 0]
 [1, 1, 0, 0, 0, 0]
 [0, 0, 1, 0, 0, 0]
 [1, 1, 0, 1, 0, 0]
 [0, 0, 1, 0, 1, 0]
 [1, 1, 0, 1, 0, 1]]
```
이와 같이 ```seq_data```의 업데이트가 완료된다.

```len_data```의 max가 **가장 긴 증가하는 부분 수열의 길이**가 되고, ```len_data```의 max가 있는 index를 row로 가지는 ```seq_data```의 값들이 1인지 확인하면 **가장 긴 증가하는 부분 수열** 또한 구할 수 있다.

## :memo: Review
지난 주 **[11053] 가장 긴 증가하는 부분 수열**에서 구현한 코드를 이용하려 했지만 ```sort```로 인해 수열이 섞이게 되어 문제를 해결하기 힘들었다. 

**LCS**를 했을 때의 느낀점을 통해 내 코드에 크게 집착하지 않고 새로 구현했다. 2차원 배열을 이용하는 아이디어가 금방 떠올라 빠르게 해결할 수 있었다.