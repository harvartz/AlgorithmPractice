# 백준_배열에 숫자 비교하기

N, X = map(int, input().split())
A = list(map(int, input().split()))
for i in range(N):
    if A[i] < X:
        print(A[i], end=" ")



# 처음에 생각했던 틀린 코드
# map, list를 사용할 생각을 못했다.
# map함수를 사용하여 한 커맨드에 입력값을 나눠서 int값으로 저장하고,
# 리스트를 사용하여 A 변수에 여러 숫자를 한번에 넣었다.

"""
N = int(input())
X = int(input())
A = input().split(' ')
for i in range(1, N+1):
  if(int(A[i])<X):
    print(A[i] + " ")
"""