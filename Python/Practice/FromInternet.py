import matplotlib.pyplot as plt
import numpy as np
import urllib
import datetime as dt
import matplotlib.dates as mdates


def bytespdate2num(fmt,encoding='utf-8'):
    strconverter=mdates.strpdate2num(fmt)
    def bytesconverter(b):
        s=b.decode(encoding)
        return strconverter(s)
    return bytesconverter


def graph_data(stock):

    fig=plt.figure()
    ax1=plt.subplot2grid((1,1),(0,0))

    
    stock_price_url='http://chartapi.finance.yahoo.com/instrument/1.0/'+stock+'/chartdata;type=quote;range=10y/csv'

    source_code=urllib.request.urlopen(stock_price_url).read().decode()

    stock_data=[]
    split_source=source_code.split('\n')

    for line in split_source:
        split_line=line.split(',')
        if len(split_line)==6:
            if 'values' not in line and 'labels' not in line:
                stock_data.append(line)

    date,closep,highp,lowp,openp,volume=np.loadtxt(stock_data,
                                                   delimiter=',',
                                                   unpack=True,
                                                   #%Y =full year.2015
                                                   #%y =parilat year
                                                   #%m=number month
                                                   #d=number day
                                                   #%H=hours
                                                   converters={0: bytespdate2num('%Y%m%d')})

    ax1.plot_date(date,closep,'-',label='Price')
    ax1.plot([],[],linewidth=5,label='loss',color='r',alpha=0.5)
    ax1.plot([],[],linewidth=5,label='gain',color='g',alpha=0.5)

    ax1.fill_between(date,closep,closep[0],where=(closep>closep[0]),facecolor='g',alpha=0.5)
    ax1.fill_between(date,closep,closep[0],where=(closep<closep[0]),facecolor='r',alpha=0.5)
    ax1.grid(True)
    for label in ax1.xaxis.get_ticklabels():
        label.set_rotation(45)
        
    plt.xlabel('date')
    plt.ylabel('price')
    plt.title('Graph')
    plt.legend()
    plt.subplots_adjust(left=0.09,bottom=0.20,right=0.94,top=0.95,wspace=0.2,hspace=0)
    plt.show()

graph_data('aapl')

