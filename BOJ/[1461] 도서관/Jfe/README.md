# [1461] 도서관 - Python

## :mag: Algorithm
**Greedy Algorithm**

## :computer: Logic
### `Greedy`

```Python
def checkMid():
    global mid, gt_cnt, lt_cnt
    for i in range(N):
        if book[i] > 0:
            mid = i
            break
    gt_cnt = N - mid
    lt_cnt = N - gt_cnt
```
- **0을 기준으로 양수와 음수의 수를 확인하는 함수**  
  * 함수 호출 전 **오름차순 정렬** 진행  
  * ***0***보다 **큰 값**이 처음으로 나오면 `mid`에 인덱스 저장  
  * **양수 개수**는 `gt_cnt`에 저장, **음수 개수**는 `lt_cnt`에 저장  
---
```Python
def replaceBook():
    global result, location
    gt_mod = gt_cnt % M
    lt_mod = lt_cnt % M

    if abs(book[0]) > book[N-1]:
        if gt_cnt:
            moveGt(gt_mod)
            result += abs(book[location])
        if lt_cnt:
            moveLt(lt_mod)
    else:
        if lt_cnt:
            moveLt(lt_mod)
            result += abs(book[location])
        if gt_cnt:
            moveGt(gt_mod)
```
- **전체 책을 옮기는 함수**  
  * ***M***개 만큼 한번에 옮길 수 있으면 제일 먼 거리부터는 한번에 들 수 있는 최대 양을 들고  
  * **제일 가까운 거리**는 **M으로 나눈 나머지**만큼만 옮기는 것이 최선임  
  * 그래서 양수와 음수의 개수를 M으로 나눈 나머지를 각각 `gt_mod`와 `lt_mod`에 저장  
  * **양수 최댓값**이 **음수 제일 큰 절댓값**보다 크면 음수부터 옮기고 양수를 나중에 옮겨야 함  
  * 반대의 경우에는 반대로 동작하도록  
---
```Python
def moveGt(gt_mod):
    global result, location
    if gt_mod != 0:
        location = gt_mod+mid-1
        result += abs(book[location])
    else:
        location = mid+M-1
        result += abs(book[location])
    while location < N - 1:
        result += abs(book[location])
        location += M
        result += abs(book[location])
```
- **양수인 경우에 책을 옮기는 함수**  
  * `gt_mod`가 ***0***이 아니면 해당하는 `gt_mod`만큼 책을 옮김  
  * 이후에는 `location`이 ***마지막 인덱스***까지 갈 때까지 돌아왔다가 다시 가는 것을 반복  
---
```Python
def moveLt(lt_mod):
    global result, location
    if lt_mod != 0:
        location = mid-lt_mod
        result += abs(book[location])
    else:
        location = mid-M
        result += abs(book[location])
    while location > 0:
        result += abs(book[location])
        location -= M
        result += abs(book[location])
```
- **음수인 경우에 책을 옮기는 함수**  
  * `lt_mod`가 ***0***이 아니면 해당하는 `lt_mod`만큼 책을 옮김  
  * 이후에는 `location`이 ***0***까지 갈 때까지 돌아왔다가 다시 가는 것을 반복    
---

## :memo: Review
> 전반적인 문제의 아이디어는 찾았는데  
> 그 다음에 코드를 짜는 아이디어가 비효율적으로 한 것 같다.
> 
> 양수를 옮기는 경우랑 음수를 옮기는 경우를  
> 각각 따로 함수로 만들었는데  
> 다시 보니까 굳이 저렇게 안해도 더 효율적으로 할 수 있을 것 같다,,,,
> 
> 아직은 문제 풀면서 코드도 예쁘게 짜는건 어려운듯ㅜ
