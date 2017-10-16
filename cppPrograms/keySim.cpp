/*
Author: Ravibhushan Kumar
College: IIT(ISM) Dhanbad
Email id: ravibhushankumarsonu@gmail.com
Linkdin: https://www.linkedin.com/in/ravibhushan-kumar-6ab881b0/
github : https://github.com/ravibhushankumarsonu 
*/
#include <bits/stdc++.h>
#define MOD 1000000007

using namespace std;
/*
@ = toggles caps lock on if off and vice versa, initially it is off.
# = inserts a new line at cursor position and shift cursor.
/ = deletes one character at left and points cursor at that position.
? = works as down arrow if cursor is at last line nothing changes.
^ = works as up arrow if cursor is at first line nothing changes.
*/

void print(vector<vector<char> >&mat,int col,int n){
	for(int i=0;i<=col;i++){
		for(int j=0;j<n;j++){
			printf("%c",mat[i][j]);
		}
		printf("\n");
	}
}

int main() {
	// your code goes here
	freopen("input.in","r",stdin);
    //freopen("output.out","w",stdout);
	string str;
	getline(cin,str);
	cout<<str<<endl;
	int n=str.length();
	vector<vector<char> >mat(n,vector<char>(n,' '));
	vector<int>last(n,0);
	int r=0;
	int col=0;
	bool caps=false;
	int i=0;
	int _max=r;
	while(i<n){
		char ch=static_cast<char>(str[i]);
		switch(ch){
			case '@':
				caps=!caps;
				break;
			case '#':
				r++;
				col--;
				break;
			case '/':
				mat[r][--col]='-';
				break;
			case '?':
				if(r!=_max){
					r++;
				}
				col=last[r];
				break;
			case '^':
				if(r!=0){
					r--;
				}
				col=last[r];
				break;
			default:
				//printf("%c",ch);
				mat[r][col++]=ch;
				last[r]=col;
				break;
		}
		i++;
		_max=max(r,_max);
	}
	print(mat,_max,n);
	printf("\n");
	return 0;
}
