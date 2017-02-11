#include<iostream>
#include<vector>

using namespace std;

int main()
{
	int t;
	cin>>t;
	int ans=0;
	while(t--)
	{
		int x1,y1,x2,y2;
		cin>>x1>>y1>>x2>>y2;
		int l=(x2-x1+1);
		int w=(y2-y1+1);
		ans+=(w*l);
	}
	cout<<ans<<endl;
	return 0;
}