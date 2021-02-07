# [9251] LCS - Python

## :mag: Algorithm

Dynamic Programming

## :round_pushpin: Logic

두 문자열을 2중 for문으로 비교하여 같을 문자일 경우 비교한 문자가 나오기 직전의 LCS 길이에 +1을 한다.
```        
if s1[i] == s2[j]:
    dp[i][j] = dp[i - 1][j - 1] + 1
```
만약, 같은 문자가 아닐 경우 기존 LCS 길이를 그대로 갖는다. 기존 LCS 길이로 ```dp[i - 1][j]```와 ```dp[i][j - 1]```가 있는데 둘 중 더 큰 값을 선택한다.
```
dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
```

## :memo: Review
처음에는 1차원 배열을 이용하여 시도했다. 웬만한 test case들을 성공했지만 백준에서는 계속 틀렸다. 결국 아래와 같은 반례를 찾았지만, 반례의 문자열이 너무 긴 나머지 어느 부분에서 어긋난 것인지 파악하기 너무 힘들었다. 이 것 때문에 5시간 정도 소요했다...
AACGGAACACGCTTTAAGGGCGATGGAATACCGTGGGTTTACCTAAAACTA
AATCTGGCCTATTCTGGGTCAAATGGCGTGAGCAAACATCGTACA

결국 코드를 싹 다 지우고 2차원 배열을 이용하는 방법으로 다시 구현했다. 새로 구현한 코드가 처음 구현했던 코드보다 더 간결해졌고, 해결하지 못했던 위 반례를 성공할 수 있었다.   

다음부터는 도저히 안풀릴 때 내 코드에 너무 집작하지 말고 신속히 새로운 방법을 고안해봐야 겠다.