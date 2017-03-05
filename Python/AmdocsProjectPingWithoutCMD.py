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

