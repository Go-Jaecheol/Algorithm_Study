# [9935] 문자열 폭발 - JAVA

## :black_circle: Algorithm
**String**

## :black_circle: Logic
> _Key Idea_
>- `target` 문자열에서 한 글자씩 `StringBuilder`에 넣는다
>- `builder` 의 길이가 `Bomb` 문자열보다 길어졌을때 부터,  
>- 한글자씩 비교하며 만약 같다면 바로바로 그 문자열을 삭제해 준다

```Java
for (int i = 0; i < target.length(); i++) {
    char c = target.charAt(i);

    builder.append(c);

    if (builder.length() >= bomb.length()) {
        boolean check = true;

        for (int j = 0; j < bomb.length(); j++) {
            char targetC = builder.charAt(builder.length() - bomb.length() + j);
            char bombC = bomb.charAt(j);

            if (targetC != bombC) {
                check = false;
                break;
            }
        }

        if (check)
            builder.delete(builder.length() - bomb.length(), builder.length());
    }
}
```

## :black_circle: Review
처음에는 그냥 `String` 으로만 풀었는데 계속 시도해도 메모리 초과가 났다  
결국 질문을 참고하여 바로바로 확인하여 제거해야 된다는 것을 확인하고  
`StringBuilder`를 이용해 문제를 해결했다
