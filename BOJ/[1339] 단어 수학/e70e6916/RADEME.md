# [1139] 단어 수학 - Python

## :mag: Algorithm

**Greedy**


**Brute Force**


## :round_pushpin: Logic

```python
    for i in range(N):
        words_len = len(words[i])
        for j in range(words_len):
            if words[i][j] not in word_data:
                word_data[words[i][j]] = 0
            word_data[words[i][j]] += 10 ** (words_len - j - 1)
```
2차원 배열로 입력받은 단어 문장들을 2중 for문으로 탐색하며
**해당 단어를 key 값으로 가진 dictionary ```word_data```에 자릿수를 업데이트한다.**


```python
    for x in sorted(word_data.values(), reverse=True):
        _sum += value * x
        value -= 1
    print(_sum)
```
그 후, 최종 업데이트 된 dictionary ```word_data```의 value값을 기준으로 **내림차순 정렬**한 값들을
반복문을 이용하여 최대합을 구한다.

## :memo: Review

``` 
    2
    AB
    BB
```
처음에 위와 같은 반례에 막혔었다. 이를 해결하기 위해 고민하여 dictionary에 자릿수만 업데이트 한 후, 
마지막에 자릿값을 곱하여 더해주는 방법을 적용했다. 
