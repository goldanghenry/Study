import time
start = time.time()
# 거스름돈
N = 1260
OB = 0  # 500원
B = 0   # 100원
OS = 0  # 50원
S = 0   # 10원

if (N >= 500):
    OB = N // 500
    N -= OB * 500
if (N >= 100):
    B = N // 100
    N -= B * 100
if (N >= 50):
    OS = N // 50
    N -= OS * 50
if (N >= 10):
    S = N // 10
    N -= S * 10

print(OB+B+OS+S)
print(time.time()-start)

