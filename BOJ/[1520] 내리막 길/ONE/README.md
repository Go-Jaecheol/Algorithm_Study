# [1520] 내리막 길
## 💡Algorithm
다이나믹 프로그래밍, 그래프

## 💡Logic
입력 받은 배열과 동일한 사이즈의 visited 배열을 선언한다

(0, 0)부터 시작해서 우, 하, 좌, 상의 순서로 검사해서 재귀하는데

만약에 방문했던적이 있던 곳이라면 재귀 들어가지않고 visited에 들어있는 값을 그대로 더해준다

그리고 새로 방문하는 곳이라면 재귀들어가서 새로운 루트를 찾는다


## 💡Review
생각안나서 3일 동안 머리싸맨 문제

결국 힌트 보고 풀었지만 나는 생각이 상당히 단순한가보다

그리고 백준에서 런타임에러로 재귀제한이 있다는걸 처음 알았다

다들 어캐했노...
