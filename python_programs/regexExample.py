import re
string="This is manual training 9809090909"
matching=re.search("\d{10}",string)

findOccurances=re.findall("is",string)
print(matching)
print(findOccurances)

