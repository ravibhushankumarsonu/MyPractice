#include<bits/stdc++.h>

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

int ToInt(string str){
    int a=str[0]-'0';
    for(int i=1;i<str.length();i++){
        a=a*10+(str[i]-'0');
    }
    return a;
}


int main(){
    string str;
    freopen("text.txt","r",stdin);
    getline(cin,str);
    //cout<<str<<endl;
    vector<string>arr =str2vec(str);
    
    print(arr);
    getline(cin,str);
    vector<string>pattern=str2vec(str);
    print(pattern);

    int p=0;
    for(int i=0;i<pattern.size();i++){
        //cout<<pattern[i]<<" "<<pattern[i].length()<<" ";
        if(pattern[i]=="{}"){
            pattern[i]=arr[p++];
        }else if(pattern[i][0]=='{'){
            string temp="";
            for(int j=1;j<pattern[i].length()-1;j++)temp+=pattern[i][j];
           // cout<<temp<<" ";
            if(temp[0]<'0'||temp[0]>'9'){
                pattern[i]=temp;
            }else{
                int index=ToInt(temp);
                pattern[i]=arr[index];
            }
        }
        //cout<<pattern[i]<<" "<<pattern[i].length()<<" ";
    }
    print(pattern);
    return 0;
}
