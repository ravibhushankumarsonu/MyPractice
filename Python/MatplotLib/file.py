import matplotlib.pyplot as plt
##import csv
import numpy as np


##x=[]
##y=[]

##with open('example.txt','r') as csvfile:
##    plots=csv.reader(csvfile,delimiter=',')
##    for row in plots:
##        x.append(int(row[0]))
##        y.append(int(row[0]))
##
##plt.plot(x,y,label='Loaded from file')

x,y=np.loadtxt('example.txt',delimiter=',',unpack=True)
plt.bar(x,y)

plt.xlabel('x')
plt.ylabel('y')
plt.legend()
plt.show()
                 
