numbers = []

for x in range(9):
    x = int(input())
    numbers.append(x)

print(max(numbers))
print(numbers.index(max(numbers))+1)