# 십자 뒤집기
# https://codeup.kr/problem.php?id=6096
# list comprehension
# [ 출력식 for 변수 in (반복변수) // {조건} ]
# a = [ x*2 for x in range(10) if x>5 ]

# 바둑판 배열 초기화
d = [[ 0 for j in range(19)] for i in range(19)]

# 입력
for i in range(19):
    a = input().split()
    for j in range(19):
        d[i][j] = int(a[j])

# 뒤집기 횟수
n = int(input())

# 십자 뒤집기 좌표 입력
for i in range(n):
    x,y = input().split()
    for j in range(19):
        if d[int(x)-1][j] == 0: d[int(x)-1][j]=1
        else: d[int(x)-1][j] =0
    for j in range(19):
        if d[j][int(y)-1] == 0: d[j][int(y)-1]=1
        else: d[j][int(y)-1] = 0


# 바둑판 출력
for i in range(19):
    for j in range(19):
        if j == 18: print(d[i][j])
        else: print(d[i][j], end=' ')