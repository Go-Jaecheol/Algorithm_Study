# [14226] 이모티콘 - JAVA

## :black_circle: Algorithm
**Dynamic Programming, BFS**

## :black_circle: Logic

```Java
    private static void BFS(){
        Queue<Step> queue = new LinkedList<>();

        queue.add(new Step(1, 0, 0));
        visited[0][1] = true;

        while (!queue.isEmpty()){
            Step current = queue.poll();

            if(current.screen == S){
                System.out.println(current.sec);
                return;
            }

            // 화면의 이모티콘을 클립보드에 복사
            queue.add(new Step(current.screen, current.screen, current.sec + 1));

            // 클립보드를 화면에 붙여넣기
            if(current.clipboard != 0 && current.screen + current.clipboard <= S && !visited[current.clipboard][current.screen + current.clipboard]){
                queue.add(new Step(current.screen + current.clipboard, current.clipboard, current.sec + 1));
                visited[current.clipboard][current.screen + current.clipboard] = true;
            }

            // 화면의 이모티콘 1개 삭제
            if(current.screen > 0 && !visited[current.clipboard][current.screen - 1]){
                queue.add(new Step(current.screen - 1, current.clipboard, current.sec + 1));
                visited[current.clipboard][current.screen - 1] = true;
            }
        }
    }
```

BFS를 사용해서 풀었던 문제.  
3가지의 경우를 나누어서 큐에 삽입하여 풀면 쉽다.

## :black_circle: Review
내가 생각했던 방법으로 풀었다가 계속 안풀려가지고, 
힌트를 얻어서 풀었던 문제...