# fruit={"mango","apple","banana","1","2","1"}
# print(type(fruit))
# print(fruit)

num1={1,2,3,4,5}
num2={3,4,5,6,7}

# for num in num1:
#     print(num)
print(num1.union(num2))
print(num1.intersection(num2))
print(num1.difference(num2))
print(num2.difference(num1))

print(num1.issuperset(num2))
print(num1.issubset(num2))
trainee1={"arti","amita","amandeep",1}
trainee2={"arti","anisha","amey"}
print(trainee1.union(trainee2))
