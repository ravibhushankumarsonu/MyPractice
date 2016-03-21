//#include<stdio.h>
//#include<stdlib.h>
//
//void swap(int *x, int *y)
//{
//	int temp = *x;
//	*x = *y;
//	*y = temp;
//}
//
//void Sort(int arr[], int n)
//{
//	int i, j, min_idx;
//	for (i = 0; i < n - 1; i++)
//	{
//		min_idx = i;
//		for (j = i + 1; j < n; j++)
//		{
//			if (arr[j] < arr[min_idx])
//				min_idx = j;
//			
//		}
//		swap(&arr[min_idx], &arr[i]);
//	}
//}
//
//void printArray(int arr[], int n)
//{
//	int i;
//	for (i = 0; i < n; i++)
//		printf("%d\t",arr[i]);
//	printf("\n");
//}
//int main()
//{
//	int arr[] = { 10,2,1,4,5,3,6,9,8,7 };
//	printArray(arr, 10);
//	Sort(arr, 10);
//	printArray(arr, 10);
//	return 0;
//}