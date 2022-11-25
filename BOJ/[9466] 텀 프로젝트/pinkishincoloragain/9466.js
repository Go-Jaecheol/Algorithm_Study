const fs = require("fs");
let input = fs
  .readFileSync("./input.txt")
  // .readFileSync("./dev/stdin")
  .toString()
  .split("\n");

const caseNum = input.shift();
// console.log(caseNum)
for (let i = 0; i < caseNum; i++) {
  const ppNum = +input.shift();
  const testCase = input.shift();
  console.log(ppNum - getBelongedToTeamSize([...testCase.split(" ").map(x => +x - 1)]));
}

function getBelongedToTeamSize(choices) {
  const belongedToTeam = new Set();

  for (let i = 0; i < choices.length; i++) {
    let willVisit = [i];
    const team = [];

    while (willVisit.length) {
      const cur = willVisit.pop();
      const next = choices[cur];

      if (team.includes(next)) {
        team.slice(team.indexOf(next), team.length).forEach(x => belongedToTeam.add(x));
        break;
      } else if (belongedToTeam.has(next)) break;
      else {
        team.push(next);
        willVisit.push(next);
      }
    }
  }

  return belongedToTeam.size;
}
