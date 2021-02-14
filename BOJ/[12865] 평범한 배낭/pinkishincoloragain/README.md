# [12865] 평범한 배낭
## 💡Algorithm

다이나믹 프로그래밍

## 💡Logic

발상이 조금 좆같았는데 왜 남은 걸 선택해야 하는지는 책 조금 보고 깨달았다

    if idx == N or rest_k == 0:
        # print("case 1")
        return cur_v

    elif rest_k >= items[idx][0]:
        # print("case 2")
        return max(inbag(idx+1,cur_v+items[idx][1],rest_k-items[idx][0]),
                   inbag(idx+1,cur_v,rest_k))

    else:
        # print("case 3")
        return inbag(idx+1,cur_v,rest_k)



if 에서 가방 꽉찼거나 아이템 끝까지 돌았으면 경우
elif 에서 담을지 말지 경우 나누고
else에서는 가방 공간 없어서 안 담는 경우인데..

중요한 건 cache를 안 썼다.
그래서 시간초과뜬듯.


## 💡Review

dp를 쓸 타이밍을 잘 잡아 보자.. 아주 알 수 없지만 어디서부터 잡아야 할지 감도 안 오지만..

휴



