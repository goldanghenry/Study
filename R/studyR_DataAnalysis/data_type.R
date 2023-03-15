# 스칼라(Scala) : 구성인자가 1개인 벡터
s1 <- c(1)
s2 <- c("Kim")

# 벡터(Vector) : 동일한 유형의 데이터가 구성인자가 1개 이상이면서 1차원으로 구성되어 있는 데이터구조
v1 <- c(1, 2, 3)                   # 숫자형 벡터
v2 <- c("Kim", "Lee", "Choi")    # 문자형 벡터
v3 <- c(TRUE, TRUE, FALSE)   # 논리형 벡터

# 요인(factor) : 범주형 데이터 구조
# factor() 함수를 이용해서 문자형 벡터를 요인(factor)로 변환
# 단, 순서를 지정 안해주면 알파벳 순서로 수준(level)이 자동으로 지정
f1 <- c("Middle", "Low", "High")
f2 <- factor(f1)
f2

# 수준에 순서 부여
f3 <- factor(f2, order = TRUE, level = c("Low", "Middle", "High"))


# matrix()
m1 <- matrix(1:12, nrow=4)
m1

# byrow = 행기준 정렬
m2 <- matrix(1:12, byrow = TRUE, nrow = 4)
m2