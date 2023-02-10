
result = -1
t1=''
t2=''
# 가장 큰 회문을 찾는 것이므로 거꾸로 루프
for i in range(999,100,-1):
    for j in range(999,100,-1):
        temp = i*j
        t1 = str(temp)
        t2 = t1[::-1]
        if t1 == t2 and result < temp:
            result = temp
print(t1, t2, result)
print("work1")
print("work2")
