import numpy as np
import pandas as pa

#A = np.arange(21,30).reshape(3,3)
#print(A)
#B = np.arange(1,10).reshape(3,3)
#print(B)
#print(A.transpose())
#print(A.dot(B))
#print(B.dot(A))


InM = np.array([[1,2],[3,4]]).reshape(2,2)
print(InM)
SeM = np.array([[10,20],[30,40]]).reshape(2,2)
print(SeM)

AddM = np.add(InM,SeM)
print(AddM)
SubM = np.subtract(SeM,InM)
print(SubM)
DivM = np.divide(SeM,InM)
print(DivM)

DotProductM = np.dot(SeM,InM)
print(DotProductM)
Multiply = np.multiply(SeM,InM)
print(Multiply)

