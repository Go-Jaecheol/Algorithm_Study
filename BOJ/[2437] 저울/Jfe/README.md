# [2437] 저울 - Python

## :mag: Algorithm
**Greedy Algorithm**

## :computer: Logic
### `Greedy`

```Python
weight.sort()
for i in range(N):
    if sum+1 >= weight[i]:
        sum += weight[i]
    else:
        break
print(sum+1)
```
- **정렬 후 계산**  
  * 지금까지 `weight`들의 **합** `sum`과 다음에 나오는 `weight`값을 비교  
  * `sum + 1`이 다음 `weight[i]`보다 **작으면** 무조건 `sum + 1`이 **정답**이므로 **break**  
  * **크거나 같은** 경우에는 `sum`에 **더해주고** for문 끝날 때까지 **반복**  
---

## :memo: Review
> 알고리즘만 바로 떠올리면 쉽게 코드를 짤 수 있는 문제  
> 
> 하지만 바로 떠올리는게 시간이 오래 걸렸다..  
> 계속 끄적거리다가 결국에 생각해내긴 했는데  
> 그래도 마음에 안든다.  
> 그냥 그리디는 머리 좋은 사람 가르는 창의력 문제 같음;;
> 
> 이런거 풀때마다 느끼는게  
> 정보올림피아드 나가서 이거 푸는 초등학생들은 대체 어떤 사람들일까
