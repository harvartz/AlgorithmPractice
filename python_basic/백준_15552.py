#백준 input()말고 다른 입력 함수 사용하기

import sys

test_case = int(input())

for _ in range(test_case):
    input_data = sys.stdin.readline().rstrip().split(' ')
    print(int(input_data[0]) + int(input_data[1]))

#여기에서 확인해야 할 것은 input()과 sys.stdin.readline.rstrip()의 차이이다.
#pypy3는 python3보다 연산속도는 빠르지만 메모리를 더 많이 소비한다.