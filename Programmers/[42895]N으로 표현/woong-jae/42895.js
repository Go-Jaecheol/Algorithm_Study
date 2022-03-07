function solution(N, number) {
    const cand = [];
    
    let used = 0;
    while(used < 9) {
        let next = new Set();
        for(let i = 0; i < used; i++) {
            cand[i].forEach(num1 => {
                cand[used - i - 1].forEach(num2 => {
                    next.add(num1 + num2);
                    next.add(num1 * num2);
                    next.add(num1 - num2);
                    next.add(Math.floor(num1 / num2));
                });
            });
        }
        let combined = +String(N).repeat(used + 1);
        next.add(combined);
        cand.push(next);
        if(cand[used++].has(number)) return used;
    }
    
    return -1;
}
