# [42839] 소수 찾기
## Algorithm
- Brute Force
- Sieve of Eratosthenes(에라토스테네스의 체)
## Logic
1. '에라토스테네스의 체' 알고리즘으로 범위 내(< 10000000)의 소수를 찾아낸다.
```js
function getPrimeNumbers() {
    const isPrime = new Array(10000000).fill(true);
    isPrime[0] = false; isPrime[1] = false;
    
    for(let num = 2; num < 10000000; num++) {
        if(!isPrime[num]) continue;
        for(let mult = num * 2; mult < 10000000; mult+=num) {
            isPrime[mult] = false;
        }
    }
    
    return isPrime;
}
```
2. 주어진 종이 조각으로 만들 수 있는 모든 수를 만들어 소수인 것만 확인한다.

만들 수 있는 모든 수를 확인할 때, '종이 조각을 사용했는지 안했는지'가 아닌 종이 조각에 적힌 숫자를 카운트 하는 방식으로 접근했다. 종지 조각을 사용했는지 여부를 확인하면 중복되는 수가 발생할 수 있기 때문이다. 
예를 들어, [0, 1, 1]이 주어졌을 때, 2번 선택 후 3번 사용하는 것과 3번 선택 후 2번 사용하는 것이 같다.

```js
function getNumbers(numberCount) {
    const numbers = [];
    
    for(let i = 0; i < 10; i++) {
        if(numberCount[i] > 0) {
            numberCount[i]--;
            numbers.push([i]);
            let smallerNumbers = getNumbers(numberCount);
            smallerNumbers.forEach(number => numbers.push([i].concat(number)));
            numberCount[i]++;
        }
    }
    
    return numbers;
}
```

## Review
수를 만드는 것에서 생각하느라 좀 걸린 문제다. 다음에 비슷한 문제를 푼다면 더 빨리 풀 수 있을 것 같다.
