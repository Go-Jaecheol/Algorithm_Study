# [17281] ⚾ - JAVA

## :black_circle: Algorithm
**브루트 포스**, **DFS**

## :black_circle: Logic

- 1번 선수를 제외한 2번 ~ 9번 선수를 나열하는 순열에 대한 문제였다.  


**DFS** 를 이용하여 order 배열에 인덱스 4번은 선수 1번이 고정으로 제외하고  
나머지 선수들을 각 order 인덱스에 넣으면서  
DFS를 통해 얻은 order 배열을 이용해 야구를 진행하여 점수를 계산해주는  
**int baseball()**  함수로 최대 점수의 값을 구한다.
```Java
    private static void DFS(int depth){
        if(depth == 9){
            int temp = 45;
            for(int i = 1; i <= 8; i++)
                temp -= order[i];
            order[depth] = temp;
            max = Math.max(max, baseball());
            return;
        }
        for(int i = 2; i <= 9; i++){
            if(!visited[i]){
                visited[i] = true;
                if(depth != 4)
                    order[depth] = player[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
```

- 그리고 DFS의 종료조건인 depth = 9 일 때,  
이전 호출에서 order[9]에 값이 들어갔지 않았기 때문에,  
1부터 9의 합인 45에서 order[1] ~ order[8]의 선수 번호들을 빼서  
남은 수에 해당하는 선수의 번호를 order[9]에 넣는다.

## :black_circle: Review
순열은 빨리 생각해내서 구현 자체는 빨리했는데,  
위의 종료조건에서 order[9] 자리가 빠져서 답이 자꾸 틀려서  
print 디버깅으로 해결한 문제  
뭔가 잘짠 코드는 아닌것 같다...