/*
Author: Ravibhushan Kumar
College: IIT(ISM) Dhanbad
Email id: ravibhushankumarsonu@gmail.com
Linkdin: https://www.linkedin.com/in/ravibhushan-kumar-6ab881b0/
github : https://github.com/ravibhushankumarsonu 
*/
#include <bits/stdc++.h>
#define MOD 1000000007
/*
1. ECHO 1: prints the number. Eg. ECHO 1 prints 1
2. Exit: exits the program.
3. SET a 0: assign variable a value 0.
4. ADD 2 3 z: this means z = 2+3 assign sum of first two values to third one.
5. GOTO and LABEL: works as label and Goto defined in c language but label can be before or after goto
6. IF and END: If IF condition is true then statements between IF and END commands get executed otherwise not. Eg. IF a 10 statement1 statement2 END i.e., if a=10.
7. CONTINUE: works as defined in c language.
*/

using namespace std;

vector<string> str2vec(string str){
    vector<string>arr;
    string temp="";
    for(int i=0;i<str.length();i++){
        //cout<<temp<<" ";
        if(str[i]==' '){
            if(temp.length()>0){
                arr.push_back(temp);
                temp="";
            }
        }else{
            temp+=str[i];
        }
    }
    if(temp.length()>0){
        arr.push_back(temp);
    }
    return arr;
}

void print(vector<string>&arr){
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main() {
	// your code goes here
	freopen("output.txt","r",stdin);
    //freopen("output.out","w",stdout);
	int i=0;
	string str;
	//To store the program data
	unordered_map<int,vector<string> >store;
	//To store the variable during the execution
	vector<int>variable(26,0);
	//to store the Labels
	map<string,int>Label;
	while(1){
		getline(cin,str);
		if(str=="")break;
		store[i]=str2vec(str);
		//cout<<str<<endl;
		i++;
	}
	int last=i-1;
	//cout<<last<<endl;
	/*for(int i=0;i<=last;i++){
		print(store[i]);
	}*/


	//Body of solutions
	i=0;
	while(i<=last){
		//cout<<i<<" ";
		if(store[i][0]=="ECHO"){
			if(isalpha(store[i][1][0])){
				cout<<variable[store[i][1][0]-'a']<<endl;
			}else{
				cout<<store[i][1]<<endl;
			}
		}else if(store[i][0]=="SET"){
			variable[store[i][1][0]-'a']=stoi(store[i][2]);
		}else if(store[i][0]=="EXIT"){
			break;
		}else if(store[i][0]=="LABEL"){
			Label[store[i][1]]=i;
		}else if(store[i][0]=="ADD"){
			int a,b;
			if(isalpha(store[i][1][0])){
				a=variable[store[i][1][0]-'a'];
			}else{
				a=stoi(store[i][1]);
			}
			if(isalpha(store[i][2][0])){
				b=variable[store[i][2][0]-'a'];
			}else{
				b=stoi(store[i][2]);
			}
			variable[store[i][3][0]-'a']=a+b;
		}else if(store[i][0]=="GOTO"){
			if(Label.find(store[i][1])!=Label.end()){
				i=Label[store[i][1]];
			}else{
				cout<<"Error in Program"<<endl;
			}
		}else if(store[i][0]=="IF"){
			if(variable[store[i][1][0]-'a']!=stoi(store[i][2])){
				while(store[i][0]!="END"){
					i++;
				}
			}
		}else if(store[i][0]=="END"){
			//Do nothing //End of loop
		}else if(store[i][0]=="CONTINUE"){
				while(store[i][0]!="END"){
					i++;
				}
		}else{
			cout<<"Sytex error"<<endl;
		}
		i++;
	}
	return 0;
}
