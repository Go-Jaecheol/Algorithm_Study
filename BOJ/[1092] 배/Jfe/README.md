# [1092] 배 - Python

## :mag: Algorithm
**Greedy Algorithm**

## :computer: Logic
### `Greedy`

```Python
crane.sort(reverse=True)
box.sort(reverse=True)
```
- **크레인, 박스 내림차순 정렬**  
  * 각각 크레인마다 자신이 들 수 있는 **최대치**부터 먼저 들게 하기 위해  
  * `crane`, `box` 리스트 둘 다 **내림차순 정렬**
---

```Python
def moveBox():
    isChange = False
    for i in range(N):
        for j in range(len(box)):
            if not box:
                return isChange
            if crane[i] >= box[j]:
                isChange = True
                del box[j]
                break
    return isChange
```
- **가능한 최대 무게의 박스를 옮기는 함수**  
  * 크레인이 들 수 있는 무게 보다 박스의 무게가 **작거나 같으면** (`crane[i] >= box[j]`)  
  * 해당 박스를 리스트에서 **삭제**하고 (`del box[j]`)  
  * 더 이상 옮길 수 있는지 없는지 나중에 확인 하기 위해 **isChange**를 ***True***로 변경  
  * (**isChange**가 ***False***인 상태로 함수가 반환되면 **아무 박스도 못 옮겼다는 걸 의미**)  
---

## :memo: Review
> 위에처럼 코드를 짜니까 PyPy3로만 통과했다.  
> PyPy3로 통과해도 상관은 없지만 아슬아슬하게 통과한 것 같고  
> 코드가 효율적이지 못하다는 것 같아서 다른 방법도 찾아봤다.
> 
`del box[j]` 처럼 **del** 을 사용하면 시간복잡도가 `O(n)`이 나오지만  
`pop()`을 사용하면 `O(1)`이라는 걸 알게 되었고  
**Binary Search**를 사용해서 for문 하나를  
`O(n) -> O(logn)`으로 바꿀 수 있다는 걸 알게 된 후 코드를 다음과 같이 수정했다.  
```Python
from bisect import bisect_right
import sys
N = int(sys.stdin.readline())
crane = [int(x) for x in sys.stdin.readline().split()]
M = int(sys.stdin.readline())
box = [int(x) for x in sys.stdin.readline().split()]
time = 0

def moveBox():
    isChange = False
    for i in crane:
        if not box:
            break
        location = bisect_right(box, i)
        if location == 0:
            break
        elif location == len(box):
            box.pop()
            isChange = True
        else:
            box.pop(location - 1)
            isChange = True
    return isChange

crane.sort(reverse=True)
box.sort()
while box:
    if moveBox() == False:
        time = -1
        break
    time += 1
print(time)
```
* **bisect** 모듈을 통해 **이진 탐색 함수**를 사용할 수 있다.  
* `bisect_right(a, x)`는 ***x***가 ***a***에 있으면 **기존 항목 뒤(오른쪽)의 위치**를 반환한다.  
* `pop()`을 활용하기 위해 **box**는 **오름차순 정렬**  
* **location**이 ***0***이면 옮길 수 있는 박스가 없다는 뜻이므로 **break**  
* **location**이 ***len(box)면*** 제일 마지막 박스를 옮길 수 있다는 뜻이므로 `box.pop()`  
* 나머지의 경우에는 **location**이 기존 항목 뒤(오른쪽)의 위치이기 때문에 `box.pop(location - 1)`  
---
이렇게 할 경우  
Python3로도 통과하고  
![1092](https://user-images.githubusercontent.com/33208246/111155990-8f631e80-85d8-11eb-8639-6c8864e981cf.JPG)  
시간이 **2860ms -> 80ms** 까지 줄어든 것을 볼 수 있다.

---
이번 문제는 진짜 배운게 많은듯,,  

시간복잡도를 평소에 거의 신경 안쓰고 풀었는데  
Python으로 할거면 앞으로 시간에 신경 쓰고  
효율적인 코드에 대해서 많이 생각해봐야겠다..
