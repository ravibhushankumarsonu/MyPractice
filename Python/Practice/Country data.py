import csv
import numpy as np
import matplotlib.pyplot as plt

class Country:
    def __init__(self,Name,Income):
        self.Name=Name
        self.Income=Income

csvFile=open("Kaggle.csv",'r')

reader=csv.reader(csvFile)
Countries=[]
count=0
for row in reader:
    if(count>=1):
        Countries.append(Country(row[0],float(row[27])))
    count=count+1
    if row[0]=="India":
        print(count)
##        print(row[0]+" "+row[28])
##        count=count+1

x=[]
y=[]

for i in Countries:
    x.append(i.Name)
    y.append(i.Income)


xaxis=[i for i in range(0,len(x))]
plt.xticks(xaxis,x)
plt.plot(xaxis,y,color='g')
plt.xlabel("Country Name")
plt.ylabel("Per Capita Income")
plt.show()
