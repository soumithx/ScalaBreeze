import pandas as pd
'''
sr = pd.Series(['2012-10-21 09:30','2013-12-03 10:30','1995-02-11 06:30'])
dayIndex = ['Day 1','Day 2','Day 3']
sr.index = dayIndex
sr = pd.to_datetime(sr)
result = sr.dt.time
print(sr)
print(result)
'''

pandasSeries = pd.Series(pd.date_range('2019-01-12',periods=5,freq='H'))
indexofSeries = ['Day1','Day2','Day3','Day4','Day5']
pandasSeries.index = indexofSeries
print(pandasSeries)
SeriesTime = pandasSeries.dt.time
print(SeriesTime)


