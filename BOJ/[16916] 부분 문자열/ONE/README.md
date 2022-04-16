# [16916] 부분 문자열 - JAVA

## :black_circle: Algorithm
**KMP**

## :black_circle: Logic

> _Key Idea_
> - KMP 알고리즘을 사용하여 푸는 문제
> -  불일치가 발생한 앞부분에 대해서 다시 비교하지 않으면서 매칭이 일어나는지 판단 


```Java
private static boolean KMP(String origin, String sub) {
    int originLen = origin.length(), subLen = sub.length();
    int[] table = makeTable(sub);

    int j = 0;

    for (int i = 0; i < originLen; i++) {
        while (j > 0 && origin.charAt(i) != sub.charAt(j))
            j = table[j - 1];

        if (origin.charAt(i) == sub.charAt(j)) {
            if(j == subLen - 1)
                return true;
            j++;
        }
    }

    return false;
}
```

## :black_circle: Review
처음에는 그냥 문자열을 비교하여 푸는 방식으로 접근했는데  
어떤 방법을 써도 시간초과가 발생했고 결국 KMP 알고리즘을  
사용했어야한다는 것을 알고 풀 수 있었다  
나중에 코딩테스트에 나오게 되면 크게 도움이 될 것 같은 알고리즘
