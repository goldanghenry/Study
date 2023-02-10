# 성적이 낮은 순서로 학생 출력하기
# 기출 : D 기업 프로그래밍 콘테스트 예선

# N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다. 
# 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을
# 작성하시오.

n = int(input())

L =[]
for i in range(n):
   input_data = input().split()
   L.append((input_data[0],int(input_data[1])))

def setting(data):
    return data[1]

L.sort(key=setting)

for i in L:
    print(i[0], end=' ')
