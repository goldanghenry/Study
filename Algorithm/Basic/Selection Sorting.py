# 선택 정렬(Selection sorting)
# 데이터가 무직위로 여러 개 있을 때, 이중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 
# 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복하 것.

array = [7,5,9,0,3,1,6,2,4,8]

for i in range(len(array)):
    min_index = i # 가장 작은 원소의 인덱스
    for j in range(i+1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
        array[i], array[min_index] = array[min_index], array[i] # 스와프

print(array)

# 시간 복잡도 : O(N^2) : 퀵 정렬이나 기본 정렬 라이브러리에 비해 비효율적!
# 특정한 리스트에서 가장 작은 데이터를 찾을 때 쓰임
