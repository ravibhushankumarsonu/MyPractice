fro lxml import html
import requests

page=request.get('http://econpy.pythonanywhere.ccom/ex/001.html')
tree=html.fromstring(page.content)
