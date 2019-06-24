import pandas as pd
from datetime import datetime
import numpy as np

rangeDate = pd.date_range(start='1/1/2019',end='1/08/2019',freq='Min')
print(rangeDate)
print(type(rangeDate))
#Pandas DataFrame 


df = pd.DataFrame(rangeDate,columns=['date'])
df['Data'] = np.random.randint(0,100,size=(len(rangeDate)))
print(df)
print(df.head(10))


