# [17779] 게리맨더링 2 - JAVA

## :black_circle: Algorithm
**구현 시뮬레이션, Brute Force**

## :black_circle: Logic

```Java
        for(int r = 0; r <= d1 + d2; r++){
            // 가로 길이만큼 표시
            for(int c = 0; c < size; c++)
                isDistrict5[x + r][currentCol + c] = true;

            // 시작열 정해주기
            // 행이 d1만큼 내려오지 않았다면 시작열은 한칸 왼쪽으로
            if (r < d1)
                currentCol--;
                // d1보다 더 많이 내려왔다면 시작열을 한칸 오른쪽으로
            else
                currentCol++;

            // 가로가 커지는 중이면
            if (r < d1 && r < d2)
                size += 2;
            // 가로가 작아지는 중이면
            else if (r >= d1 && r >= d2)
                size -= 2;
        }
```

주어진 조건으로 5구역 찾기 구현  

전체적으로 브루트 포스 알고리즘이기 때문에  
x, y, d1, d2 의 4가지 경우를 4개의 for 문으로 구현하고  
문제에 나와있는 조건을 추가하기만 하면 됨

## :black_circle: Review
이번문제는 브루트 포스라서 시작부터 for 문을 여러개 쓰면 된다고 생각했다  
주어진 조건대로 5구역을 구하고 나머지 조건들로 다른 구역들의 인구수 합을  
합치기만 하면 되는 문제라 크게 어렵지 않았다