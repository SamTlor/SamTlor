nums = [1,2,3,4,5,6,7]
k = 3


dif_nums = nums[-3:]
dif_nums += nums[:-3]

print(dif_nums)