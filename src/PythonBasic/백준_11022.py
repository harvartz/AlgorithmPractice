input_data = int(input())

for i in range(1,input_data+1):
  X = input().split(' ')
  print('Case #{0}: {1}'.format(i, int(X[0])+int(X[1])))


"""
# map이란 map은 입력받은 자료형의 각 요소를 함수 f가 수행한 결과를 묶어서 돌려주는 함수이다.
# map함수를 활용해서 문제를 풀었을 때,
  for i in range(1,input_data+1):
    a,b = map(int, input().split())
    print("Case #"+str(i)+':',a+b)
"""