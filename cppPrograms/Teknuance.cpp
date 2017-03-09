#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<utility>

using namespace std;

void MatrixPrint(vector<vector<double>>arr)
{
	int rows = arr.size();
	for (int i = 0; i < rows; i++)
	{
		int cols = arr[i].size();
		for (int j = 0; j < cols; j++)
			cout << arr[i][j] << " ";
		cout << endl;
	}
	return;
}
bool compare(vector<double>arr1, vector<double>arr2)
{
	for (int i = 0; i < arr1.size(); i++)
	{
		return (arr1[i] < arr2[i]);
	}
	return true;
}
int main()
{
	//Matrix with the structure of y,x1,x2,x3,x4,x5
	vector<vector<double>>arr = { { 29,33,53,3.32,3.42,0.32},
								 {24,31,36,3.10,3.26,0.20},
								 {26,33,51,3.18,3.18,0.18},
								 {22,37,51,3.39,3.08,0.18},
								 {27,36,54,3.20,3.41,0.40},
								 {21,35,35,3.03,3.03,1.01},
								 {33,59,56,4.78,4.57,0.90},
								 {34,60,60,4.72,4.72,0.71},
								 {32,59,60,4.60,4.41,0.54},
								 {34,60,60,4.53,4.53,0.51},
								 {20,34,35,2.90,2.95,0.24},
								 {36,60,59,4.40,4.36,0.43},
								 {34,60,62,4.31,4.42,0.42},
								 {23,60,36,4.27,3.94,0.36},
								 {24,62,38,4.41,3.49,0.41},
								 {32,62,61,4.39,4.39,0.39},
								 {40,90,64,7.32,3.42,0.70},
								 {46,90,60,7.32,3.26,0.71},
								 {55,92,92,7.45,3.18,0.75},
								 {52,91,92,7.27,3.08,0.78},
								 {29,61,62,3.91,3.41,0.56},
								 {22,59,42,3.75,3.03,0.45},
								 {31,88,65,6.48,4.57,0.46},
								 {45,91,89,6.70,4.72,0.66},
								 {37,63,62,4.02,4.41,0.56},
								 {37,60,61,4.02,4.53,0.53},
								 {33,60,62,4.02,2.95,0.35},
								 {27,59,62,3.98,4.36,0.43},
								 {34,59,62,4.39,4.42,0.43},
								 {19,37,35,2.75,3.94,0.36},
								 {16,35,35,2.59,3.49,0.33},
								 {22,37,37,2.73,4.39,0.31} };
	//MatrixPrint(arr);
	//This function sort the matrix row-wise according to their increasing value within rows
	//So we can get the query which has minimal cost within that
	sort(arr.begin(), arr.end(),compare);
	//MatrixPrint(arr);
	//To print the query with minimal cost
	cout << "Minimal cost is " << arr[0][0] << endl;
	    /*y = Cost
		x1 = Runtime cost of evaluating the query
		x2 = Number of I / O operations required
		x3 = CPU Path Length
		x4 = Amount of disk buffer space
		x5 = Disk storage service time*/
	cout << "Query Parameter\n";
	cout << "x1 = Runtime cost of evaluating the query " << arr[0][1] << endl;
	cout << "x2 = Number of I / O operations required " << arr[0][2] << endl;
	cout << "x3 = CPU Path Length " << arr[0][3] << endl;
	cout << "x4 = Amount of disk buffer space " << arr[0][4] << endl;
	cout << "x5 = Disk storage service time " << arr[0][5]<<endl;
	for (int i = 0; i < arr[0].size(); i++)
	{
		cout <<arr[0][i]<<" ";
	}
	cout << endl;
	return 0;
}