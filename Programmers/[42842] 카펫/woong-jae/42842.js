function solution(brown, yellow) {
    let answer = [];
    const yellowWidth = yellow;
    let yellowHeight = 1;
    
    while(yellowWidth / yellowHeight >= yellowHeight) {
        if(yellowWidth % yellowHeight === 0) {
            let width = yellowWidth / yellowHeight + 2;
            let height = yellowHeight;
            if((height + width) * 2 === brown) {
                answer[0] = width; answer[1] = height + 2;
                break;
            }
        }
        yellowHeight++;
    }
    
    
    return answer;
}
