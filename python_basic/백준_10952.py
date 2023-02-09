a, b = 0,0

while True:
    a,b == map(int, input().split(' '))
    if a == 0 and b== 0:
        break
    print(a+b)




# 밑에 처음 생각한 코드처럼 일일히 int로 형변환 해주는 것 보다는 map을 사용하자.
# 헷갈리지 말자. break은 조건문에 으해 반복문을 탈출하는 키워드이다. 조건문만 나오는게 아니다.

"""
input_data = input().split(' ')

while int(input_data[0]) == 0 and int(input_data[1]==0):
    print(int(input_data[0] + int(input_data[1])))
    input_data = input().split(' ')

"""

