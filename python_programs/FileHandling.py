file=open("ibm.txt","w")
file.write("stu1 phy 65\n")
file.write("stu2 phy 69\n")
file.write("stu3 phy 72\n")
file.close()
file=open("ibm.txt","r")
lines=file.readlines()
file.close()
file=open("ibm.txt","a")
for l in lines:
    var=l.split(" ")
    var[2]=var[2].replace("\n","")
    var[2]=int(var[2])+10
    line=var[0]+" "+var[1]+ " "+str(var[2])+ "\n"
   # print(line)
    file.write(line)
#print(lines)
file.close()

