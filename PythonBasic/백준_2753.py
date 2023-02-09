#백준_2753 윤년 구하기

year = int(input())

if (year %4 == 0 and year % 100 !=0) or year % 400 ==0:
  print('1')
else:
  print('0')

# 여기에서 확인할 점은 if 문과 and, or 쓰는 방법이다.

