n=int(input())
gram=list(map(int,input().split()))

gram.sort()

impo=1
#만들 수 없는 수 찾기
for i in gram:
  if impo<i:
    break
  impo+=i

print(impo)