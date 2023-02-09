while True:
    try:
        a, b = map(int, input().split(' '))
    except:
        break
    print(a+b)

# try-except구문
"""
try 구문에는 에러가 발생할 여지가 있는 문장을 작성한다.
except 구문에는 에러 발생 시 실행시킬 문장을 작성한다. 해당 코드에서는 break를 사용하여 빠져나왔다.

try-except은 구문 오류가 발생할 때 해결할 수 있는 코드이다.

# Tip : except구문에 print()함수를 사용하여 무한 루프를 유지시킬 수 있다.

"""