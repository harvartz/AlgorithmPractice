n = int(input())
num = n
cnt = 0

while True:
    a = num//10
    b = num % 10
    c = (a+b) % 10
    num = (b*10) +c
    
    cnt = cnt +1
    if(num  == n):
        break
print(cnt)

# 이 문제와 같은 경우는 문제를 제대로 읽을 필요가 있다.
# 해당 문제는 계속 풀어보기