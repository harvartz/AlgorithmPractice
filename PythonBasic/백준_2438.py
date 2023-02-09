#백준_별찍기 문제
#파이썬의 경우는 문자열을 더하고 곱할 수 있다는 강점이 있다.

input_data = int(input())
for i in range(1,(input_data+1)):
    print("*" * i)



#파이썬의 강점을 살리지 못한 코드
'''
inp = int(input())
for i in range(1, (inp+1)):
    for j in range(1, (i+1)):
        print("*",end="")
    print()
'''