# [2096] 내려가기 - JAVA

## :black_circle: Algorithm
**Dynamic Programming**

## :black_circle: Logic

```Java
if(i == 0){ 
    // 처음 입력은 저장
    maxDp[0] = minDp[0] = a;
    maxDp[1] = minDp[1] = b;
    maxDp[2] = minDp[2] = c;
}

else {
        // 최댓값의 DP
        int max_tmp_0 = maxDp[0], max_tmp_1 = maxDp[1], max_tmp_2 = maxDp[2];
        maxDp[0] = a + Math.max(max_tmp_0, max_tmp_1);
        maxDp[1] = b + Math.max(Math.max(max_tmp_0, max_tmp_1), max_tmp_2);
        maxDp[2] = c + Math.max(max_tmp_1, max_tmp_2);
        // 최솟값의 DP
        int min_tmp_0 = minDp[0], min_tmp_1 = minDp[1], min_tmp_2 = minDp[2];
        minDp[0] = a + Math.min(min_tmp_0, min_tmp_1);
        minDp[1] = b + Math.min(Math.min(min_tmp_0, min_tmp_1), min_tmp_2);
        minDp[2] = c + Math.min(min_tmp_1, min_tmp_2);
}
```

최댓값을 구하는 DP 배열과 최솟값을 구하는 DP 배열을 따로 둬서,  
아래의 것을 기준으로 위의 3개의 배열에서 올수 있는 경우의 수를 따진다.  
[0]의 배열에서는 위의 [0],[1] 배열이 올 수 있고,  
[1]의 배열에서는 위의 [0],[1],[2] 배열이 올 수 있고,  
[2]의 배열에서는 위의 [1],[2] 배열이 올 수있다.

## :black_circle: Review
위에서 아래로 내릴 수 있는 것들을 생각하다가 풀지 못해서,  
힌트를 받아 풀었던 문제