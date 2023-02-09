#백준_세자리수 곱셈 과정 표현

A = int(input())
B = input()

C = A * int(B[2])
D = A * int(B[1])
E = A * int(B[0])
F = A * int(B)

print(C,D,E,F, sep = '\n')

#여기에서 확인해야 할 것은 input값이 문자열 배열로 들어가서 B[]로 표현할 수 있다는 점이다.
#추가적으로 문자열로 들어가기 때문에 반드시 형변환을 해야 연산이 가능하다.