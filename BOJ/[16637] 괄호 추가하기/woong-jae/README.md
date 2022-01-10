# [16637] 괄호 추가하기
## Algorithm
- Bruteforce
## Logic
### 괄호 추가하기
괄호 추가하는 작업을 일반화 할 수 있다.

'현재 operator를 선택하고 나머지에 괄호 선택한 것' + '선택하지 않고 나머지 괄호에서 선택한 것'

현재 operator를 선택하면 다음 operator는 선택할 수 없기 때문에 다음다음으로 넘어간다. 선택하지 않았다면 다음 operator에서 다시 선택하거나 안하거나 한다.

이것을 코드로 구현하면 아래와 같다.
```js
function getAllChoices(pickOption, currentIndex) {
    if (currentIndex >= pickOption.length - 1) return [[]];
    
    const allChoices = [];
    // Pick current index
    const pickChoices = getAllChoices(pickOption, currentIndex + 4);
    pickChoices.forEach(choice => allChoices.push([currentIndex].concat(choice)));
    // Not pick current index
    const notPickChoices = getAllChoices(pickOption, currentIndex + 2);
    notPickChoices.forEach(choice => allChoices.push(choice));

    return allChoices;
}
```
### 계산하기
식을 쭉 지나가면서 괄호 씌운 것을 먼저 계산한 후에, 나머지 식을 다시 계산해준다.
``` js
function calculate(choice, formulaString) {
    const picked = {};
    const formula = formulaString.split('');
    
    choice.forEach(pick => picked[pick] = true);

    // 괄호 먼저 처리
    const stack = []; 
    for (let formulaIndex = 0; formulaIndex < formula.length; formulaIndex++) {
        const element = formula[formulaIndex];
        if ("+-*".includes(element)) {
            if (picked[formulaIndex]) {
                const partialCalc = operation(stack.pop(), +formula[++formulaIndex], element);
                stack.push(partialCalc);
            } else {
                stack.push(element);    
            }
        } else {
            stack.push(+element);
        }
    }
    
    // 나머지 식 계산
    let res = stack.shift();
    while (stack.length) {
        const operator = stack.shift();
        const b = stack.shift();

        res = operation(res, b, operator);
    }

    return res;
}
```
## Review
처음 풀어보는 유형이라 뇌정지가 좀 왔었다. 괄호 씌우는 것이 어려울 줄 알았지만, 계산하는 것을 구현하는 것도 만만치않게 어려웠다.

왜 나는 bruteforce 문제가 더 어려운 것 같지... 시간을 많이 쓴 문제.
