function solution(numbers) {
    numbers.sort((a, b) => {
        [a, b] = [a.toString(), b.toString()];
        return (b + a) - (a + b);
    });
    if(numbers[0] === 0) return "0";
    return numbers.join("");
}
