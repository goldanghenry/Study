# 큰수 A+B
# 백준 10757번

# 입력 조건 : 0 < A,B < 10^10000(INF)
A,B = input().split()

# 앞에 '0'을 채워 자릿수 맞추기
if len(A) > len(B): B = '0'* (len(A)-len(B)) + B
elif len(A) < len(B): A = '0'* (len(B)-len(A)) + A

# 덧셈 알고리즘
R =[]

carry = 0
for i in range(1, len(A)+1):
    t= int(A[-i]) + int(B[-i])       # 1의 자리부터 더하기
    if carry == 1:                   # 올림수(carry)
        t += 1
        carry = 0
    if t > 9: 
        R.append(t-10)
        carry +=1
        if i == len(A): R.append(1)  # 루프 마지막 carry 발생시 제일 앞에 1을 추가
    else: R.append(t)

# 1의 자리부터 출력하기 위해 순서 뒤집기
R.reverse()                          

# 출력
for i in R:
    print(i, end='')
print()

