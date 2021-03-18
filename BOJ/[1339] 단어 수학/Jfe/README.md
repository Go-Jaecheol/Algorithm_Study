# [1339] 단어 수학 - Python

## :mag: Algorithm
**Greedy Algorithm**

## :computer: Logic
### `Greedy`

```Python
def calculateDigit():
    alpha.append([0, 'A'])
    for i in range(N):
        for j in range(len(words[i])-1):
            change = False
            for k in range(len(alpha)):
                if words[i][j] == alpha[k][1]:
                    alpha[k][0] += pow(10, len(words[i]) - j - 2)
                    change = True
                    break
            if not change:
                alpha.append([pow(10, len(words[i]) - j - 2), words[i][j]])
```
- **알파벳 자릿수 계산하는 함수**  
  * **alpha** 리스트는 알파벳의 **자릿수**를 저장하는 리스트  
  * **words** 리스트에 있는 알파벳이 **alpha** 리스트에 없으면 **자릿수를 계산**해서 **alpha**에 **append**  
  * **alpha** 리스트에 원래 존재하면 **기존 자릿수에 더해서** 저장  
  * > 입력의 크기가 엄청 작기 때문에 3중 for문으로 구성해도 시간 초과 안나고 괜찮음  
---

```Python
alpha.sort(reverse=True)
for i in range(len(alpha)):
    result += num * alpha[i][0]
    num -= 1
print(result)
```
- **가장 자릿수가 큰 알파벳 순서로 숫자 지정**  
  * alpha **내림차순 정렬**  
  * **가장 자릿수가 큰 알파벳 순서**로 `9 ~ 0` 까지 숫자 지정해서 **result**에 더해서 저장하고 출력  
---

## :memo: Review
> 처음에는 가장 긴 알파벳의 자릿수에 가장 큰 숫자를 주고  
> 이걸 계속 계산하면서 결과를 구하는 방식으로 했는데  
> 이렇게 하니까 예제는 다 통과하는데  
> 다른 반례들에서 막혔다,,,
> 
> 가장 긴 자릿수 하나만을 생각할게 아니라  
> 그 알파벳의 빈도도 생각해야 된다는 말을 보고  
> 알파벳마다 자릿수를 전부 더해서 저장해놓는 리스트를 만드는 방식으로 새로 했다.
> 
> 그리디 알고리즘 자체는 간단한 알고리즘인데  
> 이게 문제마다 생각하는 방식이 조금씩 다르고 한번에 생각 안나면  
> 엄청 꼬이는 것 같음ㅜ
