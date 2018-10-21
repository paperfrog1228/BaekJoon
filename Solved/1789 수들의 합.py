# O(n) 으로 풀었지만
# 수식으로 O(1)로도 해결 가능

s = int(input())
n = 0
for i in range(1, s+1):
    if s < i:
        break
    n += 1
    s -= i
print(n)
