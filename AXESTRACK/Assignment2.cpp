
//Assignment 2:
//Count which all bits are set in an unsigned 32 bit integer, the function
//should return an integer array which specifies what all bit position the 1 is set.
//e.g is the number is 4958, its binary expansion is "1001101011110"
//so your function should return an integer array like{ 1,2,3, 4,6,8,9,12 }
//i.e from LSB to MSB

//This code is written in VC++ and debugged in visual studio
#include<iostream>
#include<vector>

using namespace std;
typedef unsigned long long int ulli;
//Function to return the set bit position from LSB to MSB
vector<int> SetPosition(ulli input)
{
	vector<int>result;
	int i = 0;
	while (input > 0)
	{
		if (input % 2 == 1) {
			result.push_back(i);
		}
		i++;
		input /= 2;
	}

	return result;
}

int main()
{
	ulli input;
	cout << "Please enter the unsigned 32 bit integer :  ";
	cin >> input;
	vector<int>result;
	result = SetPosition(input);
	cout << "These are the position where bit of the given number is set: \n";
	if (result.empty()) {
		cout << "Please enter non zero number ";
	}
	else
	{
		for (int i = 0; i < result.size(); i++)
		{
			cout << result[i] << " ";
		}
	}
	cout << endl;
	return 0;
}