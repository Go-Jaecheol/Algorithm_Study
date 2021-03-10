# [1041] 주사위 - Python

## :mag: Algorithm
**Greedy Algorithm**

## :computer: Logic
### `Greedy`

```Python
dice_sorted = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
dice_sorted.sort()
```
- **마주보는 숫자 중 최솟값을 구해서 저장**  
  * **마주보는 숫자들** `(dice[0], dice[5])`, `(dice[1], dice[4])`, `(dice[2], dice[3])` 중 **최솟값**을 구해서 `dice_sorted`에 저장  
  * `dice_sorted`를 **오름차순** 정렬   
---

```Python
def baseFloor():
    global result
    result += (N*4-4) * dice_sorted[0]
    result += 4 * dice_sorted[1]
```
- **옆면에 해당하는 숫자의 최소 합을 구하는 함수**  
  * 맨 위층을 제외하고는 **옆면**의 **최솟값**을 구하는 과정이 같음  
  * 각 **꼭짓점**의 경우에는 **두번째로 작은 수**(`dice_sorted[1]`)가 한번씩은 나와야 함 (`4 * dice_sorted[1]`)  
  * 나머지의 경우에는 **제일 작은 수**(`dice_sorted[0]`)이 나오면 최소 합을 구할 수 있음 (`(N X 4 - 4) X dice_sorted[0]`)  
---
```Python
def topFloor():
    global result
    result += 4 * dice_sorted[2]
    result += (N-2)*4 * dice_sorted[1]
    result += (N-2)*(N-2) * dice_sorted[0]
```
- **맨 윗면에 해당하는 숫자의 최소 합을 구하는 함수**  
  * 각 **꼭짓점**의 경우에는 **세번째로 작은 수**(`dice_sorted[2]`)가 한번씩은 나와야 함 (`4 * dice_sorted[2]`)  
  * 꼭짓점을 제외한 **가장자리** 값들은 **두번째로 작은 수**(`dice_sorted[1]`)가 나와야 함 (`(N-2) X 4 X  dice_sorted[1]`)  
  * 가장자리를 제외한 **중앙** 값들은 **제일 작은 수**(`dice_sorted[0]`)가 나와야 함 (`(N-2) X (N-2) X  dice_sorted[0]`)    
---
```Python
for i in range(N):
    baseFloor()
topFloor()

if N == 1:
    dice.sort()
    result = 0
    for i in range(5):
        result += dice[i]
print(result)
```
- **result 계산**  
  * `baseFloor()`은 ***N***만큼 등장  
  * `topFloor()`은 **맨 윗면**만 해당하기 때문에 한 번 호출  
  * **N**이 ***1***인 경우에는 **예외 처리**  
---

## :memo: Review
> 쉬워보였는데 처음에 문제 이해가 은근 시간이 걸렸다.
> 
> 그려보면서 하니까 방법은 쉽게 찾았는데  
> N이 1인 경우를 생각 못했고  
> 나중에 예외 처리해서 통과했다,,
> 
> 오랜만에 그리디 재밌네 ^^;
