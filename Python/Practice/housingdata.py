import pandas as pd
import matplotlib.pyplot as plt
import numpy as np


dataframe=pd.read_csv("Melbourne_housing.csv")
#print(dataframe.head())
#print(dataframe["Date"].head())
dataframe["Date"]=pd.to_datetime(dataframe["Date"],dayfirst=True)
#print(dataframe["Date"].head())
print(len(dataframe["Date"].unique())/4)


var=dataframe[dataframe["Type"]=="h"].sort_values("Date",ascending=False).groupby("Date").std()
#print(var)
count=dataframe[dataframe["Type"]=="h"].sort_values("Date",ascending=False).groupby("Date").count()
#print(count)
mean=dataframe[dataframe["Type"]=="h"].sort_values("Date",ascending=False).groupby("Date").mean()
#print(mean)

#mean["Price"].plot(yerr=var["Price"],ylim=(400000,1500000))

means = dataframe[(dataframe["Type"]=="h") & (dataframe["Distance"]<13)].dropna().sort_values("Date", ascending=False).groupby("Date").mean()
errors = dataframe[(dataframe["Type"]=="h") & (dataframe["Distance"]<13)].dropna().sort_values("Date", ascending=False).groupby("Date").std()
#means.plot(yerr=errors)

pd.set_eng_float_format(accuracy=1, use_eng_prefix=True)
ListItem=dataframe[(dataframe["Type"]=="h") &
                   (dataframe["Distance"]<14) &
                   (dataframe["Distance"]>13.7)
                   #&(dataframe["Suburb"] =="Northcote")
                   ].sort_values("Date", ascending=False).dropna().groupby(["Suburb","SellerG"]).mean()

print(ListItem)
plt.grid(True)
plt.show()
