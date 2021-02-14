import sys

def main():
    str1 = ' ' + sys.stdin.readline().rstrip()
    str2 = ' ' + sys.stdin.readline().rstrip()
    cal(str1, str2)


def cal(s1, s2):
    len1 = len(s1)
    len2 = len(s2)
    res = [[""] * len2 for j in range(len1)]
    for i in range(1, len1):
        for j in range(1, len2):
            if s1[i] == s2[j]:
                res[i][j] = res[i-1][j-1]+s1[i]
            else:
                if len(res[i-1][j]) > len(res[i][j-1]):
                    res[i][j] = res[i-1][j]
                else:
                    res[i][j] = res[i][j-1]

    ans = res[len1 - 1][len2 - 1]
    print(len(ans))
    print(ans)


main()