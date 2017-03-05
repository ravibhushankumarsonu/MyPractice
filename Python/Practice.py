##import matplotlib.pyplot as plt
##import numpy as np
##import math
##
##x=np.linspace(0,100,101)
####print(x)
##l=np.linspace(1,25,25)
##clr=000000
##y=[]
##for j in range(len(l)):
##    y.clear()
##    for i in range(len(x)):
##        y.append((((np.e**(-l[j]))*(l[j]**x[i])))/math.factorial(x[i]))
##        clr=clr+100
##        plt.plot(x,y,color='#'+str(clr))
##plt.show()

##------4th-March-2017---------------##
##import matplotlib.pyplot as plt
##import numpy as np
##mu,sigma=100,15
##x=mu+sigma*np.random.randn(10000)
##
##n,bins,patches=plt.hist(x,50,normed=1,facecolor='g',alpha=0.75)
##
##plt.xlabel('Smarts')
##plt.ylabel('probability')
##plt.title('Histogram of IQ')
##plt.text(60,0.025,r'$\mu=100,\ \sigma=15$')
##plt.axis([40,160,0,0.03])
##plt.grid(True)
##plt.show()


####2
##import numpy as np
##import matplotlib.pyplot as plt
##import matplotlib.animation as animation
##
##def data_gen(t=0):
##    cnt=0
##    while cnt<1000:
##        cnt+=1
##        t+=0.1
##        yield t,np.sin(2*np.pi*t)*np.exp(-t/10)
##
##def init():
##    ax.set_ylim(-1.1,1.1)
##    ax.set_xlim(0,10)
##    del xdata[:]
##    del ydata[:]
##    line.set_data(xdata,ydata)
##    return line,
##
##fig,ax=plt.subplots()
##line,=ax.plot([],[],lw=2)
##ax.grid()
##xdata,ydata=[],[]
##
##def run(data):
##    t,y=data
##    xdata.append(t)
##    ydata.append(y)
##    xmin,xmax=ax.get_xlim()
##
##    if t>=xmax:
##        ax.set_xlim(xmin,2*xmax)
##        ax.figure.canvas.draw()
##    line.set_data(xdata,ydata)
##
##    return line
##
##ani=animation.FuncAnimation(fig,run,data_gen,blit=False,
##                            interval=10,repeat=False,init_func=init)
##
##plt.show()


##import matplotlib.pyplot as plt
##import numpy as np
##
##x=[1,2,3,4]
##y=[3,4,2,5]
##plt.bar(x,y,width=0.8)
##plt.show()

#---------5th March 2017-------#

##import subprocess
##
###host = "www.google.com"
##host="localhost"
##
##ping = subprocess.Popen(
##    ["ping", "-c", "4", host],
##    stdout = subprocess.PIPE,
##    stderr = subprocess.PIPE
##)
##
##out, error = ping.communicate()
##print(out)

##import os
##import subprocess
##hostname = "localhost" 
##DETEACHED_PROCESS=8;
###response = os.system("ping-c 1 " + hostname)
##response=subprocess.call("ping -n 1"+hostname,creationflags=DETEACHED_PROCESS)
##
##if response == 0:   
##    print (hostname, 'is up!')
##else:
##    print (hostname, 'is down!')
    
##import os
##hostname = "localhost" #example
##response = os.system("ping -c 1 " + hostname)
##print(response)
###and then check the response...
##if response == 0:
##  print (hostname, 'is up!')
##else:
##  print (hostname, 'is down!')


### Import modules
##import subprocess
##import ipaddress
##
### Prompt the user to input a network address
##net_addr = input("Enter a network address in CIDR format(ex.192.168.1.0/24): ")
##
### Create the network
##ip_net = ipaddress.ip_network(net_addr)
##
### Get all hosts on that network
##all_hosts = list(ip_net.hosts())
##
### Configure subprocess to hide the console window
##info = subprocess.STARTUPINFO()
##info.dwFlags |= subprocess.STARTF_USESHOWWINDOW
##info.wShowWindow = subprocess.SW_HIDE
##
### For each IP address in the subnet, 
### run the ping command with subprocess.popen interface
##for i in range(len(all_hosts)):
##    output = subprocess.Popen(['ping', '-n', '1', '-w', '500', str(all_hosts[i])], stdout=subprocess.PIPE, startupinfo=info).communicate()[0]
##    
##    if "Destination host unreachable" in output.decode('utf-8'):
##        print(str(all_hosts[i]), "is Offline")
##    elif "Request timed out" in output.decode('utf-8'):
##        print(str(all_hosts[i]), "is Offline")
##    else:
##        print(str(all_hosts[i]), "is Online")


##This is working without cmd
import subprocess
import ipaddress
ip_net="172.16.92.1"
##ip_net="www.google.com"

info = subprocess.STARTUPINFO()
info.dwFlags |= subprocess.STARTF_USESHOWWINDOW
info.wShowWindow = subprocess.SW_HIDE
##output = subprocess.Popen(['ping', '-n', '1', '-w', '500', str(ip_net)], stdout=subprocess.PIPE, startupinfo=info).communicate()[0]
output = subprocess.Popen(['ping', '-n', '1', '-w', '500', str(ip_net)], stdout=subprocess.PIPE, startupinfo=info).communicate()
print(output[0].decode())

if "Destination host unreachable" in output[0].decode('utf-8'):
        print(str(ip_net), "is Offline")
elif "Request timed out" in output[0].decode('utf-8'):
        print(str(ip_net), "is Offline")
else:
        print(str(ip_net), "is Online")

