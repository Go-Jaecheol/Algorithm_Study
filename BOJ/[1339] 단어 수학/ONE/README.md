# [1339] 단어 수학
## 💡Algorithm
그리디, 브루트포스

## 💡Logic
### --- JAVA ---
알파벳 A 부터 Z에 해당하는 26개짜리 배열 선언  

단아를 한개씩 받으면서 해당하는 알파벳의 (자릿수-1)에 10을 제곱하여 알파벳 배열에 저장

    for(int i = 0; i < N; i++) {
        tmp = scanner.next();
        int len_tmp = (int)Math.pow(10, tmp.length() - 1);
        for(int j = 0; j < tmp.length(); j++){
            alpha[(int)tmp.charAt(j) - 65] += len_tmp;
            len_tmp /= 10;
        }
    }

알파벳 배열을 내림차순으로 큰 수부터 9부터 0 까지 곱해서 더한다

    for(int i = alpha.length - 1; i >= 0; i--){
        if(alpha[i] == 0)
            break;
        sum += alpha[i] * cnt;
        cnt--;
    }

### --- Python ---

JAVA의 코드와 유사

## 💡Review
아이디어를 생각해내는데 오래 걸렸다  
처음에는 0 ~ 9 까지의 10개짜리의 배열을 생각했는데  
26개의 알파벳 수의 배열을 선언하면 더 쉽게 풀 수 있었다