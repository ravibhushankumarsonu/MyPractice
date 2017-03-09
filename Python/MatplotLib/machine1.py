import matplotlib.pyplot as plt
from numpy import *
import operator

##string_x="number of kicks in the movie"
##string_y="number of kisses in the movie"
##x=[3,2,1,101,99,98,18]
##y=[104,100,81,10,5,2,90]
##plt.plot(x,y,'ro')
##plt.xlabel(string_x)
##plt.ylabel(string_y)
##plt.grid()
##plt.show()

def createDataSet():
    group=array([[1.0,1.1],[1.0,1.0],[0,0],[0,0.1]])
    labels=['A','A','B','B']
    return group,labels


def classify0(inX,dataSet,labels,k):
    dataSetSize=dataSet.shape[0]
    diffMat=tile(inX,(dataSetSize,1))-dataSet
    sqDiffMat=diffMat**2
    sqDistances=sqDiffMat.sum(axis=1)
    distances=sqDistances**0.5
    sortedDistIndices=distances.argsort()
    classCount={}
    for i in range(k):
        voteIlabel=labels[sortedDistIndices[i]]
        classCount[voteIlabel]=classCount.get(voteIlabel,0)+1
    sortedClassCount=sorted(classCount.iteritems(),key=operator.itemgetter(1),reverse=True)
    return sortedClassCount[0][0]

group,labels=createDataSet()
print(classify0([0,0],group,labels,3))
##x=[]
##y=[]
##matrix=mat(group)
####print(matrix.shape[0])
##for i in range(group.shape[0]):
##    x.append(group[i][0])
##    y.append(group[i][1])
##print(x)
##print(y)
##plt.plot(x,y,'rx',markerSize='10')
##plt.xlabel("xdata")
##plt.ylabel("ydata")
##plt.grid()
##plt.axis(xmin=-0.5,xmax=1.5,ymin=-0.5,ymax=1.5)
##plt.show()
