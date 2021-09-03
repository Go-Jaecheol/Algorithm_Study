# [5014] 스타트링크 - JAVA

## :black_circle: Algorithm
**BFS**

## :black_circle: Logic

```Java
    private static void BFS(){
        Queue<Step> queue = new LinkedList<>();

        queue.add(new Step(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()){
            Step current = queue.poll();

            // 도착했을 때
            if(current.floor == G){
                System.out.println(current.count);
                return;
            }

            // U버튼 누르고 올라가야할 때
            if(current.floor + U <= F && !visited[current.floor + U]){
                queue.add(new Step(current.floor + U, current.count + 1));
                visited[current.floor + U] = true;
            }

            // D버튼 누르고 내려가야할 때
            if(current.floor - D >= 1 && !visited[current.floor - D]){
                queue.add(new Step(current.floor - D, current.count + 1));
                visited[current.floor - D] = true;
            }
        }
        // 이동할 수 없을 때
        System.out.println("use the stairs");
    }
```

현재 층에서 조건을 비교하여 올라갈지 내려갈지를 정하고  
해당 조건을 충족시키지 못하면 이동할 수 없다고 판단하고  
"use the stairs" 출력

## :black_circle: Review
처음에 조건문을 잘못 설정하여 헤매다가 해결한 문제  
생각보다는 어렵지 않았다