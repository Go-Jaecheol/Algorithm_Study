function solution(number, k) {
    let answer = '';
    
    for(let numberIndex = 0; numberIndex < number.length; numberIndex++) {
        if(k === 0 || answer.length === 0 || answer[answer.length - 1] > number[numberIndex]) {
            answer += number[numberIndex];
            continue;
        }

        while (k > 0 && answer[answer.length - 1] < number[numberIndex]) {
            answer = answer.slice(0, answer.length - 1);
            k--;
        }
        answer += number[numberIndex];
    }
    
    if (k > 0) answer = answer.slice(0, answer.length - k);
    
    return answer;
}
