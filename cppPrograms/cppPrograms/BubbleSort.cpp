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
//	int i, j;
//	for (i = 0; i < n - 1; i++)
//	{
//		for (j = 0; j < n - i - 1; j++)
//			if (arr[j]>arr[j + 1])
//				swap(&arr[j], &arr[j + 1]);
//	}
//}
//
//void bubbleSort(int arr[], int n)
//{
//	int i, j;
//	bool swapped;
//	for (i = 0; i < n - 1; i++)
//	{
//		swapped = false;
//		for (j = 0; j < n - i - 1; j++)
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				swap(&arr[j], &arr[j + 1]);
//				swapped = true;
//			}
//		}
//
//		// IF no two elements were swapped by inner loop, then break
//		if (swapped == false)
//			break;
//	}
//}
//
//void printArray(int arr[], int n)
//{
//	int i;
//	for (i = 0; i < n; i++)
//		printf("%d\t", arr[i]);
//	printf("\n");
//}
//int main()
//{
//	int arr[] = { 10,2,1,4,5,3,6,9,8,7 };
//	printArray(arr, 10);
//	Sort(arr, 10);
//	printArray(arr, 10);
//	bubbleSort(arr, 10);
//	printArray(arr, 10);
//	return 0;
//}