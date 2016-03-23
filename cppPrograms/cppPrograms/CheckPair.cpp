#include<stdio.h>
#include<stdlib.h>

void swap(int *x, int *y)
{
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}

void Sort(int* arr, int n)
{
	int i, j;
	for (i = 0; i < n-1; i++)
	{
		for (j = 0; j < n - i - 1; j++)
		{
			if (arr[j] > arr[j + 1])
				swap(&arr[j], &arr[j + 1]);
		}
	}
}

bool IsAvaliable(int* arr, int n, int sum)
{
	int l = 0;
	int u = n - 1;
	while (l<u)
	{
		if (arr[l] + arr[u] == sum)
			return true;
		else if (arr[l] + arr[u] < sum)
			l++;
		else
		{
			u--;
		}
	}
	return false;
}

int main()
{
	int arr[] = { 4,6,2,8,12,34,54,12,12,13 };
	int sum = 25;
	int size_arr = 10;
	if (IsAvaliable(arr, size_arr, sum))
	{
		printf("two elements with sum %d is presents in the array.\n", sum);

	}
	else
		printf("two elements with sum %d is not presents in the array.\n", sum);

	return 0;
}