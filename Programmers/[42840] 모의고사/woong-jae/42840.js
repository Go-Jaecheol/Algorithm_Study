function solution(answers) {
    let answer = [];
    const std1 = [1, 2, 3, 4 ,5];
    const std2 = [2, 1, 2, 3, 2, 4, 2 ,5];
    const std3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    let checks = [0, 0, 0];
    
    answers.forEach((answer, i) => {
        if(std1[i % std1.length] === answer) checks[0]++;
        if(std2[i % std2.length] === answer) checks[1]++;
        if(std3[i % std3.length] === answer) checks[2]++;
    });
    
    const maxScore = Math.max(...checks);
    
    for(let i = 0; i < 3; i++) {
        if(maxScore === checks[i]) answer.push(i + 1);
    }
    
    return answer;
}
