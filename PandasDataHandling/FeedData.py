import pandas as pd 
InpData = pd.read_csv('DTCTLVENMNM.csv')
FormatedInputData = pd.read_csv('DTCTLVENMM.csv',sep=',',encoding='latin-1',nrows=5,skiprows=[2,3])
print(type(FormatedInputData))

