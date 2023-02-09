a = int(input())
sub_list = list(map(int, input().split()))
max_score = max(sub_list)

new_list = []
for i in sub_list:
    new_list.append(i / max_score * 100)
list_sum = sum(new_list)/a

print(list_sum)

# n = int(input())  # 과목 수
# test_list = list(map(int, input().split()))
# max_score = max(test_list)

# new_list = []
# for score in test_list :
#     new_list.append(score/max_score *100)  # 새로운 점수 생성
# test_avg = sum(new_list)/n
# print(test_avg)