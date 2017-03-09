import xlrd
import matplotlib.pyplot as plt
import numpy as np
##book=xlrd.open_workbook('OGPA_LIST.xlsx')
##
##for sheet in book.sheets():
##    print(sheet.name)
##
##sheet=book.sheet_by_name('Worksheet')
##
##for i in range(sheet.nrows):
##    row=sheet.row_values(i)
##    print(row[1]+" "+row[2]+"\n")
        
    
book=xlrd.open_workbook('Patna.xls')
for sheet in book.sheets():
    print(sheet.name)
    
sheet=book.sheet_by_name('VD2001')

for i in range(sheet.nrows):
    row=sheet.row_values(i)
    if row[5] == "Daniawan":
        print(row[5]+" "+str(row[8]))
        

##for i in range(sheet.nrows):
##    row=sheet.row_values(i)
##    if float(row[9])+0.0>2000.0:
##        print(row[5]+" "+str(row[8]))
population=[]
village=[]
for i in range(1,sheet.nrows):
    row=sheet.row_values(i)
    if row[9]>0 and row[9]<5000:
        population.append(row[9])
        village.append(row[5])
        
##print(population)
##print(village)
print("Statistics of Patna district according to Censes 2001")
print("Village with maximum population "+str(max(population)))
for i in range(len(population)):
    if population[i]==max(population):
        print("Name of village with maximum population "+village[i])

print("Mean of the villages populations: "+str(np.mean(population)))
print("Variance of the villages populations: "+str(np.median(population)))

population_range=[0,500,1000,1500,2000,2500,3000,3500,4000,4500,5000]
plt.hist(population,population_range)

plt.xlabel('Population Range')
plt.ylabel('Frequencies of Villages')
plt.show()
