#별 반대로 찍기

a = int(input())
for i in range(1,a+1):
    print(" " * (a-i) + "*" * i)