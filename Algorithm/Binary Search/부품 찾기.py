# 부품 찾기
# 동빈이네 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 
# 어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다.
# 동빈이는 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야한다.
# 이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.

# 퀵 정렬 메서드 정의
def quick_sort(array, start, end):
    if start >= end : return
    pivot = start
    left = start +1
    right = end

    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[right], array[left] = array[left], array[right]
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)

# binary search 메서드 정의
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end)//2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array,target,start,mid-1)
    else:
        return binary_search(array, target, mid+1, end)

# 입력 1) 보유 부품(1<= N <=1,000,000)
N = int(input())                        
S = list(map(int,input().split()))

# 입력 2) 손님 요청(1<= M <= 100,000)
M = int(input())    
C = list(map(int, input().split()))

# 보유 부품 리스트 오름차순 퀵 정렬
quick_sort(S, 0, N-1)

# 요청 부품 확인 후 메세지 출력하기
for i in C:
    result = binary_search(S, i, 0, N-1)
    if result != None: print("yes", end=' ')
    else: print('no', end=' ')

