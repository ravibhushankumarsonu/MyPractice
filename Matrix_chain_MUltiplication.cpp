#include<iostream>
#include<vector>
#include<limits>

using namespace std;
void print_Multi(vector<vector<int>>s_array, int i, int j)
{
	if (i == j)
		cout << 'A' << i;
	else
	{
		cout << '(';
		print_Multi(s_array, i, s_array[i][j]);
		print_Multi(s_array, s_array[i][j] + 1, j);
		cout << ')';
	}
}


void MCO(vector<int> array)
{
	int n = array.size();
	//cout << n << endl;
	vector<vector<int>>m_array(n, vector<int>(n));
	vector<vector<int>>s_array(n-1, vector<int>(n));

	for (int i = 1; i < n; i++)
		m_array[i][i] = 0;

	for (int l = 2; l < n; l++)
	{
		for (int i = 1; i < n - l +1; i++)
		{
			int j = i + l - 1;
			m_array[i][j] = INT_MAX;
			for (int k = i; k <= j-1; k++)
			{
				int q = m_array[i][k] + m_array[k + 1][j] + array[i-1] * array[j] * array[k];
				if (q < m_array[i][j])
				{
					m_array[i][j] = q;
					s_array[i][j] = k;
				}
			}
		}
	}
	cout << m_array[1][n - 1] << endl;
	print_Multi(s_array, 1, n - 1);
}
int main()
{
	/*vector<int> array;
	cout << "Enter the number of element in Vector:\t";
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int number;
		cin >> number;
		array.push_back(number);
	}*/
	vector<int>array = { 30,35,15,5,10,20,25 };
	MCO(array);
	return 0;
}
