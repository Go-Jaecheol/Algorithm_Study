### 사용한 알고리즘
* dynamic programming
_____________________________________________________
### Logic
* 수열이 주어지면, 맨 앞 수부터 자신의 앞에 자신보다 작은 수가 얼마나 있나 체크함.
* 무조건 길이가 1 이상인 수열이 생기니 수열의 길이만큼 1이 저장된 배열을 미리 만들어 놓는다.
* j번째 수가 i번째 수보다 작으면 j번째 수의 결과에 1을 더한 값을 i번째 수의 res와 비교.
* 비교한 것 중 큰수를 i번째 res에 저장.
_____________________________________________________
### Review
이것도 처음 접근을 중복하는 수를 다 없앤 다음 정렬하는 방식을 써서 수열의 길이를 구하면
그것이 바로 가장 긴 부분수열이지 않나? 해서 접근했음.
그렇게 하는게 아니라고. 점화식을 짜는 것이 상당히 어렵다.
