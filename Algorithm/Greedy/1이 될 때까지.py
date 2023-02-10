# 1이 될 때까지
# 2018 E 기업 알고리즘 대회
# 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
# 단, 두번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.

# 1) N에서 1을 뺀다
# 2) N을 K로 나눈다

# 입력
N, K = map(int, input().split())
count = 0

# 알고리즘
while True:
    if N % K == 0:  # 나누기부터
        N //= K
        count += 1
    elif N > K:     # 나머지 빼주기
        count += N%K
        N -= N%K   
    elif N < K:     # 
        count += (N-1)
        N = 1
    if N == 1: break



