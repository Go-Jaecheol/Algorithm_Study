function solution(numbers) {
    let answer = 0;
    let numberCount = new Array(10).fill(0);
    const isPrime = getPrimeNumbers();
    
    numbers.split('').forEach(num => numberCount[num]++);
    
    for(let i = 1; i < 10; i++) {
        if(numberCount[i] > 0) {
            numberCount[i]--;
            if(isPrime[i]) answer++;
            getNumbers(numberCount).forEach(elem => {
                if(isPrime[+[i].concat(elem).join('')]) answer++;
            });
            numberCount[i]++;
        }
    }
    
    return answer;
}

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
