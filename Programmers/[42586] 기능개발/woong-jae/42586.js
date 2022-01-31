function solution(progresses, speeds) {
    let answer = [];

    let neededDays = new Array(progresses.length);
    progresses.forEach((progress, i) => {
        let leftProgress = 100 - progress;
        let neededDay = Math.ceil(leftProgress / speeds[i]);
        neededDays[i] = neededDay;
    });

    neededDays.reverse();
    while(neededDays.length) {
        let nextRelease = neededDays.pop();
        answer.push(1);
        while(neededDays.length && neededDays[neededDays.length - 1] <= nextRelease) {
            answer[answer.length - 1]++;
            neededDays.pop();
        }
    }

    return answer;
}
