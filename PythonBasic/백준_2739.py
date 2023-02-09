#백준_for문 구구단

input_data = int(input())

for i in range(1,10): #1부터 9까지
    print('{0} * {1} = {2}'.format(input_data, i, input_data *i))

#여기에서 확인해야 하는 것은 for문과 format함수의 이용이다.