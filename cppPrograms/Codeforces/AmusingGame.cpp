#include<iostream>
#include<vector>
#include<string>
#include<string.h>


using namespace std;

int main()
{
	vector<int>arr(26, 0);
	vector<int>arr1(26, 0);
	string s1, s2, s3;
	cin >> s1 >> s2 >> s3;
	//cout << s1 << " " << s2 << " " << s3 << " ";
	for (int i = 0; i<s1.length(); i++)
	{
		arr[s1[i] - 65]++;
	}
	for (int i = 0; i<s2.length(); i++)
	{
		arr[s2[i] - 65]++;
	}
	for (int i = 0; i<s3.length(); i++)
	{
		arr1[s3[i] - 65]++;
	}
	bool ans = true;
	for (int i = 0; i<26; i++)
	{
		//cout << arr[i] << arr1[i] << " ";
		if (arr[i] != arr1[i])
		{
			ans = false;
			break;
		}
	}
	if (ans == true)
		cout << "YES" << endl;
	else
		cout << "NO" << endl;
	return 0;
}