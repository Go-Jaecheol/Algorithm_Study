function solution(n, times) {
    let answer = 0;

    let min = 0, max = times[times.length - 1] * n;
    while(min <= max) {
        let mid = Math.floor((min + max) / 2);
        let done = 0;
        times.forEach(time => {
            done += Math.floor(mid / time);
        });
        if(done >= n) {
            max = mid - 1;
            answer = mid;
        }
        else min = mid + 1;
    }
    
    return answer;
}
