import pandas as pd

df = pd.read_html('https://simple.wikipedia.org/wiki/List_of_countries')
print(df)
