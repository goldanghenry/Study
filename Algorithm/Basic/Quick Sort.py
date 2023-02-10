# 퀵 정렬
# 기준 데이터를 설정하고 그 기준보다 큰 데이터와 큰 데이터의 위치를 바꾼다.
# 피벗(Pivot) : 큰 숫자와 작은 수를 교환할 때, 교환하기 위한 기준
# 호어 분할(Hoare Partition) : 리스트에서 첫 번째 데이터를 피벗으로 설정
# 왼쪽에서 피벗보다 큰 데이터를 찾고, 오른쪽에서 피벗보다 작은 데이터를 찾아 그 위치를 교환
# 만약, 엇갈린다면 피벗과 작은 수의 위치를 교환. 피벗을 기준으로 좌우 분할(Divide).
# 각 파티션 별로 위의 동작 반복(재귀 함수 형태로 구현)
# 종료조건 : 리스트의 원소가 1개일 때

array = [ 5, 7, 9, 0, 3, 1, 6, 2, 4, 8 ]

# 직관적인 형태의 퀵 정렬 소스코드
def quick_sort(array, start, end):
    if start >= end: # 원소가 1개인 경우 종료
        return
    pivot = start # 피벗은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복
        while right > start and array[right] >= array[pivot]:
            right += 1
        if left > right: # 엇갈렸다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: # 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]

    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quick_sort(array, start, right -1)
    quick_sort(array, right+1, end)

quick_sort(array, 0, len(array)-1)
print(array)
   

# 파이썬의 장점을 살린 퀵 정렬 소스코드
def quick_sort2(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array

    pivot = array[0]    # 피벗은 첫 번째 원소
    tail = array[1:]    # 피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot]    # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot]     # 분할된 오른쪽 부분

    # 분할된 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트를 반환
    return quick_sort2(left_side) + [pivot] + quick_sort2(right_side)

print(quick_sort2(array))

# 퀵 정렬의 평균 시간 복잡도 : O(NlogN)
# 이미 정렬되어 있는 경우 매우 느리게 동작한다. <-> 삽입 정렬


